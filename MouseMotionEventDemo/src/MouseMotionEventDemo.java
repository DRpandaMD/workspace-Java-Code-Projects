//*******************************************
//  Demonstrates mouse motion events
//  See also MessageDisplayPanel.java
//*******************************************

import javax.swing.JApplet;

public class MouseMotionEventDemo extends JApplet
{
   public void init()
   {
      getContentPane().add (new MessageDisplayPanel());
      setSize(300,300);
   }
}