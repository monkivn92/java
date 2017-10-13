package JLibPkg.JNetwork;

// Demonstrate datagrams.
import java.net.*;

class WriteServer
{
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;

    public static DatagramSocket ds;

    public static byte buffer[] = new byte[buffer_size];

    public static void TheServer() throws Exception
    {
        int pos=0;

        while (true)
        {
            int c = System.in.read();

            switch (c)
            {
                case -1:
                    System.out.println("Server Quits.");

                    ds.close();
                    return;

                case '\r':
                    break;

                case '\n':
                    ds.send(new DatagramPacket(buffer,pos,  InetAddress.getLocalHost(),clientPort));
                    pos=0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }


    public static void TheClient() throws Exception
    {
        while(true)
        {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);

            ds.receive(p);

            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String args[]) throws Exception
    {
        if(args.length == 1)
        {
            ds = new DatagramSocket(serverPort);
            TheServer();
        }
        else
        {
            ds = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}

/*
This sample program is restricted by the DatagramSocket constructor to running between
two ports on the local machine. To use the program, run
java WriteServer
in one window; this will be the client. Then run
java WriteServer 1
This will be the server. Anything that is typed in the server window will be sent to the client
window after a newline is received.
NOTE: The use of datagrams may not be allowed on your computer. (For example, a firewall may prevent
their use.) If this is the case, the preceding example cannot be used. Also, the port numbers used in
the program work on the author's system, but may ve to be adjusted for your environment.

*/