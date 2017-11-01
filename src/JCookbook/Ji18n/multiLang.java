package JCookbook.Ji18n;
import java.util.Locale;
import java.util.ResourceBundle;
public class multiLang
{
    public static void main(String[] args)
    {
        ResourceBundle rb = ResourceBundle.getBundle("JCookbook.Ji18n.i18n.aaa",
                                                        new Locale("vi"));
        System.out.println(rb.getString("card.myname"));
    }
}
