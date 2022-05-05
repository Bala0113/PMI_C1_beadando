import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class start {

    protected static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<data> users = new ArrayList<>();


    public static void main(String[] args) throws ParseException, ParserConfigurationException, IOException, TransformerException, SAXException {
        gui.welcome();
        userManager.usersRefresh();
        run();
    }

    public static void run() throws ParseException, ParserConfigurationException, IOException, TransformerException, SAXException {
        gui.menu();

        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                add a = new add();
                a.add();
                userManager.usersRefresh();
                break;
            case 2:
                edit b = new edit();
                b.edit();
                userManager.usersRefresh();
                break;
            case 3:
                delete c = new delete();
                c.delete();
                userManager.usersRefresh();
                break;
            case 4:
                usersList.userList();
                userManager.usersRefresh();
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:

                break;
            case 7:
                System.out.println("Sunday");
                break;
            }

        }




}


