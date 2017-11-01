package JCookbook.Collection;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import java.util.regex.*;
import java.nio.*;
import java.io.*;
public class RegexUTF8
{
    public static void main(String[] args)
    {
        String file_path = "src/JCookbook/a.txt";
        FileChannel fc;

        try
        {
             fc = new FileInputStream(file_path).getChannel();
             ByteBuffer bf = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
             CharBuffer chbf = Charset.forName("UTF-8").newDecoder().decode(bf);
             Pattern pat = Pattern.compile("v\\p{L}*?ng", Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE );
             Matcher mat  = pat.matcher(chbf);
            /*
            \p{L} matches a single code point in the category "letter".
            \p{N} matches any kind of numeric character in any script.
            */
            while (mat.find())
            {
                System.out.println(mat.group(0));
            }
        }
        catch ( IOException e2)
        {
            System.out.println(e2);
        }

        /////////////////////////////////////////
        //String pattStr = "\u00e9gal"; // egal
        String pattStr = "v\\u01B0\\u1EE3ng"; // egal
        /*String[] input = {
                "\u00e9gal", // egal - this one had better match :-)
                "e\u0301gal", // e + "Combining acute accent"
                "e\u02cagal", // e + "modifier letter acute accent"
                "e'gal", // e + single quote
                "e\u00b4gal", // e + Latin-1 "acute"
        }; */

        String[] input = {
                "vuong",
                "vượng"
        };

        Pattern pattern = Pattern.compile(pattStr, Pattern.CANON_EQ);

        for (int i = 0; i < input.length; i++)
        {
            if (pattern.matcher(input[i]).matches())
            {
                System.out.println(pattStr + " matches input " + input[i]);
            }
            else
            {
                System.out.println(pattStr + " does not match input " + input[i]);
            }
        }

    }
}
