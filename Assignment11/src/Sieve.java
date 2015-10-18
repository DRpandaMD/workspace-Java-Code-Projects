// Assignment #:11
// Name: Your name
//    StudentID: 1207882984
//  Lab Lecture: MWF 9am
//      Section: MWF 9am
// Description: Creates an Sieve object to perform the Seive of Erasosthenes
// we are using linked lists



import java.io.*;
import java.util.LinkedList;
import java.math.*;

public class Sieve { 

	Queue primesQueue; //Declare my variables
	Queue storageQueue; 
	
	public Sieve() //constructs the Sieve object
	{
		primesQueue = new Queue();
		storageQueue = new Queue();
	
	}
	
	public void computeTo(int n)
	{
		
		
		if(n >=2 )// first we check if the number is imputed for n is 2 
			//or greater than 2 to avoid division by 0 errors
		{
			for(int i = 2; i <= n; i++)
			{
				storageQueue.enqueue(i); // we take the number n and go from 2 to n 
										//and fill up the storage Queue with those numbers
			}
		
			int nextPrime; //declare my next prime variable
			
			//THE SEIEVE
			do{
				nextPrime = (int)storageQueue.dequeue(); //get the first number out since we know its 2 its prime
				int size = storageQueue.getSize(); //we get the size of storage queue
				primesQueue.enqueue(nextPrime); //store 2
				for(int j = 0; j < size; j++)
				{
					int nextNum = (int)storageQueue.dequeue(); //get the next number out 
					if(nextNum % nextPrime != 0) //check if its not divisible by it
					{
						storageQueue.enqueue(nextNum); //put that number back
					
					}
					
				} //by the end of this it will have found all the prime number up to 'n'
		
		} while(nextPrime < Math.sqrt(n)); //keep on doing the above till we meet this condition
		
		int finalSize = storageQueue.getSize(); //get the final size of the storage queue
			for(int i = 0; i < finalSize; i++) //we go through the storage queue
			{
				int toStorePrime = (int)storageQueue.dequeue(); //and we get the numbers out
				primesQueue.enqueue(toStorePrime); //and pout them in the primes queue
			}
		}
	}
	
	public void reportResults() //print out the results
	{
		
		System.out.print(primesQueue.toString());
		
	}
	
	public int getMax() //we get the max size 
	{
		if(primesQueue.getSize() > 0)
		{
		
			int max = (int) primesQueue.getLast();
		
			return max;
		}
		else //added this to avoid division by 0
		{
			return 1;
		}
	}
	
	public int getCount() //get the count 
	{
		int count = primesQueue.getSize();
		
		return count;
	}
	
}
