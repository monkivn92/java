package testPkg;

// Create a second thread.
public class threadTest  implements Runnable
{
    Thread t;
    String name;

    threadTest(String name_thread)
    {
        // Create a new, second thread
        name = name_thread;
        t = new Thread(this, name);
        System.out.println("Child thread: " + t);
        t.start(); // Start the thread
    }
    // This is the entry point for the second thread.
    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println( name + " : " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting " + name);
    }
}

// Create a second thread by extending Thread
class ExtendedThread extends Thread
{
    ExtendedThread()
    {

        // Create a new, second thread
        super("Demo Extended Thread");
        System.out.println("Child thread: " + this);
        start(); // Start the thread
    }

    // This is the entry point for the second thread.
    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println("Child Thread: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

/////////////////////// This program is not synchronized.
class Callme
{
    void call(String msg)
    {
        System.out.print("[" + msg);

        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable
{
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s)
    {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        synchronized(target)
        {
            target.call(msg);
        }

    }
}


/////////////////// An incorrect implementation of a producer and consumer.
class Q
{
    int n;
    boolean valueSet = false;

    synchronized int get()
    {
        while(!valueSet)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException caught");
            }
        }

        System.out.println("Got: " + n);

        valueSet = false;

        notify();

        return n;

    }
    synchronized void put(int n)
    {
        while(valueSet)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();

    }
}

class Producer implements Runnable
{
    Q q;
    Producer(Q q)
    {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run()
    {
        int i = 0;
        while(true)
        {
            q.put(i++);
        }
    }
}


class Consumer implements Runnable
{
    Q q;
    Consumer(Q q)
    {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run()
    {
        while(true)
        {
            q.get();
        }
    }
}


////// An example of deadlock.
class DLA
{
    synchronized void foo(DLB b)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println("A Interrupted");

        }

        System.out.println(name + " trying to call B.last()");
        b.last();
    }
    synchronized void last()
    {
        System.out.println("Inside A.last");
    }
}
class DLB
{
    synchronized void bar(DLA a)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println("B Interrupted");
        }
        System.out.println(name + " trying to call A.last()");
        a.last();
    }
    synchronized void last()
    {
        System.out.println("Inside A.last");
    }
}

/////// Suspending and resuming a thread the modern way.
class threadFlag implements Runnable
{
    String name; // name of thread
    Thread t;
    boolean suspendFlag;

    threadFlag(String threadname)
    {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start(); // Start the thread
    }

    //// This is the entry point for thread.
    public void run()
    {
        try
        {
            for(int i = 15; i > 0; i--)
            {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized(this) {
                    while(suspendFlag)
                    {
                        wait();
                    }
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }
    synchronized void mysuspend()
    {
        suspendFlag = true;
    }
    synchronized void myresume()
    {
        suspendFlag = false;
        notify();
    }
}


