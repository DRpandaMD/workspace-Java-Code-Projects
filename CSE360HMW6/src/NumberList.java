//package cse360assign;

//michael Zarate
//CSE360
//Assignment 6pt2

public class NumberList 
{
	private int numbers[];
	private int count = 0;

	public NumberList(int num) 
	{
		numbers = new int[num];
	}

	public void insert (int key) //insert a key
	{
		if(count >= numbers.length)
			increase();
		
		if(count > 0) 
		{
			int loc = search (key); // look for the key
		
			if(numbers[loc] != key) 
			{
				int ahead = numbers[loc];
				int current = key;
				
				if(numbers[loc] < key) 
				{
					loc++;
					ahead = numbers[loc];
				}
				while(loc < count) 
				{
					numbers[loc] = current;
					current = ahead;
					loc++;
					ahead = numbers[loc];
				}
				numbers[loc] = current;
				count++;
			}
		}
		else 
		{
			numbers[0] = key;
			count++;
		}
	}

	public void delete (int key)  //deletes specified value
	{
		if (count > 0) 
		{
			int loc = search (key);
			
			if (numbers[loc] == key) 
			{
				if (loc < count - 1) 
				{
					while(loc < count - 1) 
					{
						numbers[loc] = numbers[loc + 1];
						loc++;
					}
				}
				count--;
				
				if(count <= numbers.length / 2)
					decrease();
			}
		}
	}

	public int size () //returns the count
	{
		return count;
	}

	private int search (int val) 
	{
		//search for val
		
		int upper = count - 1;
		int lower = 0;
		int mid = (upper + lower) / 2;
		while(upper >= lower && numbers[mid] != val) 
		{
			
			if(numbers[mid] < val)
			{
				lower = mid + 1;
			}
				
			else if(numbers[mid] > val)
			{
				upper = mid - 1;
			}
			
			mid = (lower + upper )/2;
		}
		return mid;
			
	}
	public String toString() 
	{
		String str = new String();
		for (int pos = 0; pos < count; pos++)
			str += numbers[pos] + " "; //toString() with a space
		return str;
	}

	private void increase () 
	{
		int temp[] = new int[numbers.length * 2]; //increase by 100%
		for(int index = 0; index < count; index++)
			temp[index] = numbers[index];
		numbers = temp;
	}

	private void decrease () 
	{
		int temp[] = new int[numbers.length / 2]; //decrease by %50
		for(int index = 0; index < count; index++)
			temp[index] = numbers[index];
		numbers = temp;
	}
}