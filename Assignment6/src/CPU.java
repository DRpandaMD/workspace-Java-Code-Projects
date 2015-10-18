// Assignment #: 4
// Name: Michael Zarate
// StudentID: 120-788-2984
// Lecture: 1
// Section: A
// Description:  Similar to the Class 'Computer' , the CPU class is an object of type
// CPU contains the constructor and other supporting methods to utilize this object.



public class CPU {
	
	// Variable Declaration
		private String type;
		private int speed = 0;

		public CPU()// blank 'default' constructor
		{

		}
		public String getType() // standard getter methods
		{
			return type;
		}
		public int getSpeed()// standard getter method
		{
			return speed;
		}
		public void  setType(String newType) //standard setter methods
		{
			type = newType;
		}
		public void setSpeed(int newSpeed) //standard setter method
		{

			speed = newSpeed;
		}
		public String toString() //Standard toString method.
		{
			String outputString;
			outputString = "CPU:\t\t" + type + "," + speed + "HZ";
			return outputString;
		}

}
