import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class usersList {
    public static void userList(){

        String fmt = "%1$10s %2$20s %3$20s %4$20s %5$20s %6$20s %7$20s%n";       //  Formátum a kiíráshoz
        System.out.printf(fmt,"Tajszám","Név","Születési idő","Lakhely","Telefonszám","Szoba","Diagnózis");

        for (int i = 0; i< start.users.size();i++) {
            System.out.printf(fmt,start.users.get(i).getTaj(),start.users.get(i).getNev(),userServices.df.format(start.users.get(i).getSzul()),start.users.get(i).getLak(),
                    start.users.get(i).getTel(),start.users.get(i).getSzoba(),start.users.get(i).getDiagn());

        }

    }

}
