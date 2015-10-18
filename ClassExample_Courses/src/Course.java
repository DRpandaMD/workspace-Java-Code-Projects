
public class Course {
	//The instance variables

	   private String courseName;
	   private int semesterHours;
	   private int studentsNum;
	   private Schedule schedule;


	   //Constructor. It initializes all instance variables to their default values.
	   //It instantiates the Schedule object.
	   public Course()
	    {
	     courseName = new String("?");
	     semesterHours = 0;
	     studentsNum = 0;

	     schedule = new Schedule();
	    }

	   //Accessor method of the instance variable courseName
	   public String getCourseName()
	    {
	     return courseName;
	    }

	   //Accessor method of the instance variable semesterHours
	   public double getSemesterHours()
	    {
	     return semesterHours;
	    }

	   //Accessor method of the instance variable studentsNum
	   public int getStudentsNum()
	    {
	     return studentsNum;
	    }

	   //Accessor method of the instance variable schedule
	   public Schedule getSchedule()
	    {
	     return schedule;
	    }


	   //Mutator method of the instance variable courseName
	   public void setCourseName(String cname)
	    {
	     courseName = cname;
	    }

	   //Mutator method of the instance variable semesterHours
	   public void setSemesterHours(int hours)
	    {
	     semesterHours = hours;
	    }

	   //Mutator method of the instance variable studentsNum
	   public void setStudentsNum(int snum)
	    {
	     studentsNum = snum;
	    }

	   //Mutator method of the instance variable schedule
	   //It sets its days and time using the parameter values
	   public void setSchedule(String days, String time)
	    {
	     schedule.setDays(days);
	     schedule.setTime(time);
	    }

	   //toString method creates a string containing values of
	   //instance variables using the specified format and returns it
	   public String toString()
	    {
	     String result = "\nCourse name:\t\t" + courseName + "\n" +
	            "Semester hours:\t\t" + semesterHours + "\n" +
	            "Number of students:\t" + studentsNum + "\n" +
	            "Schedule:\t\t" + schedule.toString() + "\n\n";

	     return result;

	  }


}
