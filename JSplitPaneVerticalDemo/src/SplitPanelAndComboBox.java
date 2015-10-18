// SplitPanelAndComboBox.java
// SplitPanel is a JSplitPane object, the upper part contain a Color combo box, where the lower part
// is the canvas where a fixed size circle with differenct colors can be drawn
// see JSplitPaneVerticalDemo.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SplitPanelAndComboBox extends JPanel
{
   private JLabel instruction;
   private ArrayList<Dot> dotList;
   private JComboBox colorBox;
   private JPanel upperPanel, lowerPanel;
   private Point currentPoint;
   private Color currentColor;

   //constructor
   public SplitPanelAndComboBox()
   {
	   //Step 1: set up the layout & initialize all instance varibles
	   dotList = new ArrayList<Dot>();
	   //currentPoint = new Point(20, 20);
	   instruction = new JLabel("pick a color and I will draw a dot of that color");

	   //create the color combo box
	   String[] colorChoices = {"black", "red", "blue", "yellow"};
	   colorBox = new JComboBox(colorChoices);

	   //set default color to be black, i.e. select item at index 0. Note:indices start at 0.
	   colorBox.setSelectedIndex(0);

	   //will set the current color to be the one selected from the color combo box
	   currentColor = Color.black;

	   //the split pane will be divided as the upper & lower panel
	   upperPanel = new JPanel();
	   lowerPanel = new CanvasPanel();  //see below for inner class CanvasPanel definition

	   //set layout for upperPanel, the lowerPanel will use the default layout - flow layout
	  upperPanel.setLayout(new GridLayout(2,1));

	  //add "instruction" and the combo box in upper panel
	  upperPanel.add(instruction);
	  upperPanel.add(colorBox);

	   // Create a split pane to hold the upperPanel & lowerPanel
       JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, lowerPanel);

       //This line set the layout for the current panel - SplitPanelAndComboBox panel
       //without this line, the SplitPanel will be shown as very small.
       this.setLayout(new BorderLayout());

       //add the splitted panes to the current panel - SplitPanelAndComboBox panel
       this.add(jSplitPane);

       //Step 3: Register listeners
       //register the color combo box with its listener
       colorBox.addActionListener(new ColorListener());

       lowerPanel.addMouseListener(new PointListener());
   }

   //CanvasPanel is the lower panel. Anytime the user click at a point
   //it will draw a circle with the selected color there (fix size with radius 20), see Dot.java
    private class CanvasPanel extends JPanel
    {

		public void paintComponent(Graphics page)
		{
      	   // use paintComponent method of its parent class
      	   // to have all graphics properties
      	   super.paintComponent(page);

      	   //traverse the dotList to paint each dot on screen one by one
		   for (int i=0; i < dotList.size();i++)
		   {
		      if (dotList.get(i) != null)
		      {
		   		   Dot newDot = (Dot) dotList.get(i);
		   	       newDot.draw(page);
		      }
   	       }

		 }
   	} //end of CanvasPanel class


   		//Step #2: design the listener's classes
	   	//PointListener check where the mouse is clicked
	   	 public class PointListener implements MouseListener
	   	 {
			 //in case that a user presses using a mouse,
			 //record the point where it was pressed.
		     public void mousePressed (MouseEvent event)
		     {
				//getPoint() returns a Point object containing the x & y-coordinates
				currentPoint= (Point) event.getPoint();
				int x = event.getPoint().x;
				int y = event.getPoint().y;

				//create a new Dot object and save it inside the dotList
				Dot newDot = new Dot(currentColor, x, y);
				dotList.add(newDot);

				repaint();  // this calls paintComponent method indirectly
		     }

		     public void mouseClicked (MouseEvent event) {}
			 public void mouseReleased (MouseEvent event) {}
			 public void mouseEntered (MouseEvent event) {}
	         public void mouseExited (MouseEvent event) {}
   		 }


    //ColorListener check which color is selected from the color combo box and set the
    //the currentColor to be that color.
    private class ColorListener implements ActionListener
    {
   		public void actionPerformed(ActionEvent event)
   		{
			JComboBox cb = (JComboBox) event.getSource();
			String colorName = (String) cb.getSelectedItem();
			if (colorName.equalsIgnoreCase("black"))
				currentColor = Color.black;
			else if (colorName.equalsIgnoreCase("red"))
					currentColor = Color.red;
				 else if (colorName.equalsIgnoreCase("blue"))
				 		currentColor = Color.blue;
				 	  else
				 	  	currentColor = Color.yellow;
         }
     }

}