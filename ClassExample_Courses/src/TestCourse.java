
public class TestCourse {
	public static void main(String[] args)
	{
		//create the first Course
		Course courseOne = new Course();

		//set courseOne's name, credit hours, student's number, schedule, etc
		courseOne.setCourseName("CSE205");
		courseOne.setSemesterHours(3);
		courseOne.setStudentsNum(57);
		courseOne.setSchedule("Mon/Wed/Fri", "12:55pm");

		//create the second Course
		Course courseTwo = new Course();

		//set courseTwo's name, credit hours, student's number, schedule, etc
		courseTwo.setCourseName("CSE180");
		courseTwo.setSemesterHours(3);
		courseTwo.setStudentsNum(425);
		courseTwo.setSchedule("Mon/Wed/Fri", "10:00am");

		//print the two courses' students number
		int numOfStudent = courseOne.getStudentsNum() + courseTwo.getStudentsNum();

		System.out.println("The two course have: " + numOfStudent + " students");

		//print the two courses' detailed information by using the toString() method
		System.out.print(courseOne);
		System.out.print(courseTwo);
	}


}
