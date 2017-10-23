package JCookbook;
import java.util.Enumeration;
public class EnumDemo
{
    public static void main(String[] unused)
    {
        Apple ap = Apple.Jonathan;
        jhelp.echoln(ap);

        // Use an enum to control a switch statement.
        switch(ap)
        {
            case Jonathan:
                System.out.println("Jonathan is red.");
                break;
            case GoldenDel:
                System.out.println("Golden Delicious is yellow.");
                break;
            case RedDel:
                System.out.println("Red Delicious is red.");
                break;
            case Winesap:
                System.out.println("Winesap is red.");
                break;
            case Cortland:
                System.out.println("Cortland is red.");
                break;
        }

        // use values()
        Apple allapples[] = Apple.values();
        for(Apple a : allapples)
            System.out.println(a);
        System.out.println();
        // use valueOf()
        ap = Apple.valueOf("Winesap");
        jhelp.echoln(ap);
        jhelp.echoln("#######################################3");
        for(Apple a : Apple.values())
            System.out.println(a + " costs " + a.getPrice() + " cents.");


    }
}
// An enumeration of apple varieties.
enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);
    private int price; // price of each apple
    // Constructor
    Apple(int p) { price = p; }
    int getPrice() { return price; }
}
