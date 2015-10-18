//Assignment #: 5
//Name: Michael Zarate
//StudentID: 120-788-2984
//Lecture: MFW 0900
//The Online Student Child class *inherits data from the Student 'Parent' class



import java.text.DecimalFormat; //Imports the formatter for the desired output

public class OnlineStudent extends Student{
	
	private double computingFee;
	
	
	//constructor
	public OnlineStudent(String fName, String lName, String id, int credits, double rate, double compFee){
		
		super(fName, lName, id, credits, rate);
		computingFee = compFee;
		creditNum = credits;
		
		//computeTuition(); 
		//this was commented out due to the fact that it 
		//is computed in the main method NOT in the child class
		//other wise the output will not match the desired output 
		//as per the txt file instructons.
		
	}//end constructor
	
	//this method here is no longer abstract and gets passed here 
	// and passed once more to the main method for computation
	// *note* that this computation for Tuition is unique for students that are online students.
	public void computeTuition(){
		
		tuition = (rate + computingFee)*creditNum;	
	}//end computeTuition
	
	//Here we will use the decimal format once again
	//and also the super to string to include the information in the parent class.
	public String toString(){
		
		DecimalFormat fmt1 = new DecimalFormat("$##,##0.00"); //from the java.text package -> formats the number to a text 'currency' type output
		
		String outputString;
		outputString = "\nOnline Student:" + super.toString() + "\nComputing Fee:\t\t" + (fmt1.format(computingFee)) + "\n\n";
		return outputString;
	}//end toString

}//end class
