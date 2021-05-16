import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CustomPanel extends JPanel
{
   // The polygon being drawn.
   Polygon myPolygon = null;
   // The amount to change the x-axis each time.
   int myDeltaX = 0;
   // The amount to change the y-axis each time.
   int myDeltaY = 0;
   // The delay between updating the image.
   int myDelayTime = 500;

   public CustomPanel()
   {
     repaint();

     // The UFO being drawn on the panel.
     int x[] = { 10, 30, 40, 0, 110, 5 };
     int y[] = { 10, 110, 50, 40, 0, 10 };
     myPolygon = new Polygon(x, y, 6);

       // The action to perform over and over.
       ActionListener action = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
           CustomPanel.this.repaint();
           myDeltaX += 20;
           myDeltaY += 3;
        }
      };

      // Sets up the timer and connects the action from above.
      Timer t = new Timer(myDelayTime, action);
      t.setRepeats(true);
      t.setInitialDelay(0);
      t.start();
   }

  public void paintComponent(Graphics g)
  {
    // Cast to Graphics2D
    Graphics2D graphicsObj = (Graphics2D)g;

    // Clear the previous drawing on the panel.
    Rectangle bounds = graphicsObj.getClip().getBounds();
    graphicsObj. clearRect((int)bounds.getX(), (int)bounds.getY(),
      (int)bounds.getWidth(), (int)bounds.getHeight());

    // Move the polygon by some delta.
    myPolygon.translate(myDeltaX, myDeltaY);

    // Draw the polygon on the panel.
    graphicsObj.setColor(Color.green);
    graphicsObj.fill(myPolygon);
  }
}

