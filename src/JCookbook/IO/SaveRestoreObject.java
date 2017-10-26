package JCookbook.IO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveRestoreObject
{
    public static void main(String[] args)
    {
        List<MyData> lmd = new ArrayList<>();
        lmd.add(new MyData("Ian Darwin", "secret_java_cook"));
        lmd.add(new MyData("Abby Brant", "dujordian"));
        try
        {
            /*
            ObjectOutputStream objw = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/JCookbook/IO/objdata.dat")));
            objw.writeObject(lmd);
            objw.flush();
            objw.close();
            */

            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("src/JCookbook/IO/objdata.dat"));
            System.out.println(is.readObject());
            is.close();

        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        catch (ClassNotFoundException ee)
        {
            System.out.println(ee);
        }



    }
}

class MyData implements Serializable
{

    private static final long serialVersionUID = -4965296908339881739L;
    String userName;
    String passwordCypher;
    transient String passwordClear;

    /** This constructor is required by most APIs  */
    public MyData() {
        // Nothing to do
    }

    public MyData(String name, String clear) {
        setUserName(name);
        setPassword(clear);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String s) {
        this.userName = s;
    }

    public String getPasswordCypher() {
        return passwordCypher;
    }

    /** Save the clear text p/w in the object, it won't get serialized
     * So we must save the encryption! Encryption not shown here.
     */
    public void setPassword(String s) {
        this.passwordClear = s;
        passwordCypher = encrypt(passwordClear);
    }

    public String toString() {
        return "MyData[" + userName + ",------]";
    }
// END main

    /** In real life this would use Java Cryptography */
    protected String encrypt(String s) {
        return "fjslkjlqj2TOP+SECRETkjlskl";
    }
}
