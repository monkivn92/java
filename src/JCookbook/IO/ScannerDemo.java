package JCookbook.IO;
import java.io.InputStreamReader;
import java.util.Scanner;
import JCookbook.Collection.jhelp;
public class ScannerDemo
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(new InputStreamReader(System.in));
        while (scn.hasNext())
        {
            if(scn.hasNextInt())
            {
                jhelp.echoln(scn.next());
            }
            else
            {
                jhelp.echoln("Word "+scn.next());
            }

        }
    }
}
