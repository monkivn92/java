package JCookbook.Collection;

public class BreakStringToCharsAndChecksum
{
    public static  void main (String[] args)
    {
        System.out.println(System.getProperty("line.separator").replace("\n", "\\n"));
        String Sample = "aa kuo asr af nle";
        int sum = 0;
        for(char ch: Sample.toCharArray())
        {
            sum += ch;
        }
        System.out.println(sum);
    }
}
