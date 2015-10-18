// Assignment #5
// Name: Michael Zarate
//    StudentID: 1207882984
//
//  Purpose to take messy code and refactor it to a readable standard



/**
 * This Class 'numberList' is a class to edit and list numbers 
 * stored in an array. <br> Features to this class include getting the size, 
 * inserting a new element, deleting an element, print out the elements via the 
 * toString() method. <br> Finally increase or decrease the size of the array by 50% 
 * and search the array for a specific element. <br>
 * 
 * As per the Class Diagram  the toSting() method and the constructor <br>
 * NumberList(int number) are fully completed and operational<br><br>
 * 
 * The Following are yet to created: <br> <br>
 * size() - gets the size of the NumberList <br>
 * insert() - inserts a new element <br>
 * delete() - deletes a specific element if it exsists <br>
 * increase() - increases the size of the NumberList by 50% <br>
 * decrease() - decreases the size of the NumberList by 50% <br>
 * search() - searches for specified element and returns its index position in the array() <br>
 * @author michaelzarate
 *
 */


public class NumberList 
{

	private int list[];
	private int count;
	
	/**
	 * The 'NumberList' method is a method that makes a new list of array type 
	 * @param number is passed to the method to make an array of that size
	 */
	
	public NumberList(int number) 
	{
		list = new int[number];
	}
	
	/**
	 * func1 needs some serious reworking given the interior of the function and <br>
	 * the integer names it is hard to tell what is going on with out running the code. <br> 
	 * 
	 * I believe that this func1() is supposed to increase the size or Insert a new element. <br>
	 * 
	 * @param k  passes an integer value to be inserted
	 * 
	 * Function can be renamed to insert
	 */
	
	
	public void func1(int k)
	{
		
		//needs a re work and explicit declaration of what these integer variables are supposed to be
		int a;  //what is 'a' here
		int upper;
		int lower;
		int x; //what is 'x' here
		
		if(count >= list.length)
			fun1();
		
		if(count > 0) 
		{
			upper = count - 1;
			lower = 0;
			 x = (upper + lower) / 2;
			
			while(upper > lower && list[x] != k) 
			{
				if(list[x] < k)
				{
					lower = x + 1;
				}
		
				else if(list[x] > k) // each of these ifs and else ifs need some intuitive comments to help show the flow
				{					// of the logic through out the method	
					upper = x - 1;
					x = (lower + upper) / 2;
				}
				if(list[x] != k) 
				{
					a = list[x];
				}
				if(list[x] < k) 
				{		
					x++;
					a = list[x];
				}
				
				while(x < count) 
				{
					list[x] = count;
					count = a;
					x++;
					a = list[x];
				}
				
				list[x] = cu; //what is cu supposed to be
				count++;
			}
		}
		
		else
		{
			list[0] = k;
		}
	}

	
	/**
	 * Similar to func1() this method needs some serious rework and comments to be able to tell what is happening internally
	 * a series of system.out.println() statements  can be use to discern the inner workings of the method if need be
	 * 
	 * @param k  is an integer passed to what appears to be an other form of inserting element k into our list
	 */
	public void func3(int k) 
	{
		int upper; //changed from up
		int lower; //changed from lo
		int x;  //could be 'index' or 'middle' here
		
		if(count > 0) 
		{
			upper = count - 1;
			lower = 0;
			x = (upper + lower) / 2;
		 
			while(upper > lower && list[x] != k)
			{
				if(list[x] < k)
					lower = x + 1;
				else if(list[x] > k)
					upper = x - 1;
					x = (lower + upper) / 2;
			}
			
			if(list[x] == k)
			{
				if(x < count - 1) 
				{
					while(x < count - 1) 
					{
						list[x] = list[x + 1];
						x++;
					}
				}
				count--;
				
				if(count <= list.length / 2)
					fun2();
			}
		}
	}
	
	/**
	 * 
	 * This method overrides the default toString method to allow us to print out the entire contents of the array<br>
	 * we let the index start at 0 and move to count. <br> Additionally count can be substituted for a call to list.lenght()
	 * to make sure we print out each element. <br> Each element is added to a String called 'outputString' one at a time through
	 * the loop with a space in between.
	 * 
	 */
	
	public String toString() 
	{
		String outputString = new String();
		int index = 0;
		while (index < count) // maybe list.length here
		{
			//if (i >= c) break;  no need to break here
			outputString += " " + list[index];  //go through the array and add the new element to the string with a space in between
			index++; 
		}
		
		return outputString;
	}

	
	/**
	 * 
	 * fun1() appears to be copying the elements from the existing array 'list' into a new array of the size of 'list'  <br>
	 * called tl.  I believe tl stands for "temporary list" yet it is unclear exactly what needs to be done here. <br>
	 * the method fun1() should be called 'listCopy()' for clarity and it should also return the array. <br>
	 * <br>
	 * 
	 * Can be called increase
	 * 
	 */
	private void fun1()
	{
		int tl[] = new int[list.length];
	
		for(int i = 0; i < list.length; i++)
		{
			tl[i] = list[i];
			list = tl;
		}
	}
	
/**
 * fun2() appears to be an exact copy of fun1().  It is unclear to me as why there are exact duplicates. <br>
 * For simplicity and good code writing there should be one method performing one task.<br>
 * <br>
 * 
 * can be called decrease
 */
	
	private void fun2() 
	{
		int tl[] = new int[list.length];
		
		for(int i = 0; i < tl.length; i++)
		{
			tl[i] = list[i];
			list = tl;
		}
			
	}
}
	

