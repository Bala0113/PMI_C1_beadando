import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;

public class delete {
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
