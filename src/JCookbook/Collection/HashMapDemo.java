package JCookbook.Collection;

import java.util.HashMap;

public class HashMapDemo
{
    public static void main(String[] argv)
    {
        /*The Hashtable methods are synchronized, for use with multiple
threads. They are therefore slower, and unless you need the synchro‐
nization, use the newer HashMap.*/
        HashMap<String, String> hm = new HashMap<>();
        hm.put("aaa","34 vw");
        hm.put("aaea","34    34tvw");
        hm.put("aaseaa","34 vafdsw");
        hm.put("aa436a","34 ertqreyvw");

        hm.entrySet().forEach(item-> jhelp.echoln("Key: "+item.getKey() + " - Value: " + item.getValue()));
    }
}
