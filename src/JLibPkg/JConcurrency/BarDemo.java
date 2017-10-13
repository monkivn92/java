package JLibPkg.JConcurrency;

// An example of CyclicBarrier.

import java.util.concurrent.*;

class BarDemo
{
    public static void main(String args[])
    {
        CyclicBarrier cb = new CyclicBarrier(2, new BarAction() );

        System.out.println("Starting");

        new My2Thread(cb, "A");
        new My2Thread(cb, "B");
        new My2Thread(cb, "C");

        new My2Thread(cb, "X");
        new My2Thread(cb, "Y");
        new My2Thread(cb, "Z");

    }
}

// A thread of execution that uses a CyclicBarrier.
class My2Thread implements Runnable
{
    CyclicBarrier cbar;
    String name;

    My2Thread(CyclicBarrier c, String n)
    {
        cbar = c;
        name = n;
        new Thread(this).start();
    }

    public void run()
    {

        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException exc) {
            System.out.println(exc);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

// An object of this class is called when the
// CyclicBarrier ends.
class BarAction implements Runnable
{
    public void run()
    {
        System.out.println("Barrier Reached!");
    }
}

