package JCookbook.Network;
import java.io.IOException;
import java.net.Socket;
public class SimpleConnect
{
    public static void main(String[] args)
    {
        try (Socket sock = new Socket("google.com", 3306))
        {
            /* If we get here, we can read and write on the socket "sock" */
            System.out.println(" *** Connected OK ***");
            /* Do some I/O here... */
            System.out.println(sock.getInetAddress());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
