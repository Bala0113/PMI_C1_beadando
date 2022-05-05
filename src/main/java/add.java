import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class add {

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



    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}


