package JCookbook.IO;
import java.io.*;

import java.util.zip.*;

public class MakeZipFile
{
    public static void main(String[] args)
    {
        try
        {

            // let's create a ZIP file to write data
            FileOutputStream fos = new FileOutputStream("src/JCookbook/IO/sample.zip");
            ZipOutputStream zipOS = new ZipOutputStream(fos);

            String file1 = "src/JCookbook/IO/bh34.png";
            String file2 = "src/JCookbook/IO/toolbar.png";

            File aFile1 = new File(file1);
            File aFile2 = new File(file2);

            FileInputStream fis1 = new FileInputStream(aFile1);
            FileInputStream fis2 = new FileInputStream(aFile2);

            ZipEntry zipEntry1 = new ZipEntry("bh34.png");
            ZipEntry zipEntry2 = new ZipEntry("toolbar.png");

            zipOS.putNextEntry(zipEntry1);
            zipOS.putNextEntry(zipEntry2);

            byte[] bytes = new byte[1024];
            int length;

            while ((length = fis1.read(bytes)) >= 0)
            {
                zipOS.write(bytes, 0, length);
            }

            while ((length = fis1.read(bytes)) >= 0)
            {
                zipOS.write(bytes, 0, length);
            }

            fis1.close();
            fis2.close();
            zipOS.close();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
