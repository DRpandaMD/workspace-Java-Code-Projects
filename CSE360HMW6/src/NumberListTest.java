import static org.junit.Assert.*;

import org.junit.Test;


public class NumberListTest 
{
	
	NumberList list ;

	@Test
	public void testNumberList() 
	{
		list = new NumberList(1);
		assertEquals(0, list.size());
	}


	@Test
	public void testInsert() 
	{
		list = new NumberList(5);
		assertEquals(0,list.size());  //constructor made list (based on count) = 0 *passes*
		list.insert(10);
		
		assertEquals(1,list.size()); // expected 1 but was zero
		
		list.insert(2);
		assertEquals(2,list.size());	// looks like its not being added
										// since count is not being incremented
		list.insert(11);
		assertEquals(3,list.size());  //expected 2 but was 0
		list.insert(24);
		assertEquals(4,list.size()); 
		
		
	}


	@Test
	public void testDelete()   ///assuming that delete DOES work properly
	{							//insert is still causing a problem here.
		list = new NumberList(5);
		assertEquals(0,list.size());
		list.insert(1);
		assertEquals(1,list.size());
		list.insert(2);
		assertEquals(2,list.size());
		list.insert(3);
		assertEquals(3,list.size());
		
		//delete
		
		list.delete(3);
		assertEquals(2,list.size());
		list.delete(1);
		assertEquals(1,list.size());
		list.delete(2);
		assertEquals(0,list.size());
		
		
		
		

		
	}

	@Test
	public void testSize()   //size wont work properly when insert is not working properly
	{
		list = new NumberList(5);
		assertEquals(0, list.size());
		list.insert(1);
		assertEquals(1, list.size());
		
		
	}


	
	
	@Test
	public void testToString() 
	{
		list = new NumberList(3);
		
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		assertEquals(1234, list.toString());  
											
		
	}

	
}
