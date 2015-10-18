// Assignment #:11
// Name: Michael Zarate
//    StudentID: 1207882984
//  Lab Lecture: MWF 9am
//      Section: MWF 9am
// Description:  Uses a linked list to implement a Queue



import java.util.LinkedList;

public class Queue
{
  private LinkedList list;

  //constructor
  public Queue()
  {
	  list = new LinkedList();
  }

  public void enqueue(Object object) // add last
  {
    list.addLast(object);
  }

  public Object dequeue() //remove first
  {
    return list.removeFirst();
  }

  public int getSize() //get size, easy mode
  {
    return list.size();
  }

  public String toString()  //over right the toString to get the specific output desired
  {
	  
	  int count = 0; //make and initialize a counter
	  String outputString = ""; //make and intialize a string
	  	
	  //we go through the linked list by index of i and we toString that data per NODE
	  for(int i = 0; i < this.getSize(); i++)
	  		{
	  			outputString += list.get(i).toString() + " "; //for each node append the to string to the string
	  			count ++;
	  			if(count >= 12) //for ever 12th number we encounter
	  			{
	  				outputString += "\n";//we add a new line character
	  				count = 0;
	  			}
			}
	  	
			
	  
	  return outputString;
  }

  
  
  ///had to add the following.
  public Object getLast()  //added this to get the last out  thanks JAVA API
  {
	  return list.getLast();
  }
  
}
  
//  public String toString()
//  {
//	  String result = "";
//	  LinkedListNode current = head;
//	  while(current.getNext() != null)
//	  {
//		  current = current.getNext();
//		  result += current.data + " ";
//	  }
//	  return result;
//  }
//  
//  
//}
