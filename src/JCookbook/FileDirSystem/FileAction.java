package JCookbook.FileDirSystem;
import java.io.*;
public class FileAction
{
    public  static void main(String[] args)
    {
        File fi = new File("src/JCookbook/FileDirSystem/file1.txt");
        try
        {
            fi.createNewFile();
            fi.renameTo(new File("src/JCookbook/FileDirSystem/file2.txt"));
            fi.delete();

            ///////////////////////////////////////////////////////////
            // 1. Make an existing file temporary
            // Construct a File object for the backup created by editing
            // this source file. The file probably already exists.
            // My editor creates backups by putting ~ at the end of the name.
            File bkup = new File("src/JCookbook/FileDirSystem/Rename.java~");
            // Arrange to have it deleted when the program ends.
            bkup.deleteOnExit();
            // 2. Create a new temporary file.
            // Make a file object for foo.tmp, in the default temp directory
            File tmp = File.createTempFile("foo", "tmp");
            // Report on the filename that it made up for us.
            System.out.println("Your temp file is " + tmp.getCanonicalPath());
            // Arrange for it to be deleted at exit.
            tmp.deleteOnExit();
            System.out.println("Your temp file is " + tmp.getCanonicalPath());


        }
        catch (IOException e)
        {
            System.out.println(e);
        }



    }

}
