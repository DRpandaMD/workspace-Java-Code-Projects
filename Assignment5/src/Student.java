//Assignment #: 5
//Name: Michael Zarate
//StudentID: 120-788-2984
//Lecture: MFW 0900
//Description: The Student Parent Class 

import java.text.DecimalFormat; //Imports the formatter for the desired output


//This class is an abstract parent class.  Namely because it has a abstract method in it
//The  abstract parts of the class will be filled out with data from its child classes
public abstract class Student {

	//instance variables note the 'protected modifiers'
	protected String firstName;
	protected String lastName;
	protected String studentID;
	protected int creditNum;
	protected double rate;
	protected double tuition = 0.0;

	public Student(String newFirstName, String newLastName, String newStudentID, int newCreditNum, double newRate){
		//Setting up all the initialization for the constructor
		firstName = newFirstName;
		lastName = newLastName;
		studentID = newStudentID;
		creditNum = newCreditNum;
		rate = newRate;
	}

	public int getCreditNum(){ //simple getter

		return creditNum;
	}
	
	//abstract method it will be called by the main method
	// but its data is filled by the methods defined in the child classes
	
	public abstract void computeTuition();	

	//Simple two string with the Decimal format on the values that are currency
	public String toString(){

		DecimalFormat fmt0 = new DecimalFormat("$##,##0.00"); //from the java.text package -> formats the number to a text 'currency' type output

		String outputString; //to String creation 
		outputString = "\nFirst name:\t\t" + firstName + "\n" + "Last name:\t\t" + lastName + "\n" +
				"Student ID:\t\t" + studentID + "\n" + "Credits:\t\t" + creditNum + "\n" + "Rate:\t\t\t" + (fmt0.format(rate)) +
				"\n" + "Tuition:\t\t" + (fmt0.format(tuition));
		return outputString; //returns the output string
	}//end two string

}//end student class
