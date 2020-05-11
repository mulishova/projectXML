package study.projectXML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ClassSAX extends DefaultHandler {
    private String result;

    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        result += "Element name - '" + qName + "'\n"; // имя тэга

        for (int i = 0; i < atts.getLength(); i++) { // атрибуты тэга
            result += "Attribute name = '" + atts.getQName(i) + "'; Attribute value - '" + atts.getValue(i) + "\n";
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        // закрываем тэг
        result += "Element closed, name = '" + qName + "'\n";
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }

    public String getResult () {
        return result;
    }

}
