package hu.domparse.V9ZK10;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomModifyV9ZK10 {
    public static void main(String[] args) {
        try {

            File xmlFile = new File("XMLTaskV9ZK10\\ERV9ZK10_1.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(xmlFile);

            // első vásárló városának módosítása
            NodeList vasarloList = doc.getElementsByTagName("Vasarlo");
            Element vasarlo = (Element) vasarloList.item(0);
            vasarlo.getElementsByTagName("varos").item(0).setTextContent("Budapest");

            // az első autós adatok árának módosítása
            NodeList autosAdatokList = doc.getElementsByTagName("AutosAdatok");
            Element autosAdatok = (Element) autosAdatokList.item(0);
            autosAdatok.getElementsByTagName("ar").item(0).setTextContent("600000");

            // Kiiratja a konzolra a módosított XML-t
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
