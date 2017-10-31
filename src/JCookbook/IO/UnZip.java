package JCookbook.IO;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;
public class UnZip
{
    public static void main(String[] args)
    {
        byte[] b = new byte[8092];
        try
        {
            ZipFile zf = new ZipFile("src/JCookbook/IO/1234.zip");
            Enumeration<ZipEntry> all = (Enumeration<ZipEntry>)zf.entries();
            while (all.hasMoreElements())
            {
                ZipEntry ze = all.nextElement();
                FileOutputStream fout = new FileOutputStream("src/JCookbook/IO/"+ze.getName());
                InputStream strin = zf.getInputStream(ze);

                int n = 0;
                while ((n = strin.read(b)) >0)
                    fout.write(b, 0, n);
                fout.close();
                strin.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
