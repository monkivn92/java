package JCookbook.ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class creatSocketwithPortnumber
{
    /** The TCP port for the service. */
    public static final short PORT = 9999;

    public static void main(String[] argv) throws IOException
    {
        ServerSocket sock;
        Socket clientSock;
        try
        {
            sock = new ServerSocket(PORT);
            while ((clientSock = sock.accept()) != null)
            {

                // Process it.
                process(clientSock);
            }

        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }

    /** This would do something with one client. */
    static void process(Socket s) throws IOException
    {
        System.out.println("Accept from client " + s.getInetAddress());
        // The conversation would be here.
        s.close();
    }
}
