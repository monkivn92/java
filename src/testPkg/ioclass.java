package testPkg;

import java.io.*;

public class ioclass
{
    public static void main(String[] args)
    {
        int i;

        final String dir = System.getProperty("user.dir");


        try(FileInputStream file = new FileInputStream(dir+"/src/testPkg/abc.txt");
            FileOutputStream fw = new FileOutputStream(dir+"/src/testPkg/abc3.txt"))
        {

            do {
                i = file.read();
                if(i != -1) fw.write(i);
            } while(i != -1);
        }
        catch(FileNotFoundException e2)
        {
            System.out.println("File not found");
        }
        catch (IOException e1)
        {
            System.out.println("IO errors occur");
        }
       /* finally
        {
            try
            {
                if(file != null)
                {
                    file.close();
                }
            }
            catch (IOException e3)
            {
                System.out.println("IO errors occur when closing file");
            }

            try
            {
                if(fw != null)
                {
                    fw.close();
                }
            }
            catch (IOException e4)
            {
                System.out.println("IO errors occur when closing file");
            }
        }
*/
    }

}
