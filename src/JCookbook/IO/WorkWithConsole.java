package JCookbook.IO;

public class WorkWithConsole
{
    public static void main(String args[])
    {
        /*
        //Get value from console
        try
        {
            BufferedReader bfrd = new BufferedReader( new InputStreamReader(System.in));
            String input_val = bfrd.readLine();
            int inval = Integer.parseInt(input_val);
            jhelp.echoln("You have input: " + inval);
        }
        catch (IOException e)
        {
            jhelp.echoln("Error: "+e);
        }
        */

        /*
        //////--COntroll Console elment !! Not working because Intellij doen't have real console
        Console consoler;
        char[] pwd;
        consoler = System.console();
        pwd = System.console().readPassword("Enter something...");
        if(pwd.length > 0)
        {
            // Shred this in-memory copy for security reasons
            java.util.Arrays.fill(pwd, '*');

        }
        */


    }
}
