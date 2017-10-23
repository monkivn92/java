package JCookbook;


import java.util.Date;
import java.util.Arrays;


public class ResizingArray
{
    public final static int INITIAL = 10,
            GROW_FACTOR = 2;
    public static void main(String[] argv)
    {
        int nDates = 0;
        Date[] dates = new Date[INITIAL];
        Date[] tmp = new Date[dates.length * GROW_FACTOR];

        System.arraycopy(dates, 0, tmp, 0, dates.length);
        /*Arrays.copyOf()*/
        System.out.print(tmp);

    }
}
