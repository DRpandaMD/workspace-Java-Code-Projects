// The following defines a Class Schedule with days and time
// see class Course.java (which contains a Schedule object as an instance variable
// - Arrogation relationship.


public class Schedule {
	
	
	//Schedule contains days and time as its instance variables
	 private String days;
	 private String time;

	 //Constructor
	  public Schedule()
	  {
	   days = new String("?");
	   time= new String("?");
	  }

	 //Accessor method of the instance variable days
	 public String getDays()
	  {
	   return days;
	  }

	 //Accessor method of the instance variable time
	 public String getTime()
	  {
	   return time;
	  }

	 //Mutator method of the instance variable days
	 public void setDays(String dd)
	  {
	   days = dd;
	  }

	 //Mutator method of the instance variable time
	 public void setTime(String tt)
	  {
	   time = tt;
	  }

	 //toString method creates a string containing values of
	 //instance variables using the specified format and returns it
	 public String toString()
	  {
	   String scheduleString;

	   scheduleString = days + "," + time;

	   return scheduleString;
	  }


}
