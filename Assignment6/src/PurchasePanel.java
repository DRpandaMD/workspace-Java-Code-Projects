// Assignment #: 6
//         Name: Michael
//    StudentID: Zarate
//      Lecture: MWF 0900
//  Lab Section: A
//  Description: it needs to be filled

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;
import java.util.*;



public class PurchasePanel extends JPanel {
	
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
	//Declaring objects panels and lists
	private ArrayList<Computer> compList;
	private JPanel checkBoxPanel;
	private JPanel totalPanel;
	private JTextArea PurchaseTextArea;
	private JLabel totalPurchaseMesage;
	private double totalAmt;
	private JCheckBox[] checkBoxArray;
	private CheckBoxListener boxListener = new CheckBoxListener();

	   public PurchasePanel(ArrayList<Computer> compList)
	    {
		  this.compList = compList;
		  this.setLayout(new BorderLayout());
		  
		  
		  //make a check box array....an array of check boxes
		  checkBoxArray = new JCheckBox[compList.size()];
		  
		  //make check box for each computer
		  checkBoxPanel = new JPanel();
		  
		  
		  ///*** COMENTED OUT REPLACED WITH METHOD****///
//		  for(int i = 0; i < compList.size(); i++){
//			  
//			  checkBoxArray[i] = new JCheckBox(compList.get(i).toString());
//			  checkBoxPanel.add(checkBoxArray[i]);
//		  }
		 
		  
		  ///The Purchase Panel side
		  updateCheckBoxList(compList);
		  
		  //add and set up the layouts for the panels
		  totalPanel = new JPanel(new BorderLayout());
		  totalPurchaseMesage = new JLabel("Current Total Puchase", SwingConstants.CENTER);
		  PurchaseTextArea = new JTextArea(currencyFormat.format(totalAmt));
		  PurchaseTextArea.setEditable(false);
		  totalPanel.add(totalPurchaseMesage, BorderLayout.NORTH);
		  totalPanel.add(PurchaseTextArea, BorderLayout.CENTER);
		    
		  //adding the sub panels to the main border layout panels
		  checkBoxPanel.setLayout(new BoxLayout( checkBoxPanel, BoxLayout.Y_AXIS));
		  this.add(checkBoxPanel, BorderLayout.WEST);
		  this.add(totalPanel, BorderLayout.EAST);
		   
	
		  //Step # 3 Register the JCheckBox object with the listener
		  //not really sure if this is needed. 
		  //i end up making a loop for each check box to have its own listener anyway.
		  CheckBoxListener listener = new CheckBoxListener();
		  for (int i = 0; i < checkBoxArray.length; i++)
		  {
			  checkBoxArray[i].addItemListener(listener);
		  }
		  
	    }
	   
	   //****NEW SEGMENT****
	   //making a method to update the checkbox list UI 
	   //this segment is crucial with out it the checkboxes wont work.
		  public void updateCheckBoxList(ArrayList<Computer> newCompList)
		  {
			checkBoxPanel.removeAll();
			checkBoxArray = new JCheckBox[newCompList.size()];
			for(int i = 0; i < newCompList.size(); i ++)
			{
				
				checkBoxArray[i] = new JCheckBox(newCompList.get(i).toString());
				checkBoxArray[i].addItemListener(boxListener);
				checkBoxPanel.add(checkBoxArray[i]);
				
			}
			  
		  }

	    
		  //sets up the check box listener
		  //and the total price sum 
	 private class CheckBoxListener implements ItemListener
	  {
		   public void itemStateChanged(ItemEvent event)
		    {
				// compute the total purchase amount when a check box is
				// checked or unchecked.
			   
			   for(int i = 0; i < checkBoxArray.length; i++)
			   {
				   
				   if(checkBoxArray[i].isSelected())
				   {
					   
					   totalAmt += compList.get(i).getPrice();
				   }
					   
			   }
			    //update the label
			   PurchaseTextArea.setText(currencyFormat.format(totalAmt));
			   // gives the check box of unchecked to give the total amount a 0
			   //that way unchecking gives the subtraction of the 
			   totalAmt = 0;
			}
	  }

}
