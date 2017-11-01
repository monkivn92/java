package JCookbook.Collection;
import java.util.Formatter;
public class StringAlign
{
    public static void main(String[] args)
    {
        Formatter fmt = new Formatter();
        fmt.format("%15s","aaa");
        System.out.println(fmt);

        fmt = new Formatter();
        fmt.format("%15s","bbbbbbbbbbbb");
        System.out.println(fmt);
    }
}
