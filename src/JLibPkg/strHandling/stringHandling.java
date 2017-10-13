package JLibPkg.strHandling;
import java.lang.*;
public class stringHandling
{
    public static void main(String[] args)
    {
        char ch[] = {'a','b','c'};
        String str1 = new String(ch,1 ,2);
        String str2 = new String(str1);

        byte bt[] = {69,70,71,72,73,74,75};

        String str3 = new String(bt);

        String str4 = "aaa" + 23456+30978956;
/*

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4.charAt(8));

        char[] char_arr = new char[6];
        str4.getChars(3,9,char_arr,0);
        System.out.println(char_arr);
        System.out.println(str1.equals(str2));
        System.out.println(str3.compareTo(str4));
        System.out.println(str4.substring(3,6));
        System.out.println(str4.concat(str1));
        System.out.println(str4.codePointAt(5));
        System.out.println(str4.replace('2', 'W'));
        System.out.println( String.valueOf(ch));
*/
        StringBuffer strbf = new StringBuffer("IODJKNHDLONIAS");
        System.out.println(strbf.length());
        System.out.println(strbf.capacity());

    }
}
