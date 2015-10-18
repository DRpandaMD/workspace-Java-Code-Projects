
// SplitPanel.java
// SplitPanel is a JSplitPane object, the left hand side contains 3 buttons, where the righthand side
// is the canvas where a fixed size circle with differenct colors can be drawn
// see JSplitPaneDemo.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplitPanel extends JPanel
{

   private JRadioButton jrbBlack, jrbRed, jrbBlue;
   private JPanel leftPanel, rightPanel;
   private Color currentColor;
   private int x, y;

   //constructor
   public SplitPanel()
   {
	   //Step 1: set up the layout and components properly

	   //initialize all instance varibles
	   jrbBlack = new JRadioButton("black", true); //set the "black" to be the default color
	   jrbRed = new JRadioButton("red");
	   jrbBlue = new JRadioButton("blue");
	   currentColor = Color.black;
	   x = y = 50;

	   //the split pane will be divided as the left & right panel
	   leftPanel = new JPanel();
	   rightPanel = new CanvasPanel();  //see below for CanvasPanel's definition

	   //set layout for leftPanel, the rightPanel will use the default layout - flow layout
	  leftPanel.setLayout(new GridLayout(5,1,8,8));

	   //ButtonGroup class is used to create a multiple-exclusion scope for a set of buttons.
	   //Creating a set of buttons with the same ButtonGroup object means that turning "on" one
	   //of the buttons turns off all other buttons in the same group.
	   ButtonGroup btg = new ButtonGroup();

	   //add the 3 radio buttons inside the group such that at any time only one button can be selected.
	   btg.add(jrbBlack);
	   btg.add(jrbRed);
       btg.add(jrbBlue);

	   //leftPanel contains the 3 radio buttons
	   leftPanel.add(jrbBlack);
	   leftPanel.add(jrbRed);
       leftPanel.add(jrbBlue);

       // Create two split panes to hold the leftPanel & rightPanel
       JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

       //set the layout for SplitPanel
       setLayout(new BorderLayout());

       //add the splitted panes to SplitPanel
       add(jSplitPane);

       //Step 3: Register listeners
       jrbBlack.addActionListener(new ColorListener());
	   jrbRed.addActionListener(new ColorListener());
       jrbBlue.addActionListener(new ColorListener());

       rightPanel.addMouseListener(new PointListener());
   }

   //CanvasPanel is the right-hand-side panel. Anytime the user click at a point
   //it will draw a circle with the selected color there (fix size with radius 25)
    private class CanvasPanel extends JPanel
    {
		//draws a circle
		public void paintComponent(Graphics page)
		{
      	   // use paintComponent method of its parent class
      	   // to have all graphics properties
      	   super.paintComponent(page);

      	   //set the color
   		   page.setColor(currentColor);
   		   page.fillOval(x-25, y-25, 50, 50);
   	     }

   	}

   	//Step 2: design the listener's classes
   	//PointListener check where the mouse is clicked
   	 public class PointListener implements MouseListener
   	 {
		 //in case that a user presses using a mouse,
		 //record the point where it was pressed.
	     public void mousePressed (MouseEvent event)
	     {
			//getPoint() returns a Point object containing the x & y-coordinates
			x = event.getPoint().x;
			y = event.getPoint().y;
			repaint();  // this calls paintComponent method indirectly
	     }

	     public void mouseClicked (MouseEvent event) {}
		 public void mouseReleased (MouseEvent event) {}
		 public void mouseEntered (MouseEvent event) {}
         public void mouseExited (MouseEvent event) {}
    }

    //ColorListener check which radio button is picked
    private class ColorListener implements ActionListener
    {
   		public void actionPerformed(ActionEvent event)
   		{
			if (event.getSource() == jrbBlack)
                currentColor = Color.black;
            else if (event.getSource() == jrbRed)
                currentColor = Color.red;
            else if (event.getSource() == jrbBlue)
                currentColor = Color.blue;
         }
     }

}

