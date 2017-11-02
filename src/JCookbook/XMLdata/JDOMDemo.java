package JCookbook.XMLdata;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMDemo
{
    public static void main(String[] args)
    {
        InputStream xmlfile = JDOMDemo.class.getResourceAsStream("data.xml");
        if(xmlfile == null)
        {
            throw new NullPointerException("can't find" + " data.xml");
        }

        ///
        SAXBuilder builder = new SAXBuilder();

        try
        {

            Document document =  builder.build(xmlfile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("staff");

            for (int i = 0; i < list.size(); i++)
            {

                Element node = (Element) list.get(i);

                System.out.println("First Name : " + node.getChildText("firstname"));
                System.out.println("Last Name : " + node.getChildText("lastname"));
                System.out.println("Nick Name : " + node.getChildText("nickname"));
                System.out.println("Salary : " + node.getChildText("salary"));

            }

        }
        catch (IOException io)
        {
            System.out.println(io.getMessage());
        }
        catch (JDOMException jdomex)
        {
            System.out.println(jdomex.getMessage());
        }

    }
}
