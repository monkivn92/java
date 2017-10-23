package JCookbook;

public class SingletonWithEnum
{
    public static void main(String[] unused)
    {
        jhelp.echoln(ThisClassIsSingleton.INSTANCE.sum());
    }
}
enum ThisClassIsSingleton
{
    INSTANCE;
    int a, b;
    private ThisClassIsSingleton()
    {
        a = 1;
        b = 9;
    }
    public int sum()
    {
        return a+b;
    }
}