package testPkg;

//import testPkg.DynStack;

public class test
{
    public static void main(String args[])
    {

        int x =1, y=3;
        int r = (x^y)&0xff;
        int g = (x*2^y*2)&0xff;
        int b = (x*4^y*4)&0xff;
        System.out.println(Integer.toBinaryString((255 << 24) | (r << 16) | (g << 8) | b));
        System.out.println((255 << 24) | (r << 16) | (g << 8) | b);
        System.out.println(5 | (r << 16) | (g << 8) | b);
    }
}
