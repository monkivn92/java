package JCookbook.Collection;

import java.text.ChoiceFormat;

public class PluralAndSingular
{

    public static void main(String[] argv)
    {
        // ChoiceFormat to just give pluralized word
        double[] limits = { 0, 1, 2 };
        String[] formats = { "reviews", "review", "reviews"};
        ChoiceFormat pluralizedFormat = new ChoiceFormat(limits, formats);
// ChoiceFormat to give English text version, quantified
        ChoiceFormat quantizedFormat = new ChoiceFormat("0#no reviews|1#one review|1<many reviews");
        // Test data
        int[] data = { -1, 0, 1, 2, 3 };

        System.out.println("Pluralized Format");
        for (int i : data)
            System.out.println("Found " + i + " " + pluralizedFormat.format(i));

        System.out.println("Quantized Format");
        for (int i : data)
        {
            System.out.println("Found " + quantizedFormat.format(i));
        }

    }
}
