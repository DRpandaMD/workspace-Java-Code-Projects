// Assignment #: 7
//         Name: Michael Zarate
//    StudentID: 1207882984
//      Lecture:  MWF 09000
//  Description: The entire panel creates components of this applet. It also has a definition for
// the CanvasPanel,  and listener classes.

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.util.ArrayList;

public class EntirePanel extends JPanel
{
	//Decleration of all the used Variables
	private int y;
	private int x;
	
   private DrawingPanel drawing;
   private JButton undo;
   private ArrayList<Letter> charList;
   private JRadioButton[] colorRButtons;
   //private Color[] colors;
   private int fontSize;
   private JComboBox fontSizeSelector;
   

   
   //added decelerations
   private JPanel optionsPanel;
   //private JPanel drawingPanel;
   private JPanel radioButtonsPanel;
   
   private Color currentColor;
   
   //These were not needed
   //color button of the Radio types
//   private JRadioButton jRadioButtonBlack;
//   private JRadioButton jRadioButtonRed;
//   private JRadioButton jRadioButtonBlue;
//   private JRadioButton jRadioButtonGreen;
//   private JRadioButton jRadioButtonOrange;
   //add instance variables as needed
   
   
   
  //moved these out side to make them global
   private Color[] colors= { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

   //The constructor initializes components and arrange them.
   public EntirePanel()
   { //fill out the code here
	   
	   //step one set up the layout and initialize the instance variables
	   
	   //setting up all the arrays 
	   charList = new ArrayList<Letter>();
	   
	   //array for the colors
	  // Color[] colors= { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
	   
	   //removed this from design
	   // initialize the buttons
//	   jRadioButtonBlack = new JRadioButton("black", true);
//	   jRadioButtonRed = new JRadioButton("red");
//	   jRadioButtonBlue = new JRadioButton("blue");
//	   jRadioButtonGreen = new JRadioButton("green");
//	   jRadioButtonOrange = new JRadioButton("Orange");
//	   
	   //add an array for the JRadio buttons
	   colorRButtons = new JRadioButton[5];
	   colorRButtons[0] = new JRadioButton("Black", true);
	   colorRButtons[1] = new JRadioButton("Red");
	   colorRButtons[2] = new JRadioButton("Blue");
	   colorRButtons[3] = new JRadioButton("Green");
	   colorRButtons[4] = new JRadioButton("Orange");
	   
	   //add the undo button
	   
	   JButton undo = new JButton("Undo");
	   //then we utilize the Button Group class so that you can only select
	   //1 button out of the group of buttons
	   ButtonGroup buttonSelection = new ButtonGroup();
	   
	   //add the button part panel
	   radioButtonsPanel = new JPanel();
	   
	   //adding the individual button objects to the panel
	   for(int i = 0; i < 5; i ++)
	   {
		   buttonSelection.add(colorRButtons[i]);
		   radioButtonsPanel.add(colorRButtons[i]);
		   
		   //part of the step 3 to add the listener in the loop for each radio button
		   colorRButtons[i].addActionListener(new ColorListener());
	   }
	   
	   
	   //WORKING
	   //here we set up the font size section
	   String[] fontSizeChoices = {"20", "24", "28", "32", "34", "36", "38", "40"};
	   fontSizeSelector = new JComboBox(fontSizeChoices); //there is a warning but this works
	   fontSizeSelector.setSelectedIndex(0);
	   fontSize = 24;
	   
	   
	    
	   
	   //setting up the panels
	   optionsPanel = new JPanel();
	   optionsPanel.add(undo);
	   optionsPanel.add(fontSizeSelector);
	   optionsPanel.add(radioButtonsPanel);
	   
	   drawing = new DrawingPanel();
	   //drawingPanel = new JPanel();
	   //setting up the panels to get all nice and organized on the display pane
	   JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, optionsPanel, drawing);
	   
	   this.setLayout(new BorderLayout());
	   
	   this.add(jSplitPane);
	   //step 3 adding the listner parts
	   undo.addActionListener(new ButtonListener());
	   fontSizeSelector.addActionListener(new FontListener());
	   
	   
	   
	   

   }

