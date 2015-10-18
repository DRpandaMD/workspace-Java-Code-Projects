// Assignment #: 10
//         Name: Michael Zarate
//    StudentID: 1207882984
//  Lab Lecture: MWF 9am
//      Section: MWF 9am
//  Description: Provides the methods necessary to modify the linked list




/*   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.

*/
import java.util.*;
public class LinkedList
{

   private class Node
   {
      public Object data;
      public Node next;
   }
    //instance variable first points to the beginning of the linked list
    private Node first;
   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;
   }

   /**
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node
      first = newNode;
   }

    // add your methods here
   /*****************************************************************************/
   
   //to string method to Print out the objects 
   public String toString()
   {
	   //make an iterator to traverse through the list
	   ListIterator iterator = this.listIterator();
	   
	  String returnString = "{ ";
	  while(iterator.hasNext())
	  {
		  returnString += iterator.next() + " ";
	  }
	  returnString += "}\n";
	  return returnString;
   }
   
   //get the size of the linked list
   public int size()
   {
	   //use a local variable to count how many objects we find in the list
	   //thus effectively returning the size of the list.
	   int counter = 0;
	   
	   ListIterator iterator = this.listIterator();
	   
	   while(iterator.hasNext())
	   {
		   iterator.next(); //return the object and up the count
		   counter++;
	   }
	   
	   return counter;
   }
   
   
   public boolean isEmpty()  //simple logic to check if its empty
   {
	   if(first == null)
		   return true;
	   else 
		   return false;
	      
   }
   
   
   public Object searchElement(int index)
   {
	   int searchIndex = 0;
	   
	   ListIterator iterator = this.listIterator();
	   
	   if((index < 0) || (index > this.size())) //if the number is less than 0 or 
	   {										// larger than the index size throw exception
		   IndexOutOfBoundsException exception = new IndexOutOfBoundsException();
		   throw exception;
	   }
	   else//other wise we look go through the list looking for the index
	   	{
		   while(searchIndex != index)
		   {
		   iterator.next();
		   searchIndex++;
		   }
		   
			   return iterator.next(); //return the obeject
		   
	   	}
	   
   }
   
   public void addElement(int index, Object element)
   {
	   int traverseIndex = 0;
	   ListIterator iterator = this.listIterator();
	   
	   if((index < 0) || (index > this.size())) //we check the bounderies of the linked list
	   {										// if they are out of bounds throw exception
		   IndexOutOfBoundsException exception = new IndexOutOfBoundsException();
		   throw exception;
	   }
	   else
	   {
		   while(traverseIndex != index)  // we traverse to index we are looking for
		   {
			   iterator.next();
			   traverseIndex++; 
		   }
			   iterator.add(element); //then add the new item in the linked list
	   }
	   
   }
   
   
   public void reverse()
   {
	   ListIterator iterator = this.listIterator();
	   //iterator.next();
	   iterator.next(); //we point to index 1
	   
	   while(iterator.hasNext() != false) //while the condition is true
	   {
		   this.addFirst(iterator.next()); //add the pointed to item and move it to the list
		   iterator.remove(); //then remove it
	   }
   }
   
   
   public void removeLastFew(int howMany)//this one is a little tricky
   {
	   int startIndex = 0; 
	   int count = 0;
	   ListIterator iterator = this.listIterator();
	   
	   startIndex = size() - howMany; //formula for the starting Indx
 	   
	   if(howMany < 0) //first we check if the number is smaller than the array
	   {
		   return; // do nothing
	   }
	   else 
		   if(howMany > this.size()) //if it is bigger then delete whole list
		   {
			  first = null; //easy just point the head pointer to null
		   }
		   else //other wise in two steps
		   {
			   for(int i = 0; i < startIndex; i++) //move the pointer the starting point of your deletion
			   {
				   iterator.next(); //just move along the list
			   }
			   for(count = 0; count < howMany; count++) //then we move to the next 
			   {
				  iterator.next();//get the object
				  iterator.remove();//delete
				      
				   
			   }
		   }

	   
	   //add more code here
   }
   
///****END OF ADDED CODE*******
 
   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }


   private class LinkedListIterator implements ListIterator
   {
	  private Node position;
      private Node previous;
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

   }//end of LinkedList iterator class
}//end of Linked List class
