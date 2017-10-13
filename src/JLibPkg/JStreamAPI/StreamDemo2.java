package JLibPkg.JStreamAPI;

// Demonstrate the reduce() method.

import java.util.*;
import java.util.stream.*;

class StreamDemo2
{

    public static void main(String[] args)
    {

        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>( );

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        // Two ways to obtain the integer product of the elements
        // in myList by use of reduce().
        Optional<Integer> productObj = myList.stream().reduce((a,b) -> a*b);
        if(productObj.isPresent())
            System.out.println("Product as Optional: " + productObj.get());

        int product = myList.stream().reduce(2, (a,b) -> a*b);
        System.out.println("Product as int: " + product);
    }
}

