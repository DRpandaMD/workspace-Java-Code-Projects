import java.util.*;


public class Test {

	public static void main(String[] Args){
		
		ArrayList<Passenger> passengerList;
		
		passengerList = new ArrayList<Passenger>();
		
		Passenger p1 = new Passenger();
		p1.setFirstName("Michael");
		p1.setLastName("Zarate");
		
		passengerList.add(p1);
		Passenger p2 = new Passenger();

		p2.setFirstName("Mohammad");
		p2.setLastName("Hekmatnejad");
		
		passengerList.add(p2);

		Passenger p3 = new Passenger();
		p3.setLastName("Smith");
		p3.setFirstName("Bob");
		
		passengerList.add(p3);
		
		//Sorts<Passenger> sorted = new Sorts<Passenger>();
		
		SortsNew.sortNew(passengerList);
		
		for(int i = 0; i < passengerList.size(); i ++)
		{
			System.out.println(passengerList.get(i).getLastName() + " " 
		+ passengerList.get(i).getFirstName() );
		}
		
	}
	
}
