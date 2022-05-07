import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class userServices {

    public static String pattern = "yyyy/MM/dd";
    public static DateFormat df = new SimpleDateFormat(pattern);



    //Végig megy Xml fájlban az összes Useren és egyenként egy listába gyűjti őket
    public static ArrayList<data> readUsersFromXml() throws ParserConfigurationException, IOException, SAXException, ParseException {
        File inputFile = new File("./src/main/resources/db.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(inputFile);
        document.getDocumentElement().normalize();

        ArrayList<data> patients = new ArrayList<>();
        NodeList users = document.getElementsByTagName("USER");
        for (int i = 0; i< users.getLength(); i++){
            Node nNode = users.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                String sDate = eElement.getElementsByTagName("SZUL").item(0).getTextContent();
                Date szul=new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
                data dt = new data();
                dt.setTaj(eElement.getElementsByTagName("TAJ").item(0).getTextContent());
                dt.setNev(eElement.getElementsByTagName("NEV").item(0).getTextContent());
                dt.setSzul(szul);
                dt.setLak(eElement.getElementsByTagName("LAK").item(0).getTextContent());
                dt.setTel(eElement.getElementsByTagName("TEL").item(0).getTextContent());
                dt.setSzoba(Integer.parseInt(eElement.getElementsByTagName("SZOBA").item(0).getTextContent()));
                dt.setDiagn(eElement.getElementsByTagName("DIAGNOZIS").item(0).getTextContent());

                patients.add(dt);
            }
        }
        return patients;
    }


    // Új beteg hozzáadása: Létrehozza az Xml Tageket és kapott értékeket a Tagekhez csatolja
    public static void newUser(data patient) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File inputFile = new File("./src/main/resources/db.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(inputFile);
        Element root = document.getDocumentElement();
        Element user = document.createElement("USER");
        root.appendChild(user);

        Element taj = document.createElement("TAJ");
        Element nev = document.createElement("NEV");
        Element szul = document.createElement("SZUL");
        Element lak = document.createElement("LAK");
        Element tel = document.createElement("TEL");
        Element szoba = document.createElement("SZOBA");
        Element diag = document.createElement("DIAGNOZIS");

        //
        String sSzul = df.format(patient.getSzul());
        String sSzoba = String.valueOf(patient.getSzoba());

        taj.appendChild(document.createTextNode(patient.getTaj()));
        nev.appendChild(document.createTextNode(patient.getNev()));
        szul.appendChild(document.createTextNode(sSzul));
        lak.appendChild(document.createTextNode(patient.getLak()));
        tel.appendChild(document.createTextNode(patient.getTel()));
        szoba.appendChild(document.createTextNode(sSzoba));
        diag.appendChild(document.createTextNode(patient.getDiagn()));

        user.appendChild(taj);
        user.appendChild(nev);
        user.appendChild(szul);
        user.appendChild(lak);
        user.appendChild(tel);
        user.appendChild(szoba);
        user.appendChild(diag);

        FileOutputStream output = new FileOutputStream("src/main/resources/db.xml");
        writeXml(document, output);
    }


    //A függvény megkapja az Xml Tageket és beleírja a fájlba
    private static void writeXml(Document document, FileOutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }


    //Megkeresi a kiválasztott elemet, ha igazat ad vissza akkor létezik ez az elem, ha hamis akkor nem létezik
    public static boolean userSearch(String taj) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("./src/main/resources/db.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(inputFile);
        document.getDocumentElement().normalize();

        NodeList users = document.getElementsByTagName("USER");
        for (int i = 0; i< users.getLength(); i++){
            Node nNode = users.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                if (eElement.getElementsByTagName("TAJ").item(0).getTextContent().equals(taj)){

                    return true;
                }
            }
        }
        return false;
    }


    /* Megkeresi a kiválasztott betegnek a Taj értékét az Xml Taj Tagjei között és azt a Usert, amely ezzel a Taj Taggel
     rendelkezik, azt kitörli
    */
    public static void deleteUser(String taj) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File inputFile = new File("./src/main/resources/db.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(inputFile);
        document.getDocumentElement().normalize();

        NodeList users = document.getElementsByTagName("USER");
        for (int i = 0; i< users.getLength(); i++){
            Node nNode = users.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                if (eElement.getElementsByTagName("TAJ").item(0).getTextContent().equals(taj)){
                    document.getDocumentElement().removeChild(nNode);

                    FileOutputStream output = new FileOutputStream("src/main/resources/db.xml");
                    writeXml(document, output);
                }
            }
        }
    }


    // Megkeresi a kiválasztott betegnek a Taj értékét az Xml Taj Tagjei között és visszaadja annak a Usernak az értékeit
    public static data actualData(String search) throws ParserConfigurationException, IOException, SAXException, ParseException {
        File inputFile = new File("./src/main/resources/db.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(inputFile);
        document.getDocumentElement().normalize();

        NodeList users = document.getElementsByTagName("USER");
        for (int i = 0; i< users.getLength(); i++){
            Node nNode = users.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                if (eElement.getElementsByTagName("TAJ").item(0).getTextContent().equals(search)){

                    String sDate = eElement.getElementsByTagName("SZUL").item(0).getTextContent();
                    Date szul=new SimpleDateFormat("yyyy/MM/dd").parse(sDate);

                    data dt = new data();
                    dt.setTaj(eElement.getElementsByTagName("TAJ").item(0).getTextContent());
                    dt.setNev(eElement.getElementsByTagName("NEV").item(0).getTextContent());
                    dt.setSzul(szul);
                    dt.setLak(eElement.getElementsByTagName("LAK").item(0).getTextContent());
                    dt.setTel(eElement.getElementsByTagName("TEL").item(0).getTextContent());
                    dt.setSzoba(Integer.parseInt(eElement.getElementsByTagName("SZOBA").item(0).getTextContent()));
                    dt.setDiagn(eElement.getElementsByTagName("DIAGNOZIS").item(0).getTextContent());
                    return dt;
                }
            }
        }
        return null;
    }


    /*A függvény megkapja a módosított értékeket és felül írja ezekkel az értékekkel
         az ugyanazzal a Taj Taggel  rendelkező Usert
        */
    public static boolean editedUserSave(data dt) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File inputFile = new File("./src/main/resources/db.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(inputFile);
        document.getDocumentElement().normalize();

        NodeList users = document.getElementsByTagName("USER");
        for (int i = 0; i< users.getLength(); i++){
            Node nNode = users.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                if (eElement.getElementsByTagName("TAJ").item(0).getTextContent().equals(dt.getTaj())){

                    String sSzul = df.format(dt.getSzul());

                    eElement.getElementsByTagName("NEV").item(0).setTextContent(dt.getNev());
                    eElement.getElementsByTagName("SZUL").item(0).setTextContent(sSzul);
                    eElement.getElementsByTagName("LAK").item(0).setTextContent(dt.getLak());
                    eElement.getElementsByTagName("TEL").item(0).setTextContent(dt.getTel());
                    eElement.getElementsByTagName("SZOBA").item(0).setTextContent(String.valueOf(dt.getSzoba()));
                    eElement.getElementsByTagName("DIAGNOZIS").item(0).setTextContent(dt.getDiagn());

                    FileOutputStream output = new FileOutputStream("src/main/resources/db.xml");
                    writeXml(document, output);
                    return true;
                }
            }
        }
        return false;
    }
}
