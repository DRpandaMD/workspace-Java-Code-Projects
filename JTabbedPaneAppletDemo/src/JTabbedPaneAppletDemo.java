
//A Java Applet showing how to use JTabbedPane
//see also TabbedPanel2.java for nested panels arrangement

import javax.swing.*;

public class JTabbedPaneAppletDemo extends JApplet
{
   public void init()
   {
      //create a JTabbedPane object. In this example, tp contains two tabs.
	  JTabbedPane tp = new JTabbedPane();

	  //set up tab #1 first, each tab is a panel, inside this panel, there's only a text label
	  JPanel panel1 = new JPanel();
	  JLabel label1 = new JLabel("Tab #1 Contents - simple text only");

	  //put the label inside the panel
	  panel1.add(label1);

	  //add panel1 to tab with the title "Tab 1"
	  tp.addTab("Tab 1", panel1);

	  //Similarily, set up tab2, but tab2 will be an object from TabbedPanel2
	  TabbedPanel2 panel2 = new TabbedPanel2();

	  //add panel2 to tab with the title "Tab 2"
	  tp.addTab("Tab 2", panel2);

	  //add JTabbedPane to this Applet
	  getContentPane().add(tp);
      setSize(300,300);
   }
}