package JCookbook.FileDirSystem;
import java.io.*;
public class DirList
{
    public  static void main(String[] args)
    {
        File[] drives = File.listRoots(); // Get list of names
        for (File dr : drives)
        {
            System.out.println(dr); // Print the list
        }

        File fi = new File("src/JCookbook");
        String[] fs = fi.list();
        for (String f : fs)
        {
            System.out.println(f); // Print the list
        }

        File[] ffs = fi.listFiles();
        for (File f : ffs)
        {
            System.out.println(f.getAbsolutePath()); // Print the list
        }

    }
}
