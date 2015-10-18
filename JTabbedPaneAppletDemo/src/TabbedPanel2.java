
//See JTabbedPaneAppletDemo.java

import java.awt.*;
import javax.swing.*;

public class TabbedPanel2 extends JPanel
{
	//components in TabbedPanel2
   private JTextField textField1, textField2;
   private JLabel label1, label2, message;
   private JPanel leftPanel, rightPanel;
   private JButton button;
   private JPanel subPanel1, subPanel2;
   private JTextArea area;

   private JScrollPane scrollPane;

 //Constructor initializes components and organize them using certain layouts
 public TabbedPanel2()
  {
    //TabbedPanel2 will be divided as left and right half, the left pare is called leftPanel, the
    //right part contains a text area with the scroll pane

    this.setLayout(new GridLayout(1,2));

    //set up the leftPanel. leftPanel contains a message, subPanel1 and subPanel2
    leftPanel = new JPanel(new GridLayout(3, 1));

    message = new JLabel("Message Showing Here");
    message.setForeground(Color.blue);

    //set up subPanel1. subPanel1 contains two JLabel (label1 & label2) and
    //two JTextField (textField1 & textField2)
    subPanel1 = new JPanel(new GridLayout(2,2));
    label1 = new JLabel("Label #1");
    label2 = new JLabel("Label #2");
    textField1 = new JTextField("Text Field 1");
    textField2 = new JTextField("Text Field 2");

    //add label1, label2, textField1 & textField2 to subPanel1. Note the order.
    subPanel1.add(label1);
    subPanel1.add(textField1);
    subPanel1.add(label2);
    subPanel1.add(textField2);

    //set up subPanel2. subPanel2 contains only one button, by default it is flowLayout
    subPanel2 = new JPanel();
    button = new JButton("A Button");
    subPanel2.add(button);

    //add message, subPanel1 & subPanel2 to leftPanel
    leftPanel.add(message);
    leftPanel.add(subPanel1);
    leftPanel.add(subPanel2);

    //set up the right part, it contains a JTextArea only

    area = new JTextArea("put the origial text here");

    //area.setEditable(false);

    //in case there are more text showing than the height of the text area, a scroll
    //will be added to the text area.

    scrollPane = new JScrollPane(area);

    //add leftPanel and scrollPane to TabbedPanel2
    this.add(leftPanel);
    this.add(scrollPane);
    }
  }