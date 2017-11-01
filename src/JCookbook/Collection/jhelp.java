package JCookbook.Collection;

public class jhelp
{
    private  int count = 0 ;
    jhelp(int c)
    {
        this.count = c;
    }
    public static void echo(String str)
    {
        System.out.print(str);
    }
    public static void echoln(String str)
    {
        System.out.println(str);
    }

    public static void echoln(Object obj)
    {
        System.out.println(obj.toString());
    }

    public String toString()
    {
        return "Object number "+this.count;
    }
}
