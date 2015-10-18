// Assignment #: 8
//         Name: Michael Zarate
//  PassengerID: 1207882984
//  Lab Lecture: MWF 9am
//  Description: The Passenger class describes a passenger entity and contains //  attributes first name, last name, passenger ID, and the number of bookings.
//  It also contains the accessors and the modifiers of each attribute.

import java.util.*;
import java.text.*;
import java.io.*;

public class Passenger implements Comparable, Serializable  {

  private String firstName;
  private String lastName;
  private String passengerID;
  private int bookingNum;

  public Passenger()
  {
    firstName = new String("?");
    lastName = new String("?");
    passengerID = new String("?");
    bookingNum = 0;
  }

 public String getFirstName()
  {
   return firstName;
  }

 public String getLastName()
  {
   return lastName;
  }

 public String getPassengerID()
  {
   return passengerID;
  }

 public int getBookingNum()
  {
   return bookingNum;
  }

 public void setFirstName(String fname)
  {
   firstName = fname;
  }

 public void setLastName(String lname)
  {
   lastName = lname;
  }

 public void setPassengerID(String pId)
  {
    passengerID = pId;
  }

 public void setBookingNum(int bookings)
  {
   bookingNum = bookings;
  }

 public String toString()
  {
   String passengerString;

   passengerString = "\nFirst name:\t\t" + firstName + "\n"
                 + "Last name:\t\t" + lastName + "\n"
                 + "Passenger ID:\t\t" + passengerID + "\n"
                 + "Number of bookings:\t" + bookingNum
                 + "\n\n";

   return passengerString;
  }

  public int compareTo(Object other)
   {
    int result;
    if (lastName.equals(((Passenger) other).lastName))
      result = firstName.compareTo(((Passenger) other).firstName);
    else
      result = lastName.compareTo(((Passenger) other).lastName);

    return result;
   }


}