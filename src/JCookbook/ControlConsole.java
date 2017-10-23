package JCookbook;

import java.io.Console;

public class ControlConsole
{
    public static void main(String[] args)
    {
        char[] pwd = System.console().readPassword("Enter pwd: ");
        //IDE doesn't have Console
        if(pwd.length > 0)
        {
            java.util.Arrays.fill(pwd, '*');
            System.out.println(pwd);
        }

    }


}
