
//This class define a Dot, a "Dot" will have fixed radius 20 and its color
//and location (x, y coordinates) can be changed.
//see also SplitPanelAndRadioButton.java & JSplitPanelHorizontalDemo.java


//This package needs to be imported in order to use the Graphics class
import java.awt.*;

public class Dot
{
   //The dot's radius is fixed
   private final int RADIUS = 20;
   private Color itsColor;
   private int x, y;	//the x and y coordinate of the dot

   //constructor
   public Dot (Color newColor, int newX, int newY)
   {
	   itsColor = newColor;
	   x = newX;
	   y = newY;
   }

   public void draw(Graphics page)
   {
	   page.setColor(itsColor);
	   page.fillOval(x-RADIUS, y-RADIUS, 2*RADIUS, 2*RADIUS);
   }

}