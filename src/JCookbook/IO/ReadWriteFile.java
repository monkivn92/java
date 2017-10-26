package JCookbook.IO;
import java.io.*;

/*
If you have fewer connections with very high bandwidth, sending a lot of data at a time,
perhaps a classic IO server implementation might be the best fit.

If you are dealing with large files, FileChannel can be faster than standard IO.

If you need to manage thousands of open connections simultanously,
which each only send a little data, for instance a chat server,
implementing the server in NIO is probably an advantage.
Similarly, if you need to keep a lot of open connections to other computers,
 e.g. in a P2P network, using a single thread to manage all of your outbound connections might be an advantage.
*/

public class ReadWriteFile
{
    public static void main(String[] args)
    {

        try(BufferedReader bfin = new BufferedReader(new FileReader("src/JCookbook/a.txt")))
        {
           /* String rline;
            while ((rline = bfin.readLine()) != null)
            {
                System.out.println(rline);
            }
            */
            int rchar;
            while ((rchar = bfin.read()) != -1)
            {
                System.out.print((char)rchar);
            }

            bfin.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        //try(BufferedWriter bfout = new BufferedWriter(new FileWriter("src/JCookbook/c.txt")))
        try(BufferedWriter bfout = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("src/JCookbook/kanji.txt"), "UTF-8")
                )
        )
        {
            /*
            String outtxt = "This is a test";
            bfout.write(outtxt, 0, outtxt.length());
            bfout.flush();
            bfout.close();
            System.out.println("Write done");
            */
            String outtxt = "高邁な理想であると存じます";
            char[] strarr = outtxt.toCharArray();
            for(char c:strarr)
            {
                if(c != 'i')
                    bfout.write(c);
            }
            bfout.flush();
            bfout.close();
            System.out.println("Write done");

        }
        catch(IOException e2)
        {
            System.out.print(e2);
        }

    }
}
