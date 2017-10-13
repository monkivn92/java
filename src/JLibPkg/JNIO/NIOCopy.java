package JLibPkg.JNIO;

// Copy a file using NIO. Requires JDK 7 or later.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
public class NIOCopy
{
    public static void main(String args[])
    {

        try
        {
            Path source = Paths.get("src/JLibPkg/JNIO/file2.txt");
            Path target = Paths.get("src/JLibPkg/JNIO/file3.txt");
            // Copy the file.
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        }
        catch(InvalidPathException e)
        {
            System.out.println("Path Error " + e);
        }
        catch (IOException e)
        {
            System.out.println("I/O Error " + e);
        }
    }
}