
// Assignment #: 4
// Name: Michael Zarate
// StudentID: 120-788-2984
// Lecture: 1
// Section: A
// Description: The Computer Class is an object of type Computer.  It gives 
// The basic constructor and other methods for making the data type of Computer.



import java.text.DecimalFormat; //Imports the formatter for the desired output

public class Computer
{
	//Variable Declaration 
	private String brandName;	
	private CPU CPU;
	private int memory = 0;
	private double price = 0.0;


	public Computer() //Standard constructor Method with the constructor for the CPU object
	{
		CPU = new CPU();
	}
	public String getBrandName()  //standard getter methods
	{
		return brandName;
	}
	public CPU getCPU() //standard getter method
	{
		return CPU;
	}
	public int getMemory() //standard getter method
	{
		return memory;
	}
	public double getPrice() // Standard getter method
	{
		return price;
	}
	public void setBrandName(String newBrandName)// standard setter methods 
	{
		brandName = newBrandName;
	}
	public void setCPU(String newType, int newSpeed) // includes the methods from
	{												// the CPU class note the CPU.set**** 
		CPU.setType(newType);
		CPU.setSpeed(newSpeed);
	}
	public void setMemory(int newMemory)  //standard setter method
	{
		memory = newMemory;
	}
	public void setPrice(double newPrice) //standard setter method
	{
		price = newPrice;
	}
	public String toString() //toString method with the inclusion of the CPU toString method
	{
		DecimalFormat fmt0 = new DecimalFormat("$##,###.00"); //from the java.text package -> formats the number to a text 'currency' type output
		String outputString;	
		outputString = "\nBrandName:\t" + brandName + "\n" + CPU.toString() + "\n"
				+ "Memory:\t\t" + memory + "M\n" + "Price:\t\t" + (fmt0.format(price))
				+ "\n\n";
		return outputString;
	}

}//End Class
