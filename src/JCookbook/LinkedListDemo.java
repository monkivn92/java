package JCookbook;


import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo
{
    public static void main(String[] argv)
    {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("abc");
        ll.add("defttt");
        ll.add((new jhelp(5)).toString());

        ListIterator iter = ll.listIterator();
        while (iter.hasNext())
        {
            jhelp.echoln(iter.next());
        }
        jhelp.echoln("revesed direct:");

        while (iter.hasPrevious())
        {
            jhelp.echoln(iter.previous());
        }


    }
}
