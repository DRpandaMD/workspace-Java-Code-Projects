//This program demonstrates using panels as subcontainer


import javax.swing.*;
import java.awt.*;

public class NestedPanelDemo extends JApplet
 {
  public void init()
   {
    Container content = getContentPane();

    // create six buttons
    JButton button1 = new JButton("Button1");
    JButton button2 = new JButton("Button2");
    JButton button3 = new JButton("Button3");
    JButton button4 = new JButton("Button4");
    JButton button5 = new JButton("Button5");
    JButton button6 = new JButton("Button6");

    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(1,2));
    panel1.add(button1);
    panel1.add(button2);

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout());

    // add five buttons to panel2
    panel2.add(button3, BorderLayout.NORTH);
    panel2.add(button4, BorderLayout.SOUTH);
    panel2.add(button5, BorderLayout.WEST);
    panel2.add(button6, BorderLayout.EAST);
    panel2.add(panel1, BorderLayout.CENTER);

    content.add(panel2); // content pane contains panel2 that contains everything
    setSize(400,300);
  }
}