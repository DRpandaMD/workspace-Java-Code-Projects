// JSplitPaneVerticalDemo.java
// This program demonstrates the use of JSplitPanel and JComboBox class
// see SplitPanelAndComboBox.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitPaneVerticalDemo extends JApplet
{
	public void init()
	{
	      getContentPane().add (new SplitPanelAndComboBox());
	      setSize(300,300);
    }
}
