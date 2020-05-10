package study.projectXML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ClassDom {

    public void parseAndPrint (String name) {
        Document doc = null;

        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            doc = db.parse(name);

            if (doc != null) {
                printDomTree(doc);
            }
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e);
        }
    }

    public void printDomTree (Node node) {
        int type = node.getNodeType();

        switch (type)
        {
            case Node.DOCUMENT_NODE: // корень дерева
            {
                System.out.println("<?xml version=\"1.0\" ?>");
                printDomTree(((Document)node).getDocumentElement()); // рекурсивно проходимся по остальным элементам

                break;
            }

            case Node.ELEMENT_NODE: // тэг
            {
                System.out.print("<"); // открываем тэг
                System.out.print(node.getNodeName());

                NamedNodeMap attributes = node.getAttributes();

                for (int i = 0; i < attributes.getLength(); i++) {
                    printDomTree(attributes.item(i));
                }

                System.out.print(">"); // закрываем тэг

                if(node.hasChildNodes()) { // дочерние узлы
                    NodeList children = node.getChildNodes();

                    for (int i = 0; i < children.getLength(); i++) {
                        printDomTree(children.item(i));
                    }
                }

                System.out.print("</");
                System.out.print(node.getNodeName());
                System.out.print('>');

                break;
            }

            case Node.ATTRIBUTE_NODE:
            {
                System.out.print(" " + node.getNodeName() + "=\"" + ((Attr)node).getValue() + "\"");

                break;
            }

            case Node.TEXT_NODE: // текст
            {
                System.out.println(node.getNodeValue());

                break;
            }
        }
    }

}
