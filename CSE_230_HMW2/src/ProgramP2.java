
public class ProgramP2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		int n2 = 10000000; // choose this input number to obtain sensible execution time
        long start2 = System.nanoTime();
        double sum2 = 0;
        for (int j = 0; j < n2; j++)
        {
            sum2 += 0.4321;
            if (j %  1000000 == 0) // 1000000, 2000000, 3000000, ...
       	   	System.out.println("sum2 =  " +  sum2);
        }
        long ExcutionTime2 = System.nanoTime() - start2;
        System.out.println("Final Sum = " + sum2 + "Execution Time: " + ExcutionTime2 + " Nanoseconds");


	}

}
