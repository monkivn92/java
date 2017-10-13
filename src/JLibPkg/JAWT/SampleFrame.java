package JLibPkg.JAWT;

//  Create a child frame window from within an applet.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
  <applet code="AppletFrame" width=300 height=50>
  </applet>
*/

// Create a subclass of Frame.
class FrameDemo extends Frame
{
    FrameDemo(String title)
    {
        super(title);

        // create an object to handle window events
        MyWindowAdapter adapter = new MyWindowAdapter(this);

        // register it to receive those events
        addWindowListener(adapter);
    }
    public void paint(Graphics g)
    {
        g.drawString("This is in frame window", 10, 40);
    }
}

class MyWindowAdapter extends WindowAdapter
{
    FrameDemo sampleFrame;

    public MyWindowAdapter(FrameDemo sampleFrame)
    {
        this.sampleFrame = sampleFrame;
    }
    public void windowClosing(WindowEvent we)
    {
        sampleFrame.setVisible(false);
    }
}

// Create frame window.
public class SampleFrame extends Applet
{
    Frame f;

    public void init()
    {
        f = new FrameDemo("A Frame Window");

        f.setSize(250, 250);
        f.setVisible(true);
    }

    public void start()
    {
        f.setVisible(true);
    }

    public void stop()
    {
        f.setVisible(false);
    }

    public void paint(Graphics g)
    {
        g.drawString("This is in applet window", 10, 20);
    }
}