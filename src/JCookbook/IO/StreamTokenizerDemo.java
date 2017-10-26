package JCookbook.IO;

import java.io.*;
import JCookbook.jhelp;

public class StreamTokenizerDemo
{
    public static void main(String[] args)
    {
        try
        {
            StreamTokenizer strtok = new StreamTokenizer(new InputStreamReader(System.in));
            int type;
            while ( (type = strtok.nextToken()) !=  StreamTokenizer.TT_EOF)
            {
                switch (type)
                {
                    case StreamTokenizer.TT_NUMBER:
                        jhelp.echoln("Number "+strtok.nval);
                        break;
                    case StreamTokenizer.TT_WORD:
                        jhelp.echoln("Word "+strtok.sval);
                        break;
                }
            }
        }
        catch (Exception e)
        {
            jhelp.echoln("error "+e);
        }
    }
}