   //Accessors method of drawing panel
   public DrawingPanel getDrawingPanel()
   {
      return drawing;
   }

   // listener class for "undo" button.
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
       		 //Object source = event.getSource();

      		 //if (event.getSource() == undo)  //in case "undo" button is pushed  //this was not need (thanks to Mohammad!)
      		 {
      		     if(charList.size() >= 1)
      		     {
      		    	 charList.remove(charList.size()-1);
      		    	 drawing.repaint();
      		     }
              }

      }
   } // end of ButtonListener


    // listener class to set the color chosen by a user using
    // the radio buttons.
    private class ColorListener implements ActionListener
     {
        public void actionPerformed(ActionEvent event)
         {    
        	for(int i = 0; i < 5; i++)
 	          {
 	        	  if(event.getSource() == colorRButtons[i])
 	        		  currentColor = colors[i];
 	          }
         }
    }

 	private class FontListener implements ActionListener
 	{
 	     public void actionPerformed(ActionEvent event)
 	      {
 	          JComboBox fontBox = (JComboBox) event.getSource();
 	          String fontsize = (String) fontBox.getSelectedItem();
 	          fontSize = Integer.parseInt(fontsize);
 	      }
 	 } //end of FontListener

 	 class DrawingPanel extends JPanel
 	//DrawingPanel is the panel where pressed keys will be drawn  private class DrawingPanel extends JPanel
 	 {
 	    private Point currentPoint;
 	    private char keyChar = 'A'; // Default key

 	    //constructor to request focus to listen to keys, set background to white,
 	    //make the panel listen to keys and a mouse
 	    public DrawingPanel()
 	    {
 	        requestFocus();
        	setBackground(Color.white);
        	this.addKeyListener(new LetterListener());
        	this.addMouseListener(new PointListener());
      	}

     	//this method draws all characters pressed by a user so far
     	public void paintComponent(Graphics page)
     	{
       		super.paintComponent(page);
       		
       		for(int i = 0; i < charList.size(); i++)
       		{
       			if(charList.get(i) != null)
       			{
       				charList.get(i).draw(page);
       			}
       		}
       		
      	}

     	/** This method is overriden to enable keyboard focus */
     	public boolean isFocusable()
     	{
     	    return true;
     	}

   		// listener class to listen to keyboard keys
   		private class LetterListener implements KeyListener
   		{
   		   public void keyReleased(KeyEvent e) {}
   		   public void keyTyped(KeyEvent e) {}

   		   // in case that a key is pressed, the following will be executed.
   		   public void keyPressed(KeyEvent e)
   		   {
   			keyChar = e.getKeyChar();
        		Letter addLetter = new Letter(x, y, keyChar , currentColor, fontSize);
        		charList.add(addLetter);
        		drawing.repaint();


       		}
    	} // end of LetterListener


   		// listener class that listens to the mouse
   		public class PointListener implements MouseListener
   		{
   			  //in case that a user presses using a mouse,
   			  //record the point where it was pressed.
   			  public void mousePressed (MouseEvent event)
   			  {
   			     currentPoint = event.getPoint();
   			     x = event.getPoint().x;
   			     y = event.getPoint().y;
   			     requestFocus();
   			  }

     		public void mouseClicked (MouseEvent event) {}
     		public void mouseReleased (MouseEvent event) {}
     		public void mouseEntered (MouseEvent event) {}
     		public void mouseExited (MouseEvent event) {}
     		public void mouseMoved(MouseEvent event) {}
     		public void mouseDragged(MouseEvent event) {}

    	}// end of PointListener

  	} // end of DrawingPanel Class

} // end of EntirePanel Class