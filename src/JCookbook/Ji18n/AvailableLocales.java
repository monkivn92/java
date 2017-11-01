package JCookbook.Ji18n;

import java.util.Locale;

public class AvailableLocales
{
    public static void main(String[] args)
    {
        // File ListLocales.java
        Locale[] list = Locale.getAvailableLocales( );
        for (Locale loc : list)
        {
            System.out.println(loc);
        }
    }
}
