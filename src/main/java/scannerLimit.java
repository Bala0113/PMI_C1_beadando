import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class scannerLimit {
        // A helytelen bevitelt megelőző függvények:
    public static int answer;
    public static String sAnswer;

    public static int yesOrNo(){
        while (true) {
            sAnswer = start.scanner.next();
            if (sAnswer.equals("0") || sAnswer.equals("1"))
            {
                answer = Integer.parseInt(sAnswer);
                break;
            }
            else messages.onlyYOrN();
        }
        return answer;
    }


    public static int menuChoice(){
        while (true) {
            sAnswer = start.scanner.next();
            if (sAnswer.equals("1") || sAnswer.equals("2")|| sAnswer.equals("3")|| sAnswer.equals("4")|| sAnswer.equals("5"))
            {
                answer = Integer.parseInt(sAnswer);
                break;
            }
            else messages.errorMenu();
        }
        return answer;
    }



    public static String dateValidate() {
        String strDate;
        while (true) {
            strDate = start.scanner.nextLine();
            if (strDate.trim().equals("")) messages.notDate();
            else {
                SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy.MM.dd");
                sdfrmt.setLenient(false);
                try {
                    Date Date = sdfrmt.parse(strDate);
                    break;
                }
                catch (ParseException e) {
                    messages.notDate();
                }
            }
        }
        return strDate;
    }

    public static String numberValidate9(){
        while (true) {            sAnswer = start.scanner.next();
            if (sAnswer.matches("[0-9]+") && sAnswer.length() == 9) {
                answer = Integer.parseInt(sAnswer);
                break;}
            else messages.notNumber9();
            }
        return sAnswer;
    }

    public static String numberValidate(){
        while (true) {
            sAnswer = start.scanner.nextLine();
            if (sAnswer.matches("[0-9]+")) {
                break;}
            else messages.notNumber();
        }
        return sAnswer;
    }

    public static String notEmpty(){
        while (true) {
            sAnswer = start.scanner.nextLine();
            if ( sAnswer.equals("")) {
                messages.notEmpty();
            }
            else break;
        }
        return sAnswer;

    }
}
