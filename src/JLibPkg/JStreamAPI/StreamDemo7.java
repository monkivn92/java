package JLibPkg.JStreamAPI;

// Use collect() to create a List and a Set from a stream.

import java.util.*;
import java.util.stream.*;

class Name22PhoneEmail {
    String name;
    String phonenum;
    String email;

    Name22PhoneEmail(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class Name22Phone {
    String name;
    String phonenum;

    Name22Phone(String n, String p) {
        name = n;
        phonenum = p;
    }
}

class StreamDemo7 {

    public static void main(String[] args) {

        // A list of names, phone numbers, and e-mail addresses.
        ArrayList<Name22PhoneEmail> myList = new ArrayList<>( );

        myList.add(new Name22PhoneEmail("Larry", "555-5555",
                "Larry@HerbSchildt.com"));
        myList.add(new Name22PhoneEmail("James", "555-4444",
                "James@HerbSchildt.com"));
        myList.add(new Name22PhoneEmail("Mary", "555-3333",
                "Mary@HerbSchildt.com"));

        // Map just the names and phone numbers to a new stream.
        Stream<Name22Phone> nameAndPhone = myList.stream().map(
                (a) -> new Name22Phone(a.name,a.phonenum)
        );

        // Use collect to create a List of the names and phone numbers.
        List<Name22Phone> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Names and phone numbers in a List:");
        for(Name22Phone e : npList)
            System.out.println(e.name + ": " + e.phonenum);

        // Obtain another mapping of the names and phone numbers.
        nameAndPhone = myList.stream().map(
                (a) -> new Name22Phone(a.name,a.phonenum)
        );

        // Now, create a Set by use of collect().
        Set<Name22Phone> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("\nNames and phone numbers in a Set:");
        for(Name22Phone e : npSet)
            System.out.println(e.name + ": " + e.phonenum);
    }
}

