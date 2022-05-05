import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class edit {
    public static void edit() throws ParserConfigurationException, IOException, SAXException, ParseException, TransformerException {
        System.out.println("\nA beteg adatainak szerkesztését választotta. Kérem adja meg a beteg TAJ számát: ");
        String search=start.scanner.next();

        boolean searchResult = userServices.userSearch(search);
        if (userServices.userSearch(search)) {
            System.out.println("A beteg adatai megtalálva...");

            data actualPatient = userServices.actualData(search);
            System.out.println("\nNév: ");
            String nev = start.scanner.next();
            System.out.println("\nSzületési idő: ");
            String sDate = start.scanner.next();
            System.out.println("\nLakcím: ");
            String lak = start.scanner.next();
            System.out.println("\nTelefonszám: ");
            String tel = start.scanner.next();
            System.out.println("\nSzoba: ");
            String szoba = start.scanner.next();
            System.out.println("\nDiagnózis: ");
            String diag = start.scanner.next();

            data editedPatient = new data();
            Date szul=new SimpleDateFormat("yyyy.MM.dd").parse(sDate);
            editedPatient.setTaj(search);
            editedPatient.setNev(nev);
            editedPatient.setSzul(szul);
            editedPatient.setLak(lak);
            editedPatient.setTel(tel);
            editedPatient.setSzoba(Integer.parseInt(szoba));
            editedPatient.setDiagn(diag);

            if (userServices.editedUserSave(editedPatient)) System.out.println("Sikeres mentés!");
            else System.out.println("Sikertelen mentés!");
        }
    }
}
