package JCookbook;

import java.util.StringTokenizer;

public class ConvertToCommaList
{
    public static  void main (String[] args)
    {
        String Sample = "aa kuo asr af nle";

        StringBuilder sb = new StringBuilder();//not synchronized and faster than StringBuffer
        for(String str : Sample.split(" "))
        {
            if(sb.length() > 0)
            {
                sb.append(',');
            }
            sb.append(str);
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
        StringTokenizer strtok = new StringTokenizer(Sample, " ", false);
        while(strtok.hasMoreElements())
        {
            sb.append(strtok.nextToken());
            if (strtok.hasMoreElements())
            {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());

    }
}
