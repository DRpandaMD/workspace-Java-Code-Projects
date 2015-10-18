// JSplitPaneDemo.java
// This program demonstrates the use of JSplitPanel and ButtonGroup class
// see SplitPanel.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitPaneDemo extends JApplet
{
	public void init()
	{
	      getContentPane().add (new SplitPanel());
	      setSize(300,300);
    }
}
