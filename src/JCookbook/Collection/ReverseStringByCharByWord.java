package JCookbook.Collection;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseStringByCharByWord
{
    public static void main(String[] args)
    {
        String str = "Omea wa shindeiru";
        System.out.println(str+"->"+ new StringBuilder(str).reverse());

        Stack<String> sstack = new Stack<String>();
        StringTokenizer tok = new StringTokenizer(str);
        while (tok.hasMoreTokens())
        {
            sstack.push(tok.nextToken());
        }

        while (!sstack.empty())
        {
            System.out.print(sstack.pop()+' ');
        }

    }
}
