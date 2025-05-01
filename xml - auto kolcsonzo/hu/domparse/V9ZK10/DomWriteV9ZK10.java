package hu.domparse.V9ZK10;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DomWriteV9ZK10 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Gyökér elem létrehozása
            Element rootElement = doc.createElement("AutosCegERV9ZK10");
            doc.appendChild(rootElement);

            // Namespace attribútumok hozzáadása
            rootElement.setAttribute("xmlns:xs", "http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xs:noNamespaceSchemaLocation", "ERV9ZK10.xsd");

            // Vasarlo elemek hozzáadása
            addVasarlo(doc, rootElement, "01", "jane.smith456@example.com", "Magyarorszag", "1234", "Budapest",
                    "Kossuth utca 10", "Kovacs Peter", "0630-987-6543", "0630-987-6453");
            addVasarlo(doc, rootElement, "02", "john.doe456@example.co.uk", "Magyarorszag", "5678", "Szeged",
                    "Rakoczi ut 5", "Nagy Anna", "0620-765-4321", "0620-765-0000");
            addVasarlo(doc, rootElement, "03", "mark.johnson789@example.co.uk", "Magyarorszag", "9876", "Debrecen",
                    "Petofi ter 3", "Kiss Eva", "0612-345-6789", "0630-987-6543");

            // AutosCeg elemek hozzáadása
            addAutosCeg(doc, rootElement, "11", "AutaPlusz Kft.", "BUD-123456", "15");
            addAutosCeg(doc, rootElement, "12", "Autovilag Bt.", "DEB-654321", "10");
            addAutosCeg(doc, rootElement, "13", "Kocsis Kft.", "SZEG-987654", "20");

            // AutosAdatok elemek hozzáadása
            addAutosAdatok(doc, rootElement, "21", "11", "45000", "78900", "uj");
            addAutosAdatok(doc, rootElement, "22", "11", "55000", "65400", "hasznalt");
            addAutosAdatok(doc, rootElement, "23", "13", "60000", "89000", "hasznalt");

            // AutosTipus elemek hozzáadása
            addAutosTipus(doc, rootElement, "31", "21", "2022", "Toyota", "Corolla Hybrid");
            addAutosTipus(doc, rootElement, "32", "22", "2021", "Volkswagen", "Golf GTI");
            addAutosTipus(doc, rootElement, "33", "23", "2020", "Ford", "Focus Titanium");

            // Vasarlas elemek hozzáadása
            addVasarlas(doc, rootElement, "41", "11", "01", "2023-01-15");
            addVasarlas(doc, rootElement, "42", "12", "02", "2023-02-28");
            addVasarlas(doc, rootElement, "43", "13", "02", "2023-03-10");

            // Szamlazas elemek hozzáadása
            addSzamlazas(doc, rootElement, "51", "01", "2023-01-20", "55000", "54321");
            addSzamlazas(doc, rootElement, "52", "02", "2023-03-01", "60000", "65432");
            addSzamlazas(doc, rootElement, "53", "03", "2023-04-12", "70000", "76543");

            // XML fájl írása
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);

            StreamResult fileResult = new StreamResult(new File("XMLTaskV9ZK10\\\\ERV9ZK10_1.xml"));
            StreamResult consoleResult = new StreamResult(System.out);
            // Fájlba írás
            transformer.transform(source, fileResult);

            // Consolra írás
            transformer.transform(source, consoleResult);
            System.out.println("The content has been written to the output file successfully.");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Valami baj van: " + e);
        }
    }

    // Segédfüggvények az elemek hozzáadásához
    private static void addVasarlo(Document doc, Element root, String jogkod, String email, String orszag, String isz,
            String varos, String uHsz, String nev, String telefonszam1, String telefonszam2) {
        Element vasarlo = doc.createElement("Vasarlo");
        vasarlo.setAttribute("jogkod", jogkod);
        root.appendChild(vasarlo);

        Element emailCim = doc.createElement("email_cim");
        emailCim.appendChild(doc.createTextNode(email));
        vasarlo.appendChild(emailCim);

        Element cim = doc.createElement("cim");
        vasarlo.appendChild(cim);

        Element orszagElement = doc.createElement("orszag");
        orszagElement.appendChild(doc.createTextNode(orszag));
        cim.appendChild(orszagElement);

        Element iszElement = doc.createElement("isz");
        iszElement.appendChild(doc.createTextNode(isz));
        cim.appendChild(iszElement);

        Element varosElement = doc.createElement("varos");
        varosElement.appendChild(doc.createTextNode(varos));
        cim.appendChild(varosElement);

        Element uHszElement = doc.createElement("uHsz");
        uHszElement.appendChild(doc.createTextNode(uHsz));
        cim.appendChild(uHszElement);

        Element nevElement = doc.createElement("nev");
        nevElement.appendChild(doc.createTextNode(nev));
        vasarlo.appendChild(nevElement);

        Element telefonszam1Element = doc.createElement("Telefonszam");
        telefonszam1Element.appendChild(doc.createTextNode(telefonszam1));
        vasarlo.appendChild(telefonszam1Element);

        Element telefonszam2Element = doc.createElement("Telefonszam");
        telefonszam2Element.appendChild(doc.createTextNode(telefonszam2));
        vasarlo.appendChild(telefonszam2Element);
    }

    private static void addAutosCeg(Document doc, Element root, String ceg_kod, String cegnev, String helyrajziSzam,
            String dolgozokSzama) {
        Element autosCeg = doc.createElement("AutosCeg");
        autosCeg.setAttribute("ceg_kod", ceg_kod);
        root.appendChild(autosCeg);

        Element cegnevElement = doc.createElement("cegnev");
        cegnevElement.appendChild(doc.createTextNode(cegnev));
        autosCeg.appendChild(cegnevElement);

        Element helyrajziSzamElement = doc.createElement("helyrajziSzam");
        helyrajziSzamElement.appendChild(doc.createTextNode(helyrajziSzam));
        autosCeg.appendChild(helyrajziSzamElement);

        Element dolgozokSzamaElement = doc.createElement("dolgozokSzama");
        dolgozokSzamaElement.appendChild(doc.createTextNode(dolgozokSzama));
        autosCeg.appendChild(dolgozokSzamaElement);
    }

    private static void addAutosAdatok(Document doc, Element root, String forgalmi_kod, String ceg_kod, String ar,
            String kmOra, String statusz) {
        Element autosAdatok = doc.createElement("AutosAdatok");
        autosAdatok.setAttribute("forgalmi_kod", forgalmi_kod);
        autosAdatok.setAttribute("ceg_kod", ceg_kod);
        root.appendChild(autosAdatok);

        Element arElement = doc.createElement("ar");
        arElement.appendChild(doc.createTextNode(ar));
        autosAdatok.appendChild(arElement);

        Element kmOraElement = doc.createElement("kmOra");
        kmOraElement.appendChild(doc.createTextNode(kmOra));
        autosAdatok.appendChild(kmOraElement);

        Element statuszElement = doc.createElement("statusz");
        statuszElement.appendChild(doc.createTextNode(statusz));
        autosAdatok.appendChild(statuszElement);
    }

    private static void addAutosTipus(Document doc, Element root, String tipus_kod, String forgalmi_kod,
            String gyartasiEv, String marka, String nev) {
        Element autosTipus = doc.createElement("AutosTipus");
        autosTipus.setAttribute("tipus_kod", tipus_kod);
        autosTipus.setAttribute("forgalmi_kod", forgalmi_kod);
        root.appendChild(autosTipus);

        Element gyartasiEvElement = doc.createElement("gyartasiEv");
        gyartasiEvElement.appendChild(doc.createTextNode(gyartasiEv));
        autosTipus.appendChild(gyartasiEvElement);

        Element markaElement = doc.createElement("marka");
        markaElement.appendChild(doc.createTextNode(marka));
        autosTipus.appendChild(markaElement);

        Element nevElement = doc.createElement("nev");
        nevElement.appendChild(doc.createTextNode(nev));
        autosTipus.appendChild(nevElement);
    }

    private static void addVasarlas(Document doc, Element root, String datumkod, String ceg_kod, String vasarlo_kod,
            String kezdDatum) {
        Element vasarlas = doc.createElement("Vasarlas");
        vasarlas.setAttribute("datumkod", datumkod);
        vasarlas.setAttribute("ceg_kod", ceg_kod);
        vasarlas.setAttribute("vasarlo_kod", vasarlo_kod);
        root.appendChild(vasarlas);

        Element kezdDatumElement = doc.createElement("kezdDatum");
        kezdDatumElement.appendChild(doc.createTextNode(kezdDatum));
        vasarlas.appendChild(kezdDatumElement);
    }

    private static void addSzamlazas(Document doc, Element root, String szamlakod, String vasarlo_kod,
            String szamlaDatum, String vegosszeg, String jogsiszam) {
        Element szamlazas = doc.createElement("Szamlazas");
        szamlazas.setAttribute("szamlakod", szamlakod);
        szamlazas.setAttribute("vasarlo_kod", vasarlo_kod);
        root.appendChild(szamlazas);

        Element szamlaDatumElement = doc.createElement("szamlaDatum");
        szamlaDatumElement.appendChild(doc.createTextNode(szamlaDatum));
        szamlazas.appendChild(szamlaDatumElement);

        Element vegosszegElement = doc.createElement("vegosszeg");
        vegosszegElement.appendChild(doc.createTextNode(vegosszeg));
        szamlazas.appendChild(vegosszegElement);

        Element jogsiszamElement = doc.createElement("jogsiszam");
        jogsiszamElement.appendChild(doc.createTextNode(jogsiszam));
        szamlazas.appendChild(jogsiszamElement);
    }
}
