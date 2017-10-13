package JLibPkg.JStreamAPI;

// Demonstrate the use of a combiner with reduce()

import java.util.*;
import java.util.stream.*;

class StreamDemo3 {

    public static void main(String[] args) {

        // This is now a list of double values.
        ArrayList<Double> myList = new ArrayList<>( );

        myList.add(36.0);
        myList.add(9.0);
        myList.add(16.0);
        myList.add(25.0);


        double productOfSqrRoots = myList.parallelStream().reduce(
                1.0,
                (a,b) -> a * Math.sqrt(b),
                (a,b)-> a * b
        );

        System.out.println("Product of square roots: " + productOfSqrRoots);
    }
}
