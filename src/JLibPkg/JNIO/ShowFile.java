package JLibPkg.JNIO;

/* Display a text file using stream-based, NIO code.
Requires JDK 7 or later.
To use this program, specify the name
of the file that you want to see.
For example, to see a file called TEST.TXT,
use the following command line.
java ShowFile TEST.TXT
*/
import java.io.*;
import java.nio.file.*;
class ShowFile {
    public static void main(String args[])
    {
        int i;

        // Open the file and obtain a stream linked to it.
        try ( InputStream fin = Files.newInputStream(Paths.get("src/JLibPkg/JNIO/file3.txt")) )
        {
            do
            {
                i = fin.read();
                if(i != -1) System.out.print((char) i);
            } while(i != -1);
        }
        catch(InvalidPathException e)
        {
            System.out.println("Path Error " + e);
        }
        catch(IOException e)
        {

            System.out.println("I/O Error " + e);
        }
    }
}
