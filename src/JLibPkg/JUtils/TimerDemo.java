package JLibPkg.JUtils;

// Demonstrate Timer and TimerTask.
import java.util.*;

class MyTimerTask extends TimerTask
{
    public void run()
    {
        System.out.println("Timer task executed.");
    }
}
class TimerDemo
{
    public static void main(String args[])
    {
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();

        /* Set an initial delay of 1 second, then repeat every half second.*/
        myTimer.schedule(myTask, 1000, 1000);
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException exc) {}

        myTimer.cancel();
    }
}