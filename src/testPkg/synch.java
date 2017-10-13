package testPkg;

class synch
{
    public static void main(String args[])
    {

        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}

/*
public class synch
{
    public static void main(String[] args)
    {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");

        // wait for threads to end
        try
        {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }
}
*/

