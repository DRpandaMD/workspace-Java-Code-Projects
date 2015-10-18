// Assignment #: 8
//         Name: Michael Zarate
//  PassengerID: 1207882984
//  Lab Lecture: MWF 9am
//  Description:  //This class take input from a file or user as integers and puts them in an array of
//                 of size 100.  Then it performs actions on the array via recursive method calls.
//  			It finds the maximum number in the array, the count of positive number,
//              the sum of the numbers divisible by 3 and also searches for a number in the array
//              and returns the index of where the number is or a negative 1 if it doesn't exsist


import java.io.*;

public class Assignment9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//section of code to take input from user 
		// declare my varialbes
		int x;
		int [] storageArray = new int [100]; //global array to be used
		int i = 0; //indexnumber // we don't even use this
		int key = 0;
		int counter = 0;
		
		String tempString;
		
		//make an inputStreamReader object to read from keyboard
		
		InputStreamReader inputReader = new InputStreamReader(System.in);
		
		//create a bufferedReader object
		BufferedReader bufferedReader = new BufferedReader(inputReader);
		
		//set up the reader to start taking inputs
		
		try
		{
			
			//read in first string parts
			tempString = bufferedReader.readLine();
			
			//then convert the string into an int since we know we will be getting ints
			x = Integer.parseInt(tempString);
			// i added this little bit below to fix  why my array wasn't being filled properly
			storageArray[counter]  = x;
			counter++;
			
			while( x != 0)
			{
				//read in first string parts
				tempString = bufferedReader.readLine();
				
				//then convert the string into an int since we know we will be getting ints
				x = Integer.parseInt(tempString);
				
				storageArray[counter] = x;  //puts the parsed int into the element of the array
				counter ++; //increments the counter
			}
			
			
			//this section will find the 'key' and use in the 'exists' method
			//read in first string parts
			tempString = bufferedReader.readLine();
			
			//then convert the string into an int since we know we will be getting ints
			x = Integer.parseInt(tempString);
			
			key = x;
			
		}
		// here we catch the exception
		catch(IOException exception)
		{
			System.out.println("Wrong input!! Catched" + exception);
		}
		
		// store all the return outputs of the methods into variable names
		int findMaxOutput = findMax(storageArray, 0, storageArray.length-1);
		int positiveCount = countPositive(storageArray, 0, storageArray.length-1);
		int sumDivisibleBy3 = computeSumDivisibleBy3(storageArray, 0, storageArray.length-1);
		int existsOutput = exists(storageArray, 0, key);
		
		//print them out to the user
		System.out.println("The maximum number is: " + findMaxOutput);
		System.out.println("The count of positive integers is: " + positiveCount);
		System.out.println("The sum of the numbers divisible by 3 is: " + sumDivisibleBy3);
		System.out.println("The search key is at index: " + existsOutput);
		
	}//end class
		
		//finds max number in array
		public static int findMax( int [] numbers, int startIndex, int endIndex)
		{
			//base case
			if (startIndex == endIndex) //we have sub arrays of only 1 elements
				return numbers[startIndex];
			
			else
			{
				//we make a mid index and recursive split the array into left and right bits
				int midIndex = (startIndex + endIndex)/2;
				int leftMax = findMax(numbers, startIndex, midIndex);
				int rightMax = findMax(numbers, midIndex + 1, endIndex);
				if (leftMax > rightMax) //here we check if the left it greater then return it or else 
					return leftMax;    // otherwise return the right
				else
					return rightMax;
						
			}//end else
		}//end findMax

		
		//counts all positive integers greater than 0
		public static int countPositive( int [] numbers, int startIndex, int endIndex)
		{
			//base case
			if (startIndex == endIndex)
			{
				if(numbers[startIndex] > 0)
					return 1;
				else
					return 0;
			}//end first if
			
			else//following same logic as above: we just count up the left and right parts that 
			{   //happen to be positive
				int midIndex = (startIndex + endIndex)/2;
				int leftPositiveCount = countPositive(numbers, startIndex, midIndex);
				int rightPositiveCount = countPositive(numbers, midIndex + 1, endIndex);
				
				return leftPositiveCount + rightPositiveCount;
			}
		}
		
		//adds all the numbers together by 3 
		public static int computeSumDivisibleBy3(int [] numbers, int startIndex, int endIndex)
		{
			//base case
			if (startIndex == endIndex)
			{
				if(numbers[startIndex] % 3 == 0) //use mod 3 == 0 to check divisible by 3
				{
					return numbers[startIndex];
				}
			}
			
			else//again we just recursively split in to left and right parts and add the sum up
			{
				int midIndex = (startIndex + endIndex)/2;
				int leftDivisbleBy3Number = computeSumDivisibleBy3(numbers, startIndex, midIndex);
				int rightDivisbleBy3Number = computeSumDivisibleBy3(numbers, midIndex +1, endIndex );
				
				int sum = leftDivisbleBy3Number + rightDivisbleBy3Number;
				return sum;
			}
			return 0;
		
			
		}
		
		
		//checks to see if the 'key' number exsists in the array or not
		public static int exists(int [] array, int firstIndex, int searchElement)
		{
			if (array[firstIndex] == searchElement)  //here we check if the element of the array is 
			{										//= to the search element
				return firstIndex; //cool we found the number give the index back
			}
			
				if(firstIndex == array.length-1) //here we see if we are at the end of the array
				{
					return -1; //we haven't found the number at this point return -1
				}
				
			
			else //Recursively call the method until base case is met.
			{
				int returnValue = exists(array, firstIndex+1, searchElement);
				return returnValue;
				
						
			}
					
		}

}
			
			
			
			
		
		

		
	


