//Assignment #: 5
//Name: Michael Zarate
//StudentID: 120-788-2984
//Lecture: MFW 0900
//The On campus Student Child class *inherits data from the Student 'Parent' class
//This class will also differentiate between students with resident status from
// those who do not have resident class.


//Here for this class since there was two options for On-campus students 
// students can have either resident or non-resident status


import java.text.DecimalFormat; 


public class OnCampusStudent extends Student{
	
	private boolean resident;
	private int creditUpperbound;
	private double studentProgramFee;

	public OnCampusStudent(String fName, String lName, String id, int credits, double rate, boolean newResident, double programFee) {
		
		super(fName, lName, id,  credits, rate);
		resident = newResident;
		studentProgramFee = programFee;
		// again i commented this out to let the main method
		//handle this for the selection of compute tuition.
		//computeTuition();
		
		if(resident == true){
			creditUpperbound = 7;
		}
		else {
			creditUpperbound = 12;
		}
	}
		
	//calculating the tuition based on different criteria
		public void computeTuition(){
			
			if(creditNum >= creditUpperbound){
				
				tuition = (rate * creditUpperbound) + studentProgramFee;
			}
			else{
				tuition = (rate * creditNum) + studentProgramFee;
			}
	}
		// I made two different  two string methods depending on 
		// if it was a resident or non resident on campus student
		// also utilizing the super.toString
		public String toString(){
			
			DecimalFormat fmt2= new DecimalFormat("$##,##0.00"); //from the java.text package -> formats the number to a text 'currency' type output
			String outputString = "";
			
			if(resident == true){
				
			outputString = "\nOnCampus Student:" + "\nResident Status" + super.toString() +
					"\nStudent Program Fee:\t" + (fmt2.format(studentProgramFee)) + "\n\n";
			
			}
			else{
				outputString = "\nOnCampus Student:" + "\nNonResident Status" + super.toString() + 
						"\nStudent Program Fee:\t" + (fmt2.format(studentProgramFee)) + "\n\n";
			}
			
			return outputString;
		}// end toString

}// end class
