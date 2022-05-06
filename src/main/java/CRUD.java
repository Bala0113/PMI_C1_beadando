import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRUD {

    public static void add() throws ParseException, ParserConfigurationException, IOException, TransformerException, SAXException {
        data patient = new data();
        System.out.println("\nAz új beteg hozzáadását választotta. Kérem adja meg a beteg adatait...");
        start.scanner.nextLine();
        System.out.println("\nTajszám: ");
        String taj = start.scanner.nextLine();
        System.out.println("\nNév: ");
        String nev = start.scanner.nextLine();
        System.out.println("\nSzületési idő: ");
        String sDate = start.scanner.nextLine();
        System.out.println("\nLakcím: ");
        String lak = start.scanner.nextLine();
        System.out.println("\nTelefonszám: ");
        String tel = start.scanner.nextLine();
        System.out.println("\nSzoba: ");
        int szoba = start.scanner.nextInt();   start.scanner.nextLine();
        System.out.println("\nDiagnózis: ");
        String diag = start.scanner.nextLine();

        Date szul=new SimpleDateFormat("yyyy.MM.dd").parse(sDate);
        patient.setTaj(taj);
        patient.setNev(nev);
        patient.setSzul(szul);
        patient.setLak(lak);
        patient.setTel(tel);
        patient.setSzoba(szoba);
        patient.setDiagn(diag);

        userServices.newUser(patient); ;
        System.out.println("A beteget sikeresen felvettük adatbázisunkba!");
    }


    public static void edit() throws ParserConfigurationException, IOException, SAXException, ParseException, TransformerException {
        System.out.println("\nA beteg adatainak szerkesztését választotta. Kérem adja meg a beteg TAJ számát: ");
        String search=start.scanner.next();
        data editedPatient = userServices.actualData(search);
        boolean searchResult = userServices.userSearch(search);
        if (userServices.userSearch(search)) {
            System.out.println("A beteg adatai megtalálva...");

            data actualPatient = userServices.actualData(search);
            editedPatient.setTaj(search);
            System.out.println("Az eretedi név ''"+ actualPatient.getNev() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            if (start.scanner.nextInt() == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj név: ");
                editedPatient.setNev(start.scanner.nextLine());

            }
            System.out.println("Az eretedi születési dátum ''"+ userServices.df.format(actualPatient.getSzul()) + "'' volt. Kívánja szerkeszteni? 1/0 ");
            if (start.scanner.nextInt() == 1) {
                System.out.println("\nÚj születési dátum ");
                String sDate = start.scanner.next();
                Date szul=new SimpleDateFormat("yyyy.MM.dd").parse(sDate);
                editedPatient.setSzul(szul);
            }
            System.out.println("Az eretedi lakcím ''"+ actualPatient.getLak() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            if (start.scanner.nextInt() == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj lakcím: ");
                editedPatient.setLak(start.scanner.nextLine());

            }
            System.out.println("Az eretedi telefonszám ''"+ actualPatient.getTel() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            if (start.scanner.nextInt() == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj telefonszám: ");
                editedPatient.setTel(start.scanner.nextLine());

            }
            System.out.println("Az eretedi szobaszám ''"+ actualPatient.getSzoba() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            if (start.scanner.nextInt() == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj szobaszám: ");
                editedPatient.setSzoba(start.scanner.nextInt());

            }
            System.out.println("Az eretedi diagnóózis ''"+ actualPatient.getDiagn() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            if (start.scanner.nextInt() == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj diagnózis: ");
                editedPatient.setDiagn(start.scanner.nextLine());

            }

            userServices.editedUserSave(editedPatient);
            if (userServices.editedUserSave(editedPatient)) System.out.println("Sikeres mentés!");
            else System.out.println("Sikertelen mentés!");
        }
    }


    public static void delete() throws ParserConfigurationException, IOException, SAXException, ParseException, TransformerException {
        System.out.println("\nA beteg adatainak törlését választotta. Kérem adja meg a beteg Taj számát: ");
        String search = start.scanner.next();
        if (userServices.userSearch(search)){
            System.out.println("A beteg adatai megtalálva...");

            userServices.deleteUser(search);
            System.out.println("A beteg adatai sikeresen törlődtek!");
        }
        else  System.out.println("Nem található ilyen taj számmal rendelkező beteg..."); start.run();

    }
}



