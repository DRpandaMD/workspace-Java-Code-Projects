// Assignment #: 6
// Name: Michael Zarate	
// StudentID: 120-788-2984
// Lecture: 1
// Section: A
// Description: this class contains the GUI information for the "Store" Tab
// It is made to contain the fields and labels and an error message for entering the
// data for varying computer models, specs, and prices

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;

public class StorePanel extends JPanel
 {
	//component declaration
	private ArrayList<Computer> compList;
	private PurchasePanel purchasePanel;
	private JButton storeButton;
	private JPanel bottomButtonPanel;
	private JPanel middleLayerPanel;
	//private JPanel bottomBorderLayoutPanel;
	private JPanel LeftPanel;
	private JPanel RightPanel;
	private JPanel MessagePanel;
   
	//labels
	private JLabel BrandName;
	private JLabel Price;
	private JLabel Memory;
	private JLabel CPUtype;
	private JLabel CPUspeed;
	
	//scroll pane 
	
	private JScrollPane scrollPane;
	
	//text fields
	private JTextField BrandNameTextField;
	private JTextField PriceTextField;
	private JTextField MemoryTextField;
	private JTextField CPUtypeTextField;
	private JTextField CPUspeedTextField;
	
	//text area
	private JLabel EventMessage;
	private JList Computerlist;
	private JTextArea ComputerTextArea;
	//private JTextArea ComputerListArea;
	
	
 public StorePanel(ArrayList<Computer> compList, PurchasePanel pPanel)
  {
    this.compList = compList;
    this.purchasePanel = pPanel;
    
    
    //sets the main frame into two sections
    this.setLayout(new GridLayout(1,2));
    
    compList = new ArrayList<Computer>();
    
    //sets up the color of the the message
    MessagePanel = new JPanel();
    EventMessage = new JLabel("Running");
    EventMessage.setForeground(Color.RED);
	MessagePanel.add(EventMessage);
    
    //the top most layer
    
    storeButton = new JButton("Store");
    
    bottomButtonPanel = new JPanel();
    bottomButtonPanel.add(storeButton);
    
    //middle layer
    middleLayerPanel = new JPanel();
    middleLayerPanel.setLayout(new GridLayout(5,2));
    
    //setting up the fields and the labels
    
    BrandName = new JLabel("Brand Name");
    Price = new JLabel("Price");
    Memory = new JLabel("Memory");
    CPUtype = new JLabel("CPU Type");
    CPUspeed = new JLabel("CPU Speed");
	
	
	//text fields
	BrandNameTextField = new JTextField("");
	PriceTextField = new JTextField("");
	MemoryTextField = new JTextField("");
	CPUtypeTextField = new JTextField("");
	CPUspeedTextField = new JTextField("");
	
	//adding the components to the middle layer
	
	middleLayerPanel.add(BrandName);
	middleLayerPanel.add(BrandNameTextField);
	middleLayerPanel.add(Price);
	middleLayerPanel.add(PriceTextField);
	middleLayerPanel.add(Memory);
	middleLayerPanel.add(MemoryTextField);
	middleLayerPanel.add(CPUtype);
	middleLayerPanel.add(CPUtypeTextField);
	middleLayerPanel.add(CPUspeed);
	middleLayerPanel.add(CPUspeedTextField);
	
	
	
	//setting up the Left Panel
	LeftPanel = new JPanel();
	//LeftPanel.setLayout(new GridLayout(3,1));
	LeftPanel.setLayout(new BorderLayout());
	
	///setting up the left panel
	LeftPanel.add(MessagePanel, BorderLayout.NORTH);
	LeftPanel.add(middleLayerPanel, BorderLayout.CENTER);
	LeftPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
	add(LeftPanel);
	
	
	//setting up the right panel
	//and adding the scroll panel
	ComputerTextArea = new JTextArea();
	ComputerTextArea.setEditable(false);
	
	scrollPane = new JScrollPane(ComputerTextArea);
	add(scrollPane);
	
	
	//Step 3 setup the add button
	storeButton.addActionListener (new ButtonListener());
	
	
	//bottom of the storepanel class
  }


//start of the nested ButtonListener Class
private class ButtonListener implements ActionListener
   {
	public void actionPerformed(ActionEvent event)
	 {
		double price;
		int memory;
		int speed;
		
		 // if there is no error, add a computer to computer list
		 // otherwise, show an error message
		if(BrandNameTextField.getText().equals("")  || PriceTextField.getText().equals("") 
				|| MemoryTextField.getText().equals("") || CPUtypeTextField.getText().equals("")
				|| CPUspeedTextField.getText().equals("") )
		{
			EventMessage.setText("One or more of the fields are empty!");
			return; //we return out early if even one of the fields are empty
					//prevents any additional checking and speeds up the program a little bit.		
		}
		//now to catch the errors and display and error message
		else{
	
			try{
				
				memory = Integer.parseInt(MemoryTextField.getText());
				speed = Integer.parseInt(CPUspeedTextField.getText());
			}
			
			catch(NumberFormatException ex){
				
				EventMessage.setText("Please Enter a value For Memory and speed in the Form: '00'");
				return;
			}		
		}
		
		///Setting up the info for the constructor
		Computer comp = new Computer();
		//take information from the textfiled and give them over to the computer class
		comp.setBrandName(BrandNameTextField.getText());
		comp.setCPU(CPUtypeTextField.getText(), Integer.parseInt(CPUspeedTextField.getText()));
		comp.setMemory(Integer.parseInt(MemoryTextField.getText()));
		comp.setPrice(Double.parseDouble(PriceTextField.getText()));
		
		
		//add the computers from the array list to the
		ComputerTextArea.append(comp.toString());
		
		EventMessage.setText("Computer Added");
		
		//setting up the and adding computer to the Array list
		compList.add(comp);
		
		
		
		purchasePanel.updateCheckBoxList(compList);
		

     }
  }
}