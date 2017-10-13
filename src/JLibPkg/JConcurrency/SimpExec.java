package JLibPkg.JConcurrency;

// A simple example that uses an Executor.

import java.util.concurrent.*;

class SimpExec {
    public static void main(String args[]) {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Starting");

        // Start the threads.
        es.execute(new My55Thread(cdl, "A"));
        es.execute(new My55Thread(cdl2, "B"));
        es.execute(new My55Thread(cdl3, "C"));
        es.execute(new My55Thread(cdl4, "D"));

        try {
            cdl.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        es.shutdown();
        System.out.println("Done");
    }
}

class My55Thread implements Runnable {
    String name;
    CountDownLatch latch;

    My55Thread(CountDownLatch c, String n) {
        latch = c;
        name = n;

        new Thread(this);
    }

    public void run()
    {

        for(int i = 0; i < 5; i++)
        {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
