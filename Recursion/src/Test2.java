
public class Test2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		xMethod(1234567);

	}
	
	public static void xMethod(int n)
	{
		if (n > 0)
		{
			System.out.print(n % 10);
			xMethod(n/10);
		}
	}

}
