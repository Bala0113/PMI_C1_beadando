import java.util.Calendar;
import java.util.Date;

public class messages {

    public static void menu(){
        System.out.println("""
                \nVálasszon az alábbi menüpontok közül...
                (1)\tÚj beteg hozzáadása
                (2)\tSzerkesztés
                (3)\tTörlés
                (4)\tPáciensek listázása""");
    }
    
    public static void welcome(){
        Date today = Calendar.getInstance().getTime();
        System.out.println("Üdv, a belépés ideje :\t" + today + "\nJó munkát kívánok!");
    }

    public static void errorMenu(){
        System.out.println("\nHIBA!\t Kérem csak 1 --> 4 adjon meg karaktereket!");
    }


    public static void notNumber() {
        System.out.println("\nHIBA!\t Ez az adat csak szám lehet...");
    }

    public static void onlyYOrN() {
        System.out.println("\nHIBA!\t Ez az adat csak 1 vagy 0 lehet... (1=igen | 0=nem");
    }
}
