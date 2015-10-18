// Assignment #: 8
//         Name: Michael Zarate
//  PassengerID: 1207882984
//  Lab Lecture: MWF 9am
//  Description: This class integrates the components of the Flight, FlightParser 
//               Passenger Parser, the Sorting Algorithm to assist the driver class to accomplish
//               Various tasks such as add remove exists 

import java.util.ArrayList;
import java.io.*;

public class Reservation implements Serializable
{
	// declare the two arrayLists
	private ArrayList<Passenger> passengerList;
	private ArrayList<Flight> flightList;
	//private 
	
	//Initializes the ArrayLists
	public Reservation()
	{
		passengerList  = new ArrayList<Passenger>();
		flightList = new ArrayList<Flight>();
	}
	
	//linear search
	// simple search to see if the given passenger exists
	public int passengerExists(String passengerID)
	{
		for(int i = 0; i < passengerList.size(); i++)
		{
			if(passengerList.get(i).getPassengerID().equals(passengerID))
			{
				return i; 
			}
			
			
		}
		return -1;
		
	}
	//adds a passenger to the array list
	public boolean addPassenger(String newPassengerString)
	{
		
		Passenger passenger = PassengerParser.parseStringToPassenger(newPassengerString);
		// we check to see if the given passenger doesn't exists then its ok to add it to the list
		if(passengerExists(passenger.getPassengerID()) == -1)
		{
			passengerList.add(passenger);
			return true;
		}
		return false;
		
	}
	//removes a passanger from the ArrayList
	public boolean removePassenger(String newPassengerID)
	{
		//again we follow the same logic if we have one that doesn't' exists we cant remove it
		// so we look for one that does it exist and then go ahead and remove it
		int index = (passengerExists(newPassengerID));
		if(index != -1)
		{
			passengerList.remove(index);
			return true;
		}
		return false;
		
		
	}
	//calls the Sorts Class to call the sortNew Method to sort the ArrayList
	public void sortPassengers()
	{
		//calls the sortNew method
		SortsNew.sortNew(passengerList);
	}
	
	
	public String listPassengers()
	{
		String returnString = "";
		if(passengerList.size() >  0)
		{
			for(int i = 0; i< passengerList.size(); i++)
			{
				//here we call the toString method on every object in the list
				// and add that toString to the previous toString so make one long string to return
				returnString += passengerList.get(i).toString();
				
			}
			
			return returnString;
		}
		else
			returnString = "no passenger\n";
			return returnString;
		
	}
	
	public int flightExsists(String airlinesName, String flightNum, String depCity)
	{
		//we follow the same logic as the passengerExsists methods but we just more fields to compare
		for(int i = 0; i < flightList.size(); i++)
		{
			if(flightList.get(i).getAirlines().equals(airlinesName) && 
					flightList.get(i).getFlightNum().equals(flightNum)	&&
					flightList.get(i).getDeparture().getCity().equals(depCity))
			{
				return i;
			}
			
			
		}
		
		return -1;
	}
	
	
	public boolean addFlight(String newFlightString)
	{
		// the same logic as addPassenger
		Flight flight = FlightParser.parseStringToFlight(newFlightString);
	
		if(flightExsists(flight.getAirlines(), flight.getFlightNum(),
				flight.getDeparture().getCity()) == -1)
		{
			flightList.add(flight);
			return true;
		}
		return false;
		
		
	}
	
	
	//same logic as removePasenger
	public boolean removeFlight(String airlinesName, String flightNum, String depCity)
	{
		int index1 = (flightExsists(airlinesName, flightNum, depCity));
		//System.out.println("Deleting that index " + index1 );
		if(index1 != -1)
		{
			flightList.remove(index1);
			return true;
		}
		return false;
		
		
		
	}
// same logic and method called in the SortsNew class
	public void sortFlights()
	{
		SortsNew.sortNew(flightList);
		
	}
	
	//we use the same pattern to add the toStrings together from the listPassengers
	public String listFlights()
	{
		String otherReturnString = "";
		if(flightList.size() >  0)
		{
			for(int i = 0; i< flightList.size(); i++)
			{
				
				otherReturnString += flightList.get(i).toString();
				
			}
			
			return otherReturnString;
		}
		else
			otherReturnString = "no flight\n";
			return otherReturnString;
		
		
	}
	//we close the reservation and clear the arrayList of their data
	public void closeReservation()
	{
		
		flightList.clear();
		passengerList.clear();
		
	}
	
	
	
}
