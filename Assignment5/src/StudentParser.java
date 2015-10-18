//Assignment #: 5
//Name: Michael Zarate
//StudentID: 120-788-2984
//Lecture: MFW 0900


import java.util.Scanner;

//This class will take an input string and seek out words separated by the '/'
// It will first compare the first word of the input file to figure out which type of student the file is
// then it will continue to parse by the delimiter and return the object student.

public class StudentParser { 
	
	public static Student parseStringToStudent(String lineToParse){ //the method
		
		//get the first token, delimited by "/"
		Scanner scan = new Scanner(lineToParse).useDelimiter("/");
		String optionOne = "Online";  //create strings to make comparisons to
		String word = scan.next(); //scan the next word  
		boolean returnValueOne = word.equalsIgnoreCase(optionOne); //compares the scanned word to the options 
																	//and creates boolean truth values
		//after we have figured out that one of the two cases
		//is true, ie the Online student 
		//then we start scanning the rest of the string
		if(returnValueOne == true){ 
			
			String firstName = scan.next();
			String lastName = scan.next();
			String studentID = scan.next();
			int credits = Integer.parseInt(scan.next()); //employing the use of the wrapper class
			double rate = Double.parseDouble(scan.next());// we can change a string to a int or double
			double fee = Double.parseDouble(scan.next());
			
			//taking the parameters of the online student class, we take the information and 
			//pass it the constructor to make the new data type student
			Student newStudent = new OnlineStudent(firstName, lastName, studentID, credits, rate, fee);
			
			return newStudent; //return the student datatype
		}
		
		else{//the other part of the only two options for the first part of the string input
			
			String firstName = scan.next();
			String lastName = scan.next();
			String studentID = scan.next();
			int credits = Integer.parseInt(scan.next());
			double rate = Double.parseDouble(scan.next());//again employing the use of the wrapper class
			String residentType = scan.next();
			double fee = Double.parseDouble(scan.next());
			
			//here I had to make a boolean comparison to check another string 
			//I am checking for whether or not the state of being a "resident" student is true
			//other wise you are a non resident student
			
			boolean resident;
			String compareResidentString = "Resident";
			//once again calling the equals method to compare string
			boolean returnValueString = residentType.equalsIgnoreCase(compareResidentString );
			
			if(returnValueString == true){
				resident = true;
			}//these statements set the boolean value of 'resident' to either true or false
			else{
				resident = false;
			}
			//calls the constructor in the on campus student class
			Student newStudent = new OnCampusStudent(firstName, lastName, studentID, credits, rate, resident, fee);
			return newStudent;
		}	
	}
}
