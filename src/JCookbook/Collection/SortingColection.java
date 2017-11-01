package JCookbook.Collection;

import java.util.Arrays;
import java.util.Comparator;

public class SortingColection
{
    public static void main(String[] unused)
    {
        String[] strings = {
                "painful",
                "mainly",
                "gaining",      "raindrops"};

        jhelp.echoln("sort by default");
        Arrays.sort(strings);

        System.out.println(strings.toString());


        jhelp.echoln("sort by comparator");
        Arrays.sort(strings, new StrComp());
        System.out.println(strings.toString());
    }
}

class StrComp implements Comparator<String>
{
    public int compare(String str1, String str2)
    {
        String t1 = str1.substring(1);
        String t2 = str2.substring(1);
        return t1.compareTo(t2);
    }
}
