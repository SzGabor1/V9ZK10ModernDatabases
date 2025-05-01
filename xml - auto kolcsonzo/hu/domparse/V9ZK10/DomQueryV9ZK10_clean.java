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
                System.out.println("Email: " + email);
                System.out.println("Név: " + name);
                System.out.println("Cím: " + orszag + ", " + isz + " " + varos + ", " + uHsz);
                System.out.println("Telefon:");

                for (int j = 0; j < phoneNumbers.getLength(); j++) {
                    String phoneNumber = phoneNumbers.item(j).getTextContent();
                    System.out.println("- " + phoneNumber);
                }

                System.out.println();
            }
        }

        // Autós cégek lekérdezése
        NodeList autosCegList = doc.getElementsByTagName("AutosCeg");
        System.out.println("\n----------Autós cégek----------");

        for (int i = 0; i < autosCegList.getLength(); i++) {
            Node node = autosCegList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String companyCode = element.getAttribute("ceg_kod");
                String companyName = element.getElementsByTagName("cegnev").item(0).getTextContent();
                String employeeCount = element.getElementsByTagName("dolgozokSzama").item(0).getTextContent();

                System.out.println("Cég kód: " + companyCode);
                System.out.println("Név: " + companyName);
                System.out.println("Dolgozók száma: " + employeeCount);
                System.out.println();
            }
        }

        // Autós adatok lekérdezése
        NodeList autosAdatokList = doc.getElementsByTagName("AutosAdatok");
        System.out.println("\n----------Autós adatok----------");

        for (int i = 0; i < autosAdatokList.getLength(); i++) {
            Node node = autosAdatokList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String forgalmiKod = element.getAttribute("forgalmiKod");
                String adatokCompanyCode = element.getAttribute("ceg_kod");
                String price = element.getElementsByTagName("ar").item(0).getTextContent();
                String km = element.getElementsByTagName("kmOra").item(0).getTextContent();
                String status = element.getElementsByTagName("statusz").item(0).getTextContent();

                System.out.println("Forgalmi Kód: " + forgalmiKod);
                System.out.println("Cég kód: " + adatokCompanyCode);
                System.out.println("Ár: " + price);
                System.out.println("KM: " + km);
                System.out.println("Státusz: " + status);
                System.out.println();
            }
        }

        // Autós típusok lekérdezése
        NodeList autosTipusList = doc.getElementsByTagName("AutosTipus");
        System.out.println("\n----------Autós típusok----------");

        for (int i = 0; i < autosTipusList.getLength(); i++) {
            Node node = autosTipusList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String tipusKod = element.getAttribute("tipus_kod");
                String tipusForgalmiKod = element.getAttribute("forgalmiKod");
                String gyev = element.getElementsByTagName("gyartasiEv").item(0).getTextContent();
                String marka = element.getElementsByTagName("marka").item(0).getTextContent();
                String nev = element.getElementsByTagName("nev").item(0).getTextContent();

                System.out.println("Típus Kód: " + tipusKod);
                System.out.println("Forgalmi Kód: " + tipusForgalmiKod);
                System.out.println("Gyártási Év: " + gyev);
                System.out.println("Márka: " + marka);
                System.out.println("Név: " + nev);
                System.out.println();
            }
        }

        // Vásárlások lekérdezése
        NodeList vasarlasList = doc.getElementsByTagName("Vasarlas");
        System.out.println("\n----------Vásárlások----------");

        for (int i = 0; i < vasarlasList.getLength(); i++) {
            Node node = vasarlasList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String vasarlasDatumkod = element.getAttribute("datumkod");
                String vasarlasCompanyCode = element.getAttribute("ceg_kod");
                String vasarlasVasarloKod = element.getAttribute("vasarlo_kod");
                String kezdDatum = element.getElementsByTagName("kezdDatum").item(0).getTextContent();

                System.out.println("Dátumkód: " + vasarlasDatumkod);
                System.out.println("Cég kód: " + vasarlasCompanyCode);
                System.out.println("Vásárló Kód: " + vasarlasVasarloKod);
                System.out.println("Kezdő Dátum: " + kezdDatum);
                System.out.println();
            }
        }

        // Számlázások lekérdezése, ahol a végösszeg nagyobb mint 60.000
        NodeList szamlazasList = doc.getElementsByTagName("Szamlazas");
        System.out.println("\n----------Számlázások ami nagyobb mint 60.000----------");

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
                    System.out.println("Számlakód: " + szamlaKod);
                    System.out.println("Vásárló Kód: " + szamlazasVasarloCode);
                    System.out.println("Számla Dátum: " + szamlaDatum);
                    System.out.println("Végösszeg: " + vegOsszeg);
                    System.out.println("Jogsiszám: " + jogsiszam);
                    System.out.println();
                }
            }
        }

        // Autós_adatok és Autós_tipus lekérdezése 1:1 kapcsolatban
        NodeList autosAdatokList2 = doc.getElementsByTagName("AutosAdatok");
        System.out.println("\n----------Autós adatok és az azokhoz tartozó típusok----------");

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

                            System.out.println("Forgalmi Kód: " + forgalmiKod);
                            System.out.println("Cég kód: " + adatokCompanyCode);
                            System.out.println("Ár: " + ar);
                            System.out.println("KM óra: " + AutosAdatok);
                            System.out.println("Státusz: " + status);
                            System.out.println("Gyártási Év: " + gyev);
                            System.out.println("Márka: " + marka);
                            System.out.println("Név: " + nev);
                            System.out.println();
                        }
                    }
                }
            }
        }

        // Autós_cégek és Autós_adatok lekérdezése 1:n kapcsolatban
        NodeList autosCegList1 = doc.getElementsByTagName("AutosCeg");
        System.out.println("\n----------Autós cégek és az azokhoz tartozó adatok----------");

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

                            System.out.println("Cég kód: " + companyCode);
                            System.out.println("Cég név: " + companyName);
                            System.out.println("Ár: " + ar);
                            System.out.println("KM óra: " + AutosAdatok);
                            System.out.println("Státusz: " + status);
                            System.out.println();
                        }
                    }
                }
            }
        }

        // Vásárló és vásárlás lekérdezése n:m kapcsolattal
        NodeList vasarloList1 = doc.getElementsByTagName("Vasarlo");
        System.out.println("\n----------Vásárlók és az azokhoz tartozó vásárlások----------");

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

                            System.out.println("Vásárló Kód: " + vasarloKod);
                            System.out.println("Név: " + vasarloName);
                            System.out.println("Email: " + vasarloEmail);
                            System.out.println("Vásárlás Dátumkód: " + vasarlasDatumkod);
                            System.out.println("Cég kód: " + vasarlasCompanyCode);
                            System.out.println("Első vásárlás: " + kezdDatum);
                            System.out.println();
                        }
                    }
                }
            }
        }

    }
}
