package JCookbook.Collection;
import java.util.*;

public class SysEnvVar
{
    public static void main(String args[])
    {
        System.out.println(System.getenv("CLASSPATH"));
        Properties p = System.getProperties();
        System.out.print(p.get("java.class.path"));
        p.list(System.out);
    }
}
