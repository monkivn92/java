package JLibPkg.JCollection;
import java.util.*;

// A reverse comparator for strings.
class MyComp implements Comparator<String>
{

    public int compare(String aStr, String bStr)
    {
        // Reverse the comparison.
        return aStr.compareTo(bStr);
    }
    // No need to override equals or the default methods.
}
class ComparatorDemo
{
    public static void main(String args[])
    {
        // Create a tree set. Solution 1
        TreeSet<String> ts = new TreeSet<String>(new MyComp());

        //Solution 2
        Comparator<String> mc = (a, b) -> a.compareTo(b);
        TreeSet<String> ts2 = new TreeSet<String>(mc);

        //Solution 3
        TreeSet<String> ts3 = new TreeSet<String>( (a, b) -> a.compareTo(b) );

        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        // Display the elements.
        for(String element : ts)
            System.out.print(element + " ");
        System.out.println();
    }
}
