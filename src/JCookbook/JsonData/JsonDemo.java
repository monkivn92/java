package JCookbook.JsonData;
import org.json.*;
import java.io.*;
public class JsonDemo
{
    public static void main(String[] args)
    {
        //loads resources using the same class loader, no needs src/JCookbook/JsonData/data.json
        InputStream jsonInput =
                JsonDemo.class.getResourceAsStream("data.json");

        if (jsonInput == null)
        {
            throw new NullPointerException("can't find" + "src/JCookbook/JsonData/data.json");
        }
        JSONObject obj = new JSONObject(new JSONTokener(jsonInput));

        System.out.println("Software Name: " + obj.getString("name"));

        System.out.println("Version: " + obj.getString("version"));

        System.out.println("Description: " + obj.getString("description"));

        System.out.println("Class: " + obj.getString("className"));

        JSONArray contribs = obj.getJSONArray("contributors");

        for (int i = 0; i < contribs.length(); i++)
        {
            System.out.println("Contributor Name: " + contribs.get(i));
        }

        //WRITE JSON OBJECT
        JSONObject jo = new JSONObject();
        char[] abc = {'a', 'b', 'c'};
        jo.put("name","test").put("version","1.0").put("data",abc);
        System.out.println(jo.toString());
    }
}
