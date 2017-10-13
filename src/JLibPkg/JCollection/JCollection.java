package JLibPkg.JCollection;
import java.util.*;

public class JCollection
{
    public static void main(String args[])
    {
        // Create an array list.
        ArrayList<String> al = new ArrayList<String>();
        System.out.println("Initial size of al: " +  al.size());
        // Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");

        // Use iterator to display contents of al.
        System.out.print("Original contents of al: ");
        Iterator<String> itr = al.iterator();
        while(itr.hasNext())
        {
            String element = itr.next();
            System.out.print(element + " ");
        }

        System.out.println();

        // Modify objects being iterated.
        ListIterator<String> litr = al.listIterator();
        while(litr.hasNext())
        {
            String element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();
        while(itr.hasNext())
        {
            String element = itr.next();
            System.out.print(element + " ");
        }

        System.out.println();

        // Now, display the list backwards.
        System.out.print("Modified list backwards: ");
        while(litr.hasPrevious())
        {

            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("Foreach:...");
        for(String v : al)
            System.out.print(v + " ");

        /////Spliterator
        // Create an array list for doubles.
        ArrayList<Double> vals = new ArrayList<>();
        // Add values to the array list.
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        // Use tryAdvance() to display contents of vals.
        System.out.println("\nContents of vals:\n");
        Spliterator<Double> spltitr = vals.spliterator();
        while( spltitr.tryAdvance( (n) -> System.out.println(n) ) );
        System.out.println();

        // Create new list that contains square roots.
        spltitr = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while( spltitr.tryAdvance( (n) -> sqrs.add(Math.sqrt(n)) ) );


        // Use forEachRemaining() to display contents of sqrs.
        System.out.print("Contents of sqrs:\n");
        spltitr = sqrs.spliterator();
        spltitr.forEachRemaining( (n) -> System.out.println(n) );
        System.out.println();


    }
}
