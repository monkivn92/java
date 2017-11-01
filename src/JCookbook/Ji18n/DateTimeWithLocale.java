package JCookbook.Ji18n;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
public class DateTimeWithLocale
{

    public static void main(String[] args)
    {
        Locale lcVI  = new Locale("vi");
        Locale lcFR = Locale.FRANCE;
        Locale lcUK = new Locale("en","uk");
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat dfFR = DateFormat.getDateInstance(DateFormat.MEDIUM, lcFR);
        DateFormat dfUK = DateFormat.getDateInstance(DateFormat.MEDIUM, lcUK);
        DateFormat dfVI = DateFormat.getDateInstance(DateFormat.MEDIUM, lcVI);
        Date now = new Date();
        System.out.println("Defaul: "+df.format(now));
        System.out.println(lcFR.getDisplayName()+" : "+dfFR.format(now));
        System.out.println(lcUK.getDisplayName()+" : "+dfUK.format(now));
        System.out.println(lcVI.getDisplayName()+" : "+dfVI.format(now));

        NumberFormat nf = NumberFormat.getInstance();
        Locale.setDefault(Locale.US);
        System.out.println(nf.format(123.456567));
    }
}
