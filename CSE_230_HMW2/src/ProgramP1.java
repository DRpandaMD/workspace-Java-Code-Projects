
public class ProgramP1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n1 = 10000000; // choose this input number to obtain sensible execution time
        long start1 = System.nanoTime();
        long sum1 = 0;
        for (int i = 0; i < n1; i++ )
        {
        	sum1 += 1234;
        	
            if ( i %  1000000 == 0) // 1000000, 2000000, 3000000, ...
        	  	System.out.println("sum1 = " + sum1 + "  ");
        }
        long ExcutionTime1 = System.nanoTime() - start1;
        System.out.println("Final Sum =  " + sum1 + " Execution time = " +  ExcutionTime1 + " nano seconds");


	}

}
