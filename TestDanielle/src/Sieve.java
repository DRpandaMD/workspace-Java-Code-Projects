// Assignment #:11
// Name: Danielle Jacobs
// StudentID: 120-26-15838
// Lecture: MWF 9:00AM
// Description: sieve.java defines a class called sieve that acts on the queue 

import java.io.*;
import java.util.*;
import java.math.*;

public class Sieve
{
	//instance variables
	Queue queueNumbers;
	Queue queueStore;	
	Queue queueMax;
	
	// constructs a sieve object
	public Sieve()
	{
		queueNumbers= new Queue();
		queuePrime= new Queue();
		queueMax= new Queue();
		
	}
	
	//computes all primes up to some n and store them the queue 
	public void computeTo(int n)
	{
		// add int 2:n into queue
		int i=2;
		int count=0;
		int value1=0;
		int value2=0;
		int size=0;
		int whilesize=(int)Math.sqrt(n);
		
		while(i<=n)// n=10
		{
			queueNumbers.enqueue(i);//2 3 4 5 6 7 8 9 10
			i++;
		}
		do{
		value1= (int)queueNumbers.dequeue(); //value1=2, 
		queuePrime.enqueue(value1);// 2  
		for (int count=0; count<queueNumbers.getsize(); count++)// 0-10
		{
			value2=(int)queueNumber.dequeue();// 3 
			if(value2%value1 !=0)//3%2 !=0  
			{
				queueNumbers.enqueue(value2);// store 3 in queueNumbers,
			}
		}
		}// end do
		while(value2 <= whilesize) 
		{
			size= queueNumbers.getsize();
			for(int k=0; i<size; i++)
			{
				queueNumbers.dequeue(value2);
				queuePrime.enqueue(value2);
			}
		}// end while 
		
/**		
create a queue and fill it with the consecutive integers 2 through n inclusive.
create an empty queue to store primes.
do {
  obtain the next prime by removing the first value in the queue of numbers.
  put the next prime into the queue of primes.
  go through the queue of numbers, eliminating numbers divisible by the next prime.
} while (the next prime < sqrt(n))
all remaining values in numbers queue are prime, so transfer them to primes queue
*/
	}
	
	//writes all the primes to System.out from your queue 
	//print the maximum n used
	// show list of primes
	// 12 per line with space after each prime 
	public void reportResults()
	{
		System.out.print(queuePrime.toString());
	}
	
	// finds the max prime number found last time computeTo was called 
	//cycle through the queue and grab the last element 
	public int getMax()
	{
		int max=0;
		int value=0;
		// say queuePrime is 2 3 5 7 11 
		for(int i=0; i<queuePrime.getsize(); i++)
		{
			value=(int)queuePrime.dequeue(i); //2 , 3, 5, 7, 11
			queueMax.enqueue(value); //2, 3, 5, 7, 11
			if( i= queuePrime.getsize()-1)
			{
				max=value;
			}
		}
		queuePrime= queueMax; 
		return max;
	}
	
	//Returns the count of primes found in your queue 
	public int getCount()
	{
		int count;
		count= queuePrime.getsize();
		return count;
	}
	
}// end sieve class 

	
	
