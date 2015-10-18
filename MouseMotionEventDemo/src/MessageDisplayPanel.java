//  MessageDisplayPanel.java
//  Represents the primary panel to display a message. The message will be moved when
//  you drag the mouse
//  See MouseMotionEventDemo.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MessageDisplayPanel extends JPanel
{
   private JLabel message;
   Point location;

   //Step 1: Constructor, set up the panel
   public MessageDisplayPanel()
   {
     message = new JLabel("Java GUI Programming is fun!");

      //set the initial location
     location = new Point(20, 20);

      //Step 3: register the panel with the listener object
      addMouseMotionListener (new MessageMoveListener());

   }

     //  Repaint the message at the new location
     public void paintComponent (Graphics page)
     {
         // use paintComponent method of its parent class
         // to have all graphics properties
         super.paintComponent(page);

		 //change the page color and font
         page.setColor(Color.cyan);
		 page.setFont(new Font("TimesRoman", Font.PLAIN, 24));

         page.drawString(message.getText(), (int)(location.getX()), (int)(location.getY()));
      }

     //Step 2: Writing a class to implement the MouseMotion Listerner interface
     private class MessageMoveListener implements MouseMotionListener
      {
         //
         public void mouseDragged (MouseEvent event)
         {
            //getPoint() returns a Point object containing the x & y-coordinates
            location = event.getPoint();
            repaint();  // this calls paintComponent method indirectly
         }

       //You will need to provide empty definitions for unused event methods.
         public void mouseMoved (MouseEvent event) {}

      }
   }