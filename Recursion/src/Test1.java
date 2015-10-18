
public class Test1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
			System.out.println("The result is:" + xMethod(5));
	}
	
	public static int xMethod(int n)
	{
		if( n == 1 )
			return 1;
		else
			return n + xMethod(n-1);
	}

}
