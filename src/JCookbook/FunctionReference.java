package JCookbook;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionReference
{
    interface FunInterface
    {
        void process(int i, String j, char c, double d);
    }
    public static void work(int i, String j, char c, double d)
    {
        System.out.println("Moo");
    }

    static final String[] unsortedNames = {
            "Gosling", "de Raadt", "Torvalds", "Ritchie", "Hopper"
    };

    public static void main(String[] args)
    {
        FunInterface sample = FunctionReference::work;
        System.out.println("My process method is " + sample);
        ////////////////
        String[] names;
        names = unsortedNames.clone();
        Arrays.sort(names, String::compareToIgnoreCase);

        // Equivalent Lambda:
        names = unsortedNames.clone();
        Arrays.sort(names, (str1, str2) -> str1.compareToIgnoreCase(str2));

        // Equivalent old way:
        names = unsortedNames.clone();
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });


    }
}
