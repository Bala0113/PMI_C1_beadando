import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static jdk.internal.vm.PostVMInitHook.run;

public class CRUD {

    public static int choice;


    //Bekéri az új beteg adatait és eltárolja azokat az Xml fileban a 'userServices.newUser' függvény segítségével
    public static void add() throws ParseException, ParserConfigurationException, IOException, TransformerException, SAXException {
        data patient = new data();
        System.out.println(messages.yellow +"\nAz új beteg hozzáadását választotta. Kérem adja meg a beteg adatait..." + messages.reset);
        messages.continueOrback();
        if (scannerLimit.yesOrNo() == 0) start.run();
        start.scanner.nextLine();

        System.out.println("\nTajszám: ");
        patient.setTaj(scannerLimit.numberValidate9());
        start.scanner.nextLine();

        System.out.println("\nNév: ");
        patient.setNev(scannerLimit.notEmpty());

        System.out.println("\nSzületési idő: ");
        patient.setSzul(new SimpleDateFormat("yyyy.MM.dd").parse(scannerLimit.dateValidate()));

        System.out.println("\nLakcím: ");
        patient.setLak(scannerLimit.notEmpty());

        System.out.println("\nTelefonszám: ");
        patient.setTel(scannerLimit.numberValidate());

        System.out.println("\nSzoba: ");
        patient.setSzoba(Integer.parseInt(scannerLimit.numberValidate()));

        System.out.println("\nDiagnózis: ");
        patient.setDiagn(scannerLimit.notEmpty());

        userServices.newUser(patient);
        messages.succesfulAdded();
    }


    //Bekéri a betegnek a tajszámát, majd megkeresi azt az Xml fileban és felajánlja az adatainak a szerkesztését --> módosítja az xml fileban a Usert
    public static void edit() throws ParserConfigurationException, IOException, SAXException, ParseException, TransformerException {
        System.out.println(messages.yellow + "\nA beteg adatainak szerkesztését választotta. " + messages.reset);
        messages.continueOrback();
        if (scannerLimit.yesOrNo() == 0){start.run();}
        start.scanner.nextLine();
        System.out.println(messages.yellow + "\nKérem adja meg a beteg TAJ számát:  " + messages.reset);
        String search=scannerLimit.numberValidate9();
        data editedPatient = userServices.actualData(search);

        if (userServices.userSearch(search)) {
            System.out.println("A beteg adatai megtalálva...");
            data actualPatient = userServices.actualData(search);
            assert editedPatient != null;
            editedPatient.setTaj(search);

            assert actualPatient != null;
            System.out.println("Az eretedi név ''"+ actualPatient.getNev() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj név: ");
                editedPatient.setNev(scannerLimit.notEmpty());
            }

            System.out.println("Az eretedi születési dátum ''"+ userServices.df.format(actualPatient.getSzul()) + "'' volt. Kívánja szerkeszteni? 1/0 ");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj születési dátum ");
                editedPatient.setSzul(new SimpleDateFormat("yyyy.MM.dd").parse(scannerLimit.dateValidate()));
            }

            System.out.println("Az eretedi lakcím ''"+ actualPatient.getLak() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj lakcím: ");
                editedPatient.setLak(scannerLimit.notEmpty());
            }

            System.out.println("Az eretedi telefonszám ''"+ actualPatient.getTel() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj telefonszám: ");
                editedPatient.setTel(scannerLimit.numberValidate());
            }

            System.out.println("Az eretedi szobaszám ''"+ actualPatient.getSzoba() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj szobaszám: ");
                editedPatient.setSzoba(Integer.parseInt(scannerLimit.numberValidate()));
            }

            System.out.println("Az eretedi diagnóózis ''"+ actualPatient.getDiagn() + "'' volt. Kívánja szerkeszteni? 1/0 ");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
                start.scanner.nextLine();
                System.out.println("\nÚj diagnózis: ");
                editedPatient.setDiagn(scannerLimit.notEmpty());

            }

            userServices.editedUserSave(editedPatient);
            if (userServices.editedUserSave(editedPatient)) messages.successfulSaving();
            else messages.unsuccessfulSaving();
        }
    }



    //Bekéri a betegnek a tajszámát, majd megkeresi azt az Xml fileban és kitörli a kiválasztott Usert
    public static void delete() throws ParserConfigurationException, IOException, SAXException, ParseException, TransformerException {
        System.out.println(messages.yellow + "\nA beteg adatainak törlését választotta. " + messages.reset);
        messages.continueOrback();
        if (scannerLimit.yesOrNo() == 0)run();
        System.out.println(messages.yellow + "\nKérem adja meg a beteg TAJ számát:  " + messages.reset);
        String search = scannerLimit.numberValidate9();
        if (userServices.userSearch(search)){
            messages.found();
            System.out.println("Biztos törölni szeretné a "+ search + " tajszámmal rendelkező beteget? 1/0");
            choice = scannerLimit.yesOrNo();
            if (choice == 1) {
            userServices.deleteUser(search);
            messages.successfulDelete();}
        }
        else  messages.notFound(); start.run();

    }
}



