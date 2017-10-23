package JCookbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo
{
    public static void main(String[] argv)
    {
        /*
        the methods of Vector are synchronized, meaning that they can be accessed from
        multiple threads . This does mean more overhead, though,
        so in a single-threaded applica‐tion it is usually faster to use an ArrayList
        */
        ArrayList<jhelp> al = new ArrayList<>();

        // Add lots of elements to the ArrayList...
        al.add(new jhelp(1));
        al.add(new jhelp(2));
        al.add(new jhelp(3));
        // Print them out using old-style for loop to index number.
        System.out.println("Retrieving by index:");
        for (int i = 0; i<al.size(); i++)
        {
            System.out.println("Element " + i + " = " + al.get(i));
        }

        List<String> lastNames =
                Arrays.asList( ( new String[]{"Smith", "Jones", "MacKenzie"} ) );

        lastNames.forEach((s)-> jhelp.echoln(s));
        jhelp.echoln(lastNames.getClass());
    }
}
