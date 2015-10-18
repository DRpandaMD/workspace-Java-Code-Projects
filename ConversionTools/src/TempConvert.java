import java.util.Scanner;


public class TempConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double C;
		double G;
		double T;
		double F;
		double P;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the temperature converter");
		System.out.println("Please enter a temerature in Celcius to be converted");
		
		C = scan.nextDouble();
		
		F = (C * (9.0/5.0)) + 32;
		
		System.out.println("The Temperature is " + F + " Degrees Fahrenhite");
		
		System.out.println("Please enter a gallon ammount to convert to tons (ignore water density)");
		
		G = scan.nextDouble();
		
		P = G *8.33;
		
		T = (P/2205);
		
		System.out.println(G +" Gallons of water is : "  + T + "Tons" );
		
		
		
		

	}

}
