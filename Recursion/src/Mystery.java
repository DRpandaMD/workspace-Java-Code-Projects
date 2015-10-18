
public class Mystery {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		writeStuff(1);
		System.out.println();
		writeStuff(2);
		System.out.println();
		writeStuff(3);
		System.out.println();
		
		moreStuff(1, "One:  ");
		moreStuff(2,  "");
		moreStuff(3, "Three:  ");

	}
	
	public static void writeStuff(int n)
	{
		if(n == 0)
			System.out.print(n);
		else
		{
			System.out.print("[");
			writeStuff(n-1);
			System.out.print("]");
		}
	}
	
	public static void moreStuff(int n, String s)
	{
		if (n == 1)
			System.out.println(s + n);
		else
		{
			s = s + "+=";
			moreStuff(n-1, s);
		}
	}

}
