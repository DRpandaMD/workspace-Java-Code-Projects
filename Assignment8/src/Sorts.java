import java.util.*;

//Sorting a Variety of Array Lists 
//by taking advantage of Templates in Java
public class Sorts<T extends Comparable>
{
	
	
	
	//selection sort modified for array list
	public void sort (ArrayList<T> objects)
	{
		//instantiate the array list and define a static size of type int
		ArrayList<T> sortedList = new ArrayList<T>(objects.size());
		int size = objects.size();
	
		for(int i = 0; i <  size - 1; i++)
		{
			int index = i;
			T min = (T)objects.get(i);
			for(int j = i + 1; j < size; j++)
			{
				//calls the compareTo to compare the Lists
				if( min.compareTo(objects.get(j)) > 0)
				{
					min = objects.get(j);
					index = j;
				}
			}
			sortedList.add(min);
			objects.set(index, objects.get(i));
			
			//unneeded code
			//int smallerArrayIndexPostion = arrayList.get(index);
			//arrayList.get(index) = arrayList.get(i);
			//arrayList.get(i) = smallerArrayIndexPostion;
			
		}
		sortedList.add(objects.get(size-1));
		
		objects.clear(); //clears objects of data
		for(T t:sortedList) //iterates through collection
			objects.add(t); //adds the object from the list 
				
			
			
			
	}

}



