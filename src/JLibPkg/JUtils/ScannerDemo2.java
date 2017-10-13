package JLibPkg.JUtils;
import java.util.*;
import java.io.*;
public class ScannerDemo2
{
    public static void FFFFF()
    {
        String instr = "Name: Tom Age: 28 ID: 77";

        Scanner conin = new Scanner(instr);
        // Find and display age.
        conin.findInLine("ID:"); // find Age
        if(conin.hasNext())
            System.out.println(conin.next());
        else
            System.out.println("Error!");
        conin.close();
    }

    public static void main(String args[]) throws IOException
    {
        int count = 0;
        double sum = 0.0;
        final String dir = System.getProperty("user.dir");
        // Write output to a file.
        FileWriter fout = new FileWriter(dir+"/src/JLibPkg/JUtils/test.txt");
        fout.write("2, 3.4,     5,6, 7.4, 9.1, 10.5, done");
        fout.close();



        FileReader fin = new FileReader(dir+"/src/JLibPkg/JUtils/test.txt");
        Scanner src = new Scanner(fin);
        // Set delimiters to space and comma.
        src.useDelimiter(", *");

        // Read and sum numbers.
        while(src.hasNext())
        {
            if(src.hasNextDouble())
            {
                sum += src.nextDouble();
                count++;
            }
            else
            {

                String str = src.next();
                if(str.equals("done")) break;
                else
                {
                    System.out.println("File format error.");
                    return;
                }
            }
        }
        src.close();
        System.out.println("Average is " + sum / count);

        FFFFF();
    }
}
