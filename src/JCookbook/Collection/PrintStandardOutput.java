package JCookbook.Collection;

import java.io.PrintWriter;

public class PrintStandardOutput
{
    public static void main(String[] args) {
        // Just a String to include in printouts.
        String myAnswer = "No, and that's final,";

        // Print to standard output
        System.out.println("Hello World of Java");
        // Print several things concatenated.
        System.out.println("The answer is " + myAnswer + " at this time.");

        System.out.printf("The answer is %s at this time\n", myAnswer); // the 1.5 way

        PrintWriter pw = new PrintWriter(System.out);
        pw.print("PrintWriteraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        pw.flush();
        pw.close();
    }
}
