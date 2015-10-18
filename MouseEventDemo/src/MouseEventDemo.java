//*******************************************
//  Dots1.java          Lewis/Loftus
//  Demonstrates mouse events and drawing on a panel.
//  See also DotsPanel1.java
//*******************************************

import javax.swing.JApplet;

public class MouseEventDemo extends JApplet
{
   public void init()
   {
      getContentPane().add (new DotsPanel1());
      setSize(300,200);
   }
}