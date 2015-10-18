
//**********************************************************************************
//  KeyEventDemo.java
//  This program displays a user-input character. The user can move the character up,
//  down, left and right by using the arrow keys VK_UP, VK_DOWN, VK_LEFT and VK_RIGHT
//  See also KeyChangePanel.java
//***********************************************************************************

import javax.swing.JApplet;

public class KeyEventDemo extends JApplet
{
   public void init()
   {
      getContentPane().add (new KeyMovePanel());
      setSize(300,200);
   }
}