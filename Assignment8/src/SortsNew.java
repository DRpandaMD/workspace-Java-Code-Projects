// Assignment #: 8
//         Name: Michael Zarate
//  PassengerID: 1207882984
//  Lab Lecture: MWF 9am
//  Description: This is the sorting algorithm class 
//				  This class uses a selection sort type of algorithm
//				  We use the comparable casting to cast comparable to our methods to allow them to 
//				 be compaired to eachother 


import java.util.*;

public class SortsNew
{

	public static void sortNew(ArrayList inputArrayListObjects) 
	{
		
		int min;
		Comparable temp;
		
		for(int index = 0; index < inputArrayListObjects.size()-1; index++)
		{
			min = index;
			
			for(int scan = index + 1; scan < inputArrayListObjects.size(); scan++)
			{
				if(((Comparable)inputArrayListObjects.get(scan)).compareTo((Comparable)(inputArrayListObjects.get(min))) < 0 )
					min = scan;
				
				
			}
			//perform the swap
			temp = (Comparable)inputArrayListObjects.get(min);
			inputArrayListObjects.set(min, inputArrayListObjects.get(index));
			inputArrayListObjects.set(index, temp);
		}
		
		
	}
	
	
}
