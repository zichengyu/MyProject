package demo.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: 20160301301
 * Date: 2017/9/11 21:25
 * Comment:
 */
public class SAXTest {
    class BookHandler extends DefaultHandler {
        private List<String> nameList;
        private boolean title = false;

        public List<String> getNameList() {
            return nameList;
        }

        // Called at start of an XML document
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start parsing document...");
            nameList = new ArrayList<String>();
        }

        // Called at end of an XML document
        @Override
        public void endDocument() throws SAXException {
            System.out.println("End");
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes atts) throws SAXException {
            // Using qualified name because we are not using xmlns prefixes
            // here.
            if (qName.equals("title")) {
                title = true;
            }
        }

        @Override
        public void endElement(String namespaceURI, String localName,
                               String qName) throws SAXException {
            // End of processing current element
            if (title) {
                title = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Processing character data inside an element
            if (title) {
                String bookTitle = new String(ch, start, length);
                System.out.println("Book title: " + bookTitle);
                nameList.add(bookTitle);
            }
            System.out.println(new String(ch, start, length));
        }

    }

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        BookHandler bookHandler = (new SAXTest()).new BookHandler();
        parser.setContentHandler(bookHandler);
        parser.parse("books.xml");
        System.out.println(bookHandler.getNameList());
    }
}