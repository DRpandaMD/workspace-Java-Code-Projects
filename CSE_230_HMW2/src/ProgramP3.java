
public class ProgramP3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        int n3 = 10000000; // choose this input number to obtain sensible execution time
        double[] A = new double[10000000];
        for (int k = 0; k < n3; k++)
        {	
            A[k] = 0.4321;
        }
        long start3 = System.nanoTime();
        double sum3 = 0;
        for (int k = 0; k < n3; k++)
        {
            sum3 = sum3 + A[k];
            if (k % 1000000 == 0) // 1000000, 2000000, 3000000, ...
       	   	System.out.println("sum3 =  " +  sum3);
        }
        long ExcutionTime3 = System.nanoTime() - start3;
        System.out.println("Final Sum =  " + sum3 + " Execution time = " +  ExcutionTime3 + " Nanoseconds");


	}

}
