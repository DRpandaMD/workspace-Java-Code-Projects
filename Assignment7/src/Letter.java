// Assignment #: 7
//         Name: Michael Zarate
//    StudentID: 1207882984
//      Lecture:  MWF 09000
//  Description: The Letter Panel to set up the letters to put on the drawing canvas


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Letter extends JPanel
{

	private int x;
	private int y;
	private Color color;
	private int fontSize;
	//private String textString;
	private char keyChar;
	
	
	
	public Letter(int x, int y, char keyChar, Color color, int fontSize)
	{
		this.x = x;
		this.y = y;
		this.keyChar = keyChar;
		this.color = color;
		this.fontSize = fontSize;
		
	}
	
	
	public void draw(Graphics page)
	{
		//Point currentPoint = new Point();
		//char keyChar ;
		
		page.setColor(color);
		page.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		page.drawString(String.valueOf(keyChar), x, y);
		
		
	}
}
