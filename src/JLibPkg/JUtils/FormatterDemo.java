package JLibPkg.JUtils;

import java.util.*;

public class FormatterDemo
{
    public static void main(String[] args)
    {
        Formatter fmt = new Formatter();
        /*

        fmt.format("Formatting %s is easy %d %f", "with Java", 10, 98.6);
        System.out.println(fmt);
        fmt.close();

        for(double i=1.23; i < 1.0e+6; i *= 100)
        {
            fmt.format("%f %e", i, i);
            System.out.println(fmt);
        }

        */

        Calendar cal = Calendar.getInstance();
// Display standard 12-hour time format.
        fmt.format("%tr", cal);
        System.out.println(fmt);
        fmt.close();

// Display complete time and date information.
        fmt = new Formatter();
        fmt.format("%tc", cal);
        System.out.println(fmt);
        fmt.close();

// Display just hour and minute.
        fmt = new Formatter();
        fmt.format("%tl:%tM", cal, cal);
        System.out.println(fmt);
        fmt.close();

// Display month by name and number.
        fmt = new Formatter();
        fmt.format("%tB %tb %tm", cal, cal, cal);
        System.out.println(fmt);
        fmt.close();

        fmt= new Formatter();
        fmt.format("Copying file%nTransfer is %d%% complete", 88);
        System.out.println(fmt);
        fmt.close();

        fmt= new Formatter();
        fmt.format("|%f|%n|%12f|%n|%012f|", 10.12345, 10.12345, 10.12345);
        System.out.println(fmt);
        fmt.close();


        // Format 4 decimal places.
        fmt= new Formatter();
        fmt.format("%.4f", 123.1234567);
        System.out.println(fmt);
        fmt.close();

// Format to 2 decimal places in a 16 character field
        fmt = new Formatter();
        fmt.format("%16.2e", 123.1234567);
        System.out.println(fmt);
        fmt.close();

// Display at most 15 characters in a string.
        fmt = new Formatter();
        fmt.format("|%.15s|", "Formatting with Java is now easy.");
        System.out.println(fmt);
        fmt.close();

        // Right justify by default
        fmt = new Formatter();
        fmt.format("|%10.2f|", 123.123);
        System.out.println(fmt);
        fmt.close();
        // Now, left justify.
        fmt = new Formatter();
        fmt.format("|%-10.2f|", 123.123);
        System.out.println(fmt);
        fmt.close();


        fmt = new Formatter();
        fmt.format("% d", -100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", -200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%(d", -100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%,.2f", 4356783497.34);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%3$d %1$d %2$d ||| ", 10, 20, 30);
        fmt.format("%d in hex is %1$x ||| ", 255);
        fmt.format("%2$d %3$d in hex is %<x %<x %<x", 255, 111, 222, 34);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("Today is day %te of %<tB, %<tY", cal);
        System.out.println(fmt);
        fmt.close();

        //auto close formatter
        try (Formatter fmt2 = new Formatter())
        {
            fmt2.format("Formatting %s is easy %d %f", "with Java",
                    10, 98.6);
            System.out.println(fmt2);
        }

    }
}
