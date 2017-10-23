package JCookbook;

import java.time.LocalDate;
import java.time.Period;

public class AddSubtractDateTime
{
    public static void main(String[] args)
    {
        /** Today's date */
        LocalDate now = LocalDate.now();
        Period p = Period.ofDays(700);
        LocalDate then = now.plus(p);
        System.out.printf("Seven hundred days from %s is %s%n", now, then);
    }
}
