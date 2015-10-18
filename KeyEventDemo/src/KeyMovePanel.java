//**********************************************************************************
//  KeyMovePanel.java
//  This program displays a user-input character. The user can move the character up,
//  down, left and right by using the arrow keys VK_UP, VK_DOWN, VK_LEFT and VK_RIGHT
//  See KeyEventDemo.java
//***********************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class KeyMovePanel extends JPanel
{
   //initial character is 'A' and location at (80, 80)
   private char keyChar = 'A';
   private int x = 80;		//x-coordinate
   private int y = 80;		//y-coordinate

   //Step 1: Constructor, set up the panel
   public KeyMovePanel()
   {
      //Step 3: register the panel with the listener object that listen to the key event
      addKeyListener (new CharListener());

      //Only a focused component can receive keyEvent, to make a componet focusable,
      //set its isFocusable property to true (see below)
      this.setFocusable(true);
   }

     //  Draws all of the dots stored in the list.
     //  Override the paintComponent() method in JComponent class
     public void paintComponent (Graphics page)
     {
         // use paintComponent method of its parent class
         // to have all graphics properties
         super.paintComponent(page);

         //set the font
         page.setFont(new Font("TimesRoman", Font.PLAIN, 24));
         page.drawString (String.valueOf(keyChar), x, y);

      } //end of paintComponent method

     //Step 2:  CharListener class represents the listener for key events.
     //         it implements KeyListerner interface
     private class CharListener implements KeyListener
      {

         public void keyPressed (KeyEvent event)
         {
            //check which key the user pressed and move the character accordingly
            switch(event.getKeyCode())
            {
				case KeyEvent.VK_UP:		y -= 20;
											break;
				case KeyEvent.VK_DOWN:		y += 20;
											break;
				case KeyEvent.VK_LEFT:		x -= 20;
											break;
				case KeyEvent.VK_RIGHT:		x += 20;
											break;
				//use press other keys
				default:					keyChar = event.getKeyChar();
											break;
	 		}

            repaint();  // this calls paintComponent method indirectly
         }

         //You will need to provide empty definitions for unused event methods.
         public void keyReleased (KeyEvent event) {}
         public void keyTyped (KeyEvent event) {}

      } // end of CharListener class
   }