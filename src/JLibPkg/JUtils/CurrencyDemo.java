package JLibPkg.JUtils;
import java.util.*;
public class CurrencyDemo
{
    public static void main(String args[])
    {
        Currency c;
        c = Currency.getInstance(Locale.CHINA);
        System.out.println("Symbol: " + c.getSymbol());
        System.out.println("Default fractional digits: " +  c.getDefaultFractionDigits());
    }
}
