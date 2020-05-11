package study.projectXML;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        // 1
        //ClassDom objectDOM = new ClassDom();
        //objectDOM.parseAndPrint("menu.xml");

        // 2
        final String PATH = "menu.xml";
        File input = new File(PATH);

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ClassSAX handler = new ClassSAX();
            parser.parse(input, handler);
            System.out.println("SAX parser result:\n" + handler.getResult());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // 3

    }
}
