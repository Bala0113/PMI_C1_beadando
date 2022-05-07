import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;

    //Frissíti a listát, és elindítja újból a menüt
public class userManager {
    public static void usersRefresh() throws ParserConfigurationException, IOException, ParseException, SAXException, TransformerException {
        start.users = (userServices.readUsersFromXml());
        start.run();
    }

    // Kiiratja a betegekkel teli listát
    public static void userList(){
        String fmt = "%1$10s %2$20s %3$20s %4$25s %5$20s %6$10s %7$30s%n";       //  Formátum a kiíráshoz
        System.out.printf(fmt,"Tajszám","Név","Születési idő","Lakhely","Telefonszám","Szoba","Diagnózis");

        for (int i = 0; i< start.users.size();i++) {
            System.out.printf(fmt,start.users.get(i).getTaj(),start.users.get(i).getNev(),userServices.df.format(start.users.get(i).getSzul()),start.users.get(i).getLak(),
                    start.users.get(i).getTel(),start.users.get(i).getSzoba(),start.users.get(i).getDiagn());
        }
    }
}
