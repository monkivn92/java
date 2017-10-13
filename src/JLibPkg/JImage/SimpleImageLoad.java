package JLibPkg.JImage;

/*
 * <applet code="SimpleImageLoad" width=400 height=345>
 *  <param name="img" value="Lilies.jpg">
 * </applet>
 */
import java.awt.*;
import java.applet.*;

public class SimpleImageLoad extends Applet
{
    Image img;

    public void init() {
        img = getImage(getDocumentBase(), "../media/DataBackup/java/src/JLibPkg/JImage/"+getParameter("img"));
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }
}

