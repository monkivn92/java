package JCookbook.XMLdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ModifyXML
{
    public static void main(String[] args)
    {

        try
        {

            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File("/media/DataBackup/java/src/JCookbook/XMLdata/data2.xml");

            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();

            // update staff id attribute
            Element staff = rootNode.getChild("staff");
            staff.getAttribute("id").setValue("2");

            // add new age element
            Element age = new Element("age").setText("28");
            staff.addContent(age);

            // update salary value
            staff.getChild("salary").setText("7000");

            // remove firstname element
            staff.removeChild("firstname");

            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("/media/DataBackup/java/src/JCookbook/XMLdata/data2.xml"));

            // xmlOutput.output(doc, System.out);

            System.out.println("File updated!");
        } catch (IOException io) {
            io.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
    }
}
