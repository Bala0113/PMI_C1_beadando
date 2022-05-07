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

    //Main függvény: frissíti a listát és elindítja a programot
    public static void main(String[] args) throws ParseException, ParserConfigurationException, IOException, TransformerException, SAXException {
        messages.welcome();
        userManager.usersRefresh();
        run();
    }

    //A választható menüpontok:
    public static void run() throws ParseException, ParserConfigurationException, IOException, TransformerException, SAXException {
        messages.menu();

        switch (scannerLimit.menuChoice()) {
            case 1 -> {
                CRUD.add();
                userManager.usersRefresh();
            }
            case 2 -> {
                CRUD.edit();
                userManager.usersRefresh();
            }
            case 3 -> {
                CRUD.delete();
                userManager.usersRefresh();
            }
            case 4 -> {
                userManager.userList();
                userManager.usersRefresh();
            }
            case 5 -> {
                messages.exit();
                System.exit(5);

            }
        }
        }




}


