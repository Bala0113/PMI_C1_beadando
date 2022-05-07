import java.util.Calendar;
import java.util.Date;
    // Üzenetek iratása konzolra;
public class messages {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static void menu(){
        System.out.println(yellow +"""
                \nVálasszon az alábbi menüpontok közül...
                (1)\tÚj beteg hozzáadása
                (2)\tSzerkesztés
                (3)\tTörlés
                (4)\tPáciensek listázása
                (5)\tKilépés""" + reset);
    }
    public static void welcome(){
        Date today = Calendar.getInstance().getTime();
        System.out.println(yellow +"Üdv, a belépés ideje :\t" + today + "\nJó munkát kívánok!");
    }
    public static void errorMenu(){
        System.out.println(red +"\nHIBA!\t Kérem csak 1 --> 5 adjon meg karaktereket!\n Próbálja újra..."+ reset);
    }
    public static void notEmpty() {
        System.out.println(red +"\nHIBA!\t Kérem ne hagyjon kitöltetlenül adatot!"+ reset);
    }
    public static void notNumber() {
        System.out.println(red +"\nHIBA!\t Ez az adat csak szám lehet..."+ reset);
    }
    public static void notNumber9() {
        System.out.println(red +"\nHIBA!\t Ez az adat csak szám lehet és 9 számjegyből kell állnia..."+ reset);
    }
    public static void onlyYOrN() {
        System.out.println(red +"\nHIBA!\t Ez az válasz csak 1 vagy 0 lehet... (1=igen | 0=nem)\n Próbálja újra..."+ reset);
    }
    public static void successfulSaving(){
        System.out.println(green +"\nSikeres mentés!\""+ reset);
    }
    public static void unsuccessfulSaving() {
        System.out.println(red +"\n Sikertelen mentés!"+ reset);
    }
    public static void found() {
        System.out.println(green +"\n A beteg adatai megtalálva!"+ reset);
    }
    public static void exit() {
        System.out.println(green +"\n További szép napot!"+ reset);
    }
    public static void successfulDelete() {
        System.out.println(green + "A beteg adatai sikeresen törlődtek!" + reset);
    }
    public static void notDate() {
        System.out.println(red +"\nHIBA!\t Ez az adat csak dátum lehet! (pl:2001.01.13)"+ reset);
    }
    public static void succesfulAdded(){
        System.out.println(green +"A beteg adatait sikeresen felvettük adatbázisunkba!"+ reset);
    }

    public static void notFound() {
        System.out.println(red+ "Nem található ilyen taj számmal rendelkező beteg..."+reset);
    }
    public static void continueOrback() {
        System.out.println(yellow+ "Szeretné folytatni?  1/0"+reset);
    }
}
