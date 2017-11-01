package JCookbook.FileDirSystem;
import java.io.*;
public class makeDir
{
    public  static void main(String[] args)
    {

            new File("src/JCookbook/FileDirSystem/bin").mkdir();
            new File("src/JCookbook/FileDirSystem/a/b/c").mkdirs();

    }
}
