package JLibPkg.JNIO;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DirectoryWatcherExample
{
    public static void main(String[] args)
    {
        WatchService wsv = null;
        String dirname = "src/JLibPkg/JNIO";
        Path path = Paths.get(dirname);

        try
        {
            wsv = FileSystems.getDefault().newWatchService();
        }
        catch (IOException e)
        {
            System.out.println("I/O error: "+e);
        }

        if(wsv != null)
        {
            try
            {
                path.register(wsv, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            }
            catch (IOException e)
            {
                System.out.println("I/O error: "+e);
            }

            WatchKey key;

            try
            {

                while ((key = wsv.take()) != null)
                {
                    for (WatchEvent<?> event : key.pollEvents())
                    {
                        System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
                    }
                    key.reset();
                }
            }
            catch (InterruptedException in)
            {
                System.out.println("Interupt "+ in);
            }
        }


    }
}
