import javax.swing.*;
import java.awt.*;

public class Shapes extends JApplet{
	
	public void paint (Graphics page){
		
		setSize(400,400);
		
		//top right square
		page.setColor(Color.blue);
		page.fillRect(0, 0, 200, 200);
		
		//right arcs
		page.setColor(Color.red);
		page.fillArc(200, 0, 200, 200, 180, -90);
		
		page.setColor(Color.red);
		page.fillArc(200, 0, 200, 200, 0, -90);
		
		//bottomArcs
		page.setColor(Color.red);
		page.fillArc(0, 200, 200, 200, 180, 90);
		
		page.setColor(Color.red);
		page.fillArc(0, 200, 200, 200, 0, 90);
		
		//the rest of the squares
		
		page.setColor(Color.blue);
		page.fillRect(200, 200, 100, 100);
		
		page.setColor(Color.blue);
		page.fillRect(300, 300, 50, 50);
		
		page.setColor(Color.blue);
		page.fillRect(350, 350, 25, 25);
		
		page.setColor(Color.blue);
		page.fillRect(375, 375, 25, 25);
		
		
	}

}
