import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DotsPanel1 extends JPanel
{
   private final int RADIUS = 10;
   private ArrayList<Point> pointList;
   private int count;

   public DotsPanel1()
   {
      setBackground (Color.black);
      count = 0;
      pointList = new ArrayList<Point>();

      this.addMouseListener(new PointListener());

   }

     public void paintComponent (Graphics page)
     {
         super.paintComponent(page);

         page.setColor (Color.yellow);
         for (int i=0; i<pointList.size() ; i++)
         {
            Point drawPoint = pointList.get(i);
            page.fillOval (drawPoint.x - RADIUS, drawPoint.y - RADIUS,
                           RADIUS * 2, RADIUS * 2);
         }
         page.drawString ("Count: " + count, 5, 15);
      }


     private class PointListener implements MouseListener
      {
         public void mousePressed (MouseEvent event)
         {
            pointList.add (event.getPoint());
            count++;
            repaint();
         }

         public void mouseClicked (MouseEvent event){}
         public void mouseReleased (MouseEvent event) {}
         public void mouseEntered (MouseEvent event) {}
         public void mouseExited (MouseEvent event) {}
      }
   }