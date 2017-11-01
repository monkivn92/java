package JCookbook.Collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo
{
    public static void main(String args[])
    {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("One"); // DUPLICATE
        hashSet.add("Three");
        hashSet.forEach(s -> System.out.println(s));
    }
}
