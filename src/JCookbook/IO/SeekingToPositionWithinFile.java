package JCookbook.IO;
import java.io.*;
public class SeekingToPositionWithinFile
{
    public static void main(String[] args)
    {
        try
        {
            RandomAccessFile seeker = new RandomAccessFile("src/JCookbook/a.txt", "r");
            System.out.println(seeker.getFilePointer());
            System.out.println(seeker.readLine());
            seeker.seek(seeker.getFilePointer() + 30);
            System.out.println(seeker.getFilePointer());
            System.out.println(seeker.readLine());
        }
        catch (IOException e)
        {
            System.out.println("Error: "+e);
        }
    }
}
