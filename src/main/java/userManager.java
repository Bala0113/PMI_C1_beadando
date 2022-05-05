import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;

public class userManager {
    public static void usersRefresh() throws ParserConfigurationException, IOException, ParseException, SAXException, TransformerException {
        start.users = (userServices.readUsersFromXml());
        start.run();
    }
}
