package JCookbook.FileDirSystem;

import java.io.File;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class FileInfo
{
    public  static void main(String[] args)
    {

        File fi = new File("src/JCookbook/FileDirSystem/FileInfo.java");
        if(!fi.exists())
        {

            System.out.println("File not found");
        }
        else
        {
            System.out.println("Found 1 file");
            System.out.println(fi.getAbsolutePath());

            Instant fromunix = Instant.ofEpochMilli(fi.lastModified());
            ZoneId zid = ZoneId.systemDefault();
            ZonedDateTime ztime = ZonedDateTime.ofInstant(fromunix, zid);
            DateTimeFormatter nTZ =    DateTimeFormatter.ofPattern("yyyy-MM-d h:m:ss");
            System.out.println(ztime.format(nTZ));

        }




    }
}
