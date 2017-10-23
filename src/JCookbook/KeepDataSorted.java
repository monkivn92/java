package JCookbook;

import java.util.TreeMap;

public class KeepDataSorted
{
    public static void main(String[] unused)
    {
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("abc", "abc");
        tm.put("def", "def");
        tm.put("dhi", "dhi");
        tm.put("abc#@", "abc#@");
        tm.put("abc", "abc");

        jhelp.echoln("Size: "+tm.size());

        tm.forEach((key, val)-> jhelp.echoln(key + " : "+val));



    }
}
