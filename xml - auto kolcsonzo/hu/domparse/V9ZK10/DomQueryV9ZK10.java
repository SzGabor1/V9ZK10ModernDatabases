package hu.domparse.V9ZK10;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQueryV9ZK10 {
    public static void main(String argv[]) throws SAXException, IOException, ParserConfigurationException {
        // Betöltjük az XML fájlt
        File xmlFile = new File("XMLTaskV9ZK10\\ERV9ZK10.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Vásárlók lekérdezése
        NodeList vasarloList = doc.getElementsByTagName("Vasarlo");
        System.out.println("\n----------Vásárlók----------");

        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 0; i < vasarloList.getLength(); i++) {
            Node node = vasarloList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                // Vásárló adatainak kinyerése
                String email = element.getElementsByTagName("email_cim").item(0).getTextContent();
                String name = element.getElementsByTagName("nev").item(0).getTextContent();
                NodeList phoneNumbers = element.getElementsByTagName("Telefonszam");

                // Cím információ kinyerése
                Element cimElement = (Element) element.getElementsByTagName("cim").item(0);
                String orszag = cimElement.getElementsByTagName("orszag").item(0).getTextContent();
                String isz = cimElement.getElementsByTagName("isz").item(0).getTextContent();
                String varos = cimElement.getElementsByTagName("varos").item(0).getTextContent();
                String uHsz = cimElement.getElementsByTagName("uHsz").item(0).getTextContent();

                // Adataink kiírása
                outputBuilder.append("<Vasarlo>\n");
                outputBuilder.append("  <Email>").append(email).append("</Email>\n");
                outputBuilder.append("  <Nev>").append(name).append("</Nev>\n");
                outputBuilder.append("  <Cim>").append(orszag).append(", ").append(isz).append(" ").append(varos)
                        .append(", ").append(uHsz).append("</Cim>\n");
                outputBuilder.append("  <Telefon>\n");

                for (int j = 0; j < phoneNumbers.getLength(); j++) {
                    String phoneNumber = phoneNumbers.item(j).getTextContent();
                    outputBuilder.append("    <Number>").append(phoneNumber).append("</Number>\n");
                }

                outputBuilder.append("  </Telefon>\n");
                outputBuilder.append("</Vasarlo>\n");
            }
        }

        // Kiírás
        System.out.println(outputBuilder.toString());

        // Autós cégek lekérdezése
        NodeList autosCegList = doc.getElementsByTagName("AutosCeg");
        System.out.println("\n----------Autós cégek----------");

        StringBuilder outputBuilder1 = new StringBuilder();

        for (int i = 0; i < autosCegList.getLength(); i++) {
            Node node = autosCegList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String companyCode = element.getAttribute("ceg_kod");
                String companyName = element.getElementsByTagName("cegnev").item(0).getTextContent();
                String employeeCount = element.getElementsByTagName("dolgozokSzama").item(0).getTextContent();

                outputBuilder1.append("<AutosCeg>\n");
                outputBuilder1.append("  <CegKod>").append(companyCode).append("</CegKod>\n");
                outputBuilder1.append("  <Nev>").append(companyName).append("</Nev>\n");
                outputBuilder1.append("  <DolgozokSzama>").append(employeeCount).append("</DolgozokSzama>\n");
                outputBuilder1.append("</AutosCeg>\n");
            }
        }

        // Kiírás
        System.out.println(outputBuilder1.toString());

        // Autós adatok lekérdezése
        NodeList autosAdatokList = doc.getElementsByTagName("AutosAdatok");
        System.out.println("\n----------Autós adatok----------");

        StringBuilder outputBuilder5 = new StringBuilder();

        for (int i = 0; i < autosAdatokList.getLength(); i++) {
            Node node = autosAdatokList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String forgalmiKod = element.getAttribute("forgalmi_kod");
                String adatokCompanyCode = element.getAttribute("ceg_kod");
                String price = element.getElementsByTagName("ar").item(0).getTextContent();
                String km = element.getElementsByTagName("kmOra").item(0).getTextContent();
                String status = element.getElementsByTagName("statusz").item(0).getTextContent();

                outputBuilder5.append("<AutosAdatok>\n");
                outputBuilder5.append("  <ForgalmiKod>").append(forgalmiKod).append("</ForgalmiKod>\n");
                outputBuilder5.append("  <CegKod>").append(adatokCompanyCode).append("</CegKod>\n");
                outputBuilder5.append("  <Ar>").append(price).append("</Ar>\n");
                outputBuilder5.append("  <Km>").append(km).append("</Km>\n");
                outputBuilder5.append("  <Statusz>").append(status).append("</Statusz>\n");
                outputBuilder5.append("</AutosAdatok>\n");
            }
        }

        // Kiírás
        System.out.println(outputBuilder5.toString());

        // Autós típusok lekérdezése
        NodeList autosTipusList = doc.getElementsByTagName("AutosTipus");
        System.out.println("\n----------Autós típusok----------");

        StringBuilder outputBuilder3 = new StringBuilder();

        for (int i = 0; i < autosTipusList.getLength(); i++) {
            Node node = autosTipusList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String tipusKod = element.getAttribute("tipus_kod");
                String tipusForgalmiKod = element.getAttribute("forgalmi_kod");
                String gyev = element.getElementsByTagName("gyartasiEv").item(0).getTextContent();
                String marka = element.getElementsByTagName("marka").item(0).getTextContent();
                String nev = element.getElementsByTagName("nev").item(0).getTextContent();

                outputBuilder3.append("<AutosTipus>\n");
                outputBuilder3.append("  <TipusKod>").append(tipusKod).append("</TipusKod>\n");
                outputBuilder3.append("  <ForgalmiKod>").append(tipusForgalmiKod).append("</ForgalmiKod>\n");
                outputBuilder3.append("  <GyartasiEv>").append(gyev).append("</GyartasiEv>\n");
                outputBuilder3.append("  <Marka>").append(marka).append("</Marka>\n");
                outputBuilder3.append("  <Nev>").append(nev).append("</Nev>\n");
                outputBuilder3.append("</AutosTipus>\n");
            }
        }

        // Kiírás
        System.out.println(outputBuilder3.toString());

        // Vásárlások lekérdezése
        NodeList vasarlasList = doc.getElementsByTagName("Vasarlas");
        System.out.println("\n----------Vásárlások----------");

        StringBuilder outputBuilder6 = new StringBuilder();

        for (int i = 0; i < vasarlasList.getLength(); i++) {
            Node node = vasarlasList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String vasarlasDatumkod = element.getAttribute("datumkod");
                String vasarlasCompanyCode = element.getAttribute("ceg_kod");
                String vasarlasVasarloKod = element.getAttribute("vasarlo_kod");
                String kezdDatum = element.getElementsByTagName("kezdDatum").item(0).getTextContent();

                outputBuilder6.append("<Vasarlas>\n");
                outputBuilder6.append("  <Datumkod>").append(vasarlasDatumkod).append("</Datumkod>\n");
                outputBuilder6.append("  <CegKod>").append(vasarlasCompanyCode).append("</CegKod>\n");
                outputBuilder6.append("  <VasarloKod>").append(vasarlasVasarloKod).append("</VasarloKod>\n");
                outputBuilder6.append("  <KezdDatum>").append(kezdDatum).append("</KezdDatum>\n");
                outputBuilder6.append("</Vasarlas>\n");
            }
        }

        // Kiírás
        System.out.println(outputBuilder6.toString());
        // Számlázások lekérdezése, ahol a végösszeg nagyobb mint 60.000
        NodeList szamlazasList = doc.getElementsByTagName("Szamlazas");
        System.out.println("\n----------Számlázások ami nagyobb mint 60.000----------");

        StringBuilder outputBuilder4 = new StringBuilder();

        for (int i = 0; i < szamlazasList.getLength(); i++) {
            Node node = szamlazasList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String szamlaKod = element.getAttribute("szamlakod");
                String szamlazasVasarloCode = element.getAttribute("vasarlo_kod");
                String szamlaDatum = element.getElementsByTagName("szamlaDatum").item(0).getTextContent();
                String vegOsszeg = element.getElementsByTagName("vegosszeg").item(0).getTextContent();
                String jogsiszam = element.getElementsByTagName("jogsiszam").item(0).getTextContent();

                // Ellenőrizd, hogy a végösszeg nagyobb vagy egyenlő mint 60000
                if (Integer.parseInt(vegOsszeg) >= 60000) {
                    outputBuilder4.append("<Számlázás>\n");
                    outputBuilder4.append("  <Számlakód>").append(szamlaKod).append("</Számlakód>\n");
                    outputBuilder4.append("  <VásárlóKód>").append(szamlazasVasarloCode).append("</VásárlóKód>\n");
                    outputBuilder4.append("  <SzámlaDátum>").append(szamlaDatum).append("</SzámlaDátum>\n");
                    outputBuilder4.append("  <Végösszeg>").append(vegOsszeg).append("</Végösszeg>\n");
                    outputBuilder4.append("  <Jogsiszám>").append(jogsiszam).append("</Jogsiszám>\n");
                    outputBuilder4.append("</Számlázás>\n");
                }
            }
        }

        // Kiírás
        System.out.println(outputBuilder4.toString());

        // Autós_adatok és Autós_tipus lekérdezése 1:1 kapcsolatban
        NodeList autosAdatokList2 = doc.getElementsByTagName("AutosAdatok");
        System.out.println("\n----------Autós adatok és az azokhoz tartozó típusok----------");

        StringBuilder outputBuilder2 = new StringBuilder();

        for (int i = 0; i < autosAdatokList2.getLength(); i++) {
            Node node = autosAdatokList2.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element autosAdatokElement = (Element) node;
                String forgalmiKod = autosAdatokElement.getAttribute("forgalmi_kod");
                String adatokCompanyCode = autosAdatokElement.getAttribute("ceg_kod");
                String ar = autosAdatokElement.getElementsByTagName("ar").item(0).getTextContent();
                String AutosAdatok = autosAdatokElement.getElementsByTagName("kmOra").item(0).getTextContent();
                String status = autosAdatokElement.getElementsByTagName("statusz").item(0).getTextContent();

                // Autós_tipus lekérdezése ugyanazzal a forgalmi_koddal
                NodeList autosTipusList2 = doc.getElementsByTagName("AutosTipus");
                for (int j = 0; j < autosTipusList2.getLength(); j++) {
                    Node autosTipusNode = autosTipusList2.item(j);

                    if (autosTipusNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element autosTipusElement = (Element) autosTipusNode;
                        String tipusForgalmiKod = autosTipusElement.getAttribute("forgalmi_kod");

                        if (forgalmiKod.equals(tipusForgalmiKod)) {
                            String gyev = autosTipusElement.getElementsByTagName("gyartasiEv").item(0).getTextContent();
                            String marka = autosTipusElement.getElementsByTagName("marka").item(0).getTextContent();
                            String nev = autosTipusElement.getElementsByTagName("nev").item(0).getTextContent();

                            outputBuilder2.append("<AutósAdatok>\n");
                            outputBuilder2.append("  <ForgalmiKód>").append(forgalmiKod).append("</ForgalmiKód>\n");
                            outputBuilder2.append("  <CégKód>").append(adatokCompanyCode).append("</CégKód>\n");
                            outputBuilder2.append("  <Ár>").append(ar).append("</Ár>\n");
                            outputBuilder2.append("  <KMóra>").append(AutosAdatok).append("</KMóra>\n");
                            outputBuilder2.append("  <Státusz>").append(status).append("</Státusz>\n");
                            outputBuilder2.append("  <GyártásiÉv>").append(gyev).append("</GyártásiÉv>\n");
                            outputBuilder2.append("  <Márka>").append(marka).append("</Márka>\n");
                            outputBuilder2.append("  <Név>").append(nev).append("</Név>\n");
                            outputBuilder2.append("</AutósAdatok>\n");
                        }
                    }
                }
            }
        }

        // Kiírás
        System.out.println(outputBuilder2.toString());

        // Autós_cégek és Autós_adatok lekérdezése 1:n kapcsolatban
        NodeList autosCegList1 = doc.getElementsByTagName("AutosCeg");
        System.out.println("\n----------Autós cégek és az azokhoz tartozó adatok----------");

        StringBuilder outputBuilder7 = new StringBuilder();

        for (int i = 0; i < autosCegList1.getLength(); i++) {
            Node node = autosCegList1.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element autosCegElement = (Element) node;
                String companyCode = autosCegElement.getAttribute("ceg_kod");
                String companyName = autosCegElement.getElementsByTagName("cegnev").item(0).getTextContent();

                // Autós_adatok lekérdezése ugyanazzal a ceg_koddal
                NodeList autosAdatokList1 = doc.getElementsByTagName("AutosAdatok");
                for (int j = 0; j < autosAdatokList1.getLength(); j++) {
                    Node autosAdatokNode = autosAdatokList1.item(j);

                    if (autosAdatokNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element autosAdatokElement = (Element) autosAdatokNode;
                        String adatokCompanyCode = autosAdatokElement.getAttribute("ceg_kod");

                        if (companyCode.equals(adatokCompanyCode)) {
                            String ar = autosAdatokElement.getElementsByTagName("ar").item(0).getTextContent();
                            String AutosAdatok = autosAdatokElement.getElementsByTagName("kmOra").item(0)
                                    .getTextContent();
                            String status = autosAdatokElement.getElementsByTagName("statusz").item(0).getTextContent();

                            outputBuilder7.append("<AutósCég>\n");
                            outputBuilder7.append("  <CégKód>").append(companyCode).append("</CégKód>\n");
                            outputBuilder7.append("  <CégNév>").append(companyName).append("</CégNév>\n");
                            outputBuilder7.append("  <Ár>").append(ar).append("</Ár>\n");
                            outputBuilder7.append("  <KMóra>").append(AutosAdatok).append("</KMóra>\n");
                            outputBuilder7.append("  <Státusz>").append(status).append("</Státusz>\n");
                            outputBuilder7.append("</AutósCég>\n");
                        }
                    }
                }
            }
        }

        // Kiírás
        System.out.println(outputBuilder7.toString());

        // Vásárló és vásárlás lekérdezése n:m kapcsolattal
        NodeList vasarloList1 = doc.getElementsByTagName("Vasarlo");
        System.out.println("\n----------Vásárlók és az azokhoz tartozó vásárlások----------");

        StringBuilder outputBuilder8 = new StringBuilder();

        for (int i = 0; i < vasarloList1.getLength(); i++) {
            Node node = vasarloList1.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element vasarloElement = (Element) node;
                String vasarloKod = vasarloElement.getAttribute("jogkod");
                String vasarloEmail = vasarloElement.getElementsByTagName("email_cim").item(0).getTextContent();
                String vasarloName = vasarloElement.getElementsByTagName("nev").item(0).getTextContent();

                // Vásárlások lekérdezése azonos vásárló_kód alapján
                NodeList vasarlasList1 = doc.getElementsByTagName("Vasarlas");
                for (int j = 0; j < vasarlasList1.getLength(); j++) {
                    Node vasarlasNode = vasarlasList1.item(j);

                    if (vasarlasNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element vasarlasElement = (Element) vasarlasNode;
                        String vasarlasVasarloKod = vasarlasElement.getAttribute("vasarlo_kod");

                        if (vasarloKod.equals(vasarlasVasarloKod)) {
                            String vasarlasDatumkod = vasarlasElement.getAttribute("datumkod");
                            String vasarlasCompanyCode = vasarlasElement.getAttribute("ceg_kod");
                            String kezdDatum = vasarlasElement.getElementsByTagName("kezdDatum").item(0)
                                    .getTextContent();

                            outputBuilder8.append("<Vásárló>\n");
                            outputBuilder8.append("  <VásárlóKód>").append(vasarloKod).append("</VásárlóKód>\n");
                            outputBuilder8.append("  <Név>").append(vasarloName).append("</Név>\n");
                            outputBuilder8.append("  <Email>").append(vasarloEmail).append("</Email>\n");
                            outputBuilder8.append("  <Vásárlás>\n");
                            outputBuilder8.append("    <Dátumkód>").append(vasarlasDatumkod).append("</Dátumkód>\n");
                            outputBuilder8.append("    <CégKód>").append(vasarlasCompanyCode).append("</CégKód>\n");
                            outputBuilder8.append("    <ElsőVásárlás>").append(kezdDatum).append("</ElsőVásárlás>\n");
                            outputBuilder8.append("  </Vásárlás>\n");
                            outputBuilder8.append("</Vásárló>\n");
                        }
                    }
                }
            }
        }

        // Kiírás
        System.out.println(outputBuilder8.toString());

    }
}
