package JLibPkg.JIO;

// Demonstrate File.

import java.io.*;

import java.util.Calendar;


class FileFilterRule implements FilenameFilter
{

    public boolean accept(File dir, String filename)
    {
        return filename.endsWith(".txt");
    }
}

class FileObjFilterRule implements FileFilter
{

    public boolean accept(File f)
    {
        return f.getName().contains("Scanner");
    }
}

class FileDemo
{
    static void p(String s)
    {
        System.out.println(s);
    }



    public static void main(String args[])
    {
        /*
        final String dir = System.getProperty("user.dir");

        File f1 = new File("src/JLibPkg/JUtils/test.txt");
        p("File Name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");

        p(f1.canWrite() ? "is writeable" : "is not writeable");
        p(f1.canRead() ? "is readable" : "is not readable");
        p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        p(f1.isFile() ? "is normal file" : "might be a named pipe");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(f1.lastModified());
        p("File last modified: " + calendar.get(Calendar.YEAR)+':' + (calendar.get(Calendar.MONTH)+1)+':'+calendar.get(Calendar.DATE));
        p("File size: " + f1.length() + " Bytes");

        f1.renameTo(new File("src/JLibPkg/JUtils/test.txt"));
        */
        File f2 = new File("src/JLibPkg/JUtils/");
        //String[] f_list = f2.list();
        FilenameFilter rule = new FileFilterRule();
        FileFilter obj_rule = new FileObjFilterRule();


        String[] f_list = f2.list(rule);
        //File[] fobj_list = f2.listFiles(obj_rule);

        File[] fobj_list = f2.listFiles((File f)->{ return f.getName().contains("Scanner"); });

        for(String f_name:f_list)
            p(f_name);

        for(File fobj:fobj_list)
            p(fobj.getAbsolutePath());


    }
}