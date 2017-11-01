package JCookbook.ServerSide;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ReturnResponse
{
    /** Our server-side rendezvous socket */
    protected ServerSocket sock;

    /** The port number to use by default */
    public final static int ECHOPORT = 9999;

    /** Flag to control debugging */
    protected boolean debug = true;


    /** main: construct and run */
    public static void main(String[] args)
    {
        int p = ECHOPORT;
        new ReturnResponse(p).handle();
    }

    /** Construct an EchoServer on the given port number */
    public ReturnResponse(int port)
    {
        try
        {
            sock = new ServerSocket(port);
        }
        catch (IOException e)
        {
            System.err.println("I/O error in setup");
            System.err.println(e);
            System.exit(1);
        }
    }

    /** This handles the connections */
    protected void handle()
    {
        Socket ios = null;
        BufferedReader is = null;
        PrintWriter os = null;
        while (true)
        {
            try
            {
                System.out.println("Waiting for client...");

                ios = sock.accept();

                System.err.println("Accepted from " +  ios.getInetAddress().getHostName());
                is = new BufferedReader(  new InputStreamReader(ios.getInputStream(), "8859_1"));
                os = new PrintWriter(
                        new OutputStreamWriter(
                                ios.getOutputStream(), "8859_1"), true);
                String echoLine;
                while ((echoLine = is.readLine()) != null)
                {
                    System.err.println("Read " + echoLine);
                    os.print(echoLine + "\r\n");
                    os.flush();
                    System.err.println("Wrote " + echoLine);
                }
                System.err.println("All done!");
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
            finally
            {
                try
                {
                    if (is != null)
                        is.close();
                    if (os != null)
                        os.close();
                    if (ios != null)
                        ios.close();
                }
                catch (IOException e)
                {
                    // These are unlikely, but might indicate that
                    // the other end shut down early, a disk filled up
                    // but wasn't detected until close, etc.
                    System.err.println("IO Error in close");
                }
            }
        }
		/*NOTREACHED*/
    }
}
