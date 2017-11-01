package JCookbook.Collection;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeStamp
{
    public  static void main(String[] args)
    {
        Instant fromunix = Instant.ofEpochMilli(1491629455);
        ZoneId zid = ZoneId.systemDefault();
        ZonedDateTime ztime = ZonedDateTime.ofInstant(fromunix, zid);
        DateTimeFormatter nTZ =    DateTimeFormatter.ofPattern("yyyy-MM-d h:m:ss");
        System.out.println(ztime.format(nTZ));


        String str = "2017-04-08 12:30:55";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime lcd = LocalDateTime.parse(str, formatter);
        System.out.println(lcd.atZone(zid).toEpochSecond());
    }
}
