import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParserExample {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("example.xml"));

        NodeList nodeList = document.getElementsByTagName("record");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Node child = node.getFirstChild();
            System.out.println("type: \"" + node.getAttributes().getNamedItem("type").getNodeValue() + "\"");
            do {
                while (child != null && child.getNodeType() != Node.ELEMENT_NODE) {
                    child = child.getNextSibling();
                }
                if (child == null) {
                    break;
                }
                System.out.println(child.getNodeName() + ": \"" + child.getFirstChild().getNodeValue()+"\"");
                child = child.getNextSibling();
            } while (child != null);
            System.out.println();
        }

    }
}