// Assignment #: 7
//         Name: Michael Zarate
//    StudentID: 1207882984
//      Lecture:  MWF 09000
//      Time spent: about 10-12 hours
//  Description: Assignment 7 combines the panel containing  a button, a slider, and radio buttons, and the drawing panel
//  using a JSplitPane.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Assignment7 extends JApplet
{
 	public void init()
 	 {
 	   // create an EntirePanel object and add it to the applet
 	   EntirePanel ePanel = new EntirePanel(); //had to fix this

 	   //JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ePanel, ePanel.getDrawingPanel()); //removed this

 	   getContentPane().add(ePanel); //added this

    //set applet size to 500 X 300
 	   setSize (500, 300);
 	 }

}