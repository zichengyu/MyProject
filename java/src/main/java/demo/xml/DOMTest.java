//package test.xml;
//
//
//
//
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.swing.text.Document;
//import javax.swing.text.Element;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.File;
//import java.io.IOException;
//
///**
// * User: 20160301301
// * Date: 2017/9/11 21:19
// * Comment:
// */
//public class DOMTest {
//
//    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
//            .newInstance();
//
//    public static void main(String[] args) {
//        DOMTest parser = new DOMTest();
//        Document document = parser.parse("books.xml");
//        /* get root element */
//        Element rootElement = document.getDocumentElement();
//
//        /* get all the nodes whose name is book */
//        NodeList nodeList = rootElement.getElementsByTagName("book");
//        if (nodeList != null) {
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                /* get every node */
//                Node node = nodeList.item(i);
//                /* get the next lever's ChildNodes */
//                NodeList nodeList2 = node.getChildNodes();
//                for (int j = 0; j < nodeList2.getLength(); j++) {
//                    Node node2 = nodeList2.item(j);
//                    if (node2.hasChildNodes()) {
//                        System.out.println(node2.getNodeName() + ":"
//                                + node2.getFirstChild().getNodeValue());
//                    }
//                }
//            }
//        }
//    }
//
//    /* Load and parse XML file into DOM */
//    public Document parse(String filePath) {
//        Document document = null;
//        try {
//            /* DOM parser instance */
//            DocumentBuilder builder = builderFactory.newDocumentBuilder();
//            /* parse an XML file into a DOM tree */
//            document = builder.parse(new File(filePath));
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return document;
//    }
//}