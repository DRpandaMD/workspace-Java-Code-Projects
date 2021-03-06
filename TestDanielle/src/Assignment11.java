// Assignment #:11
// Name: Danielle Jacobs
// StudentID: 120-26-15838
// Lecture: MWF 9:00AM
// Description: Assignment 11 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//      enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;

public class Assignment11
 {
  public static void main (String[] args) throws IOException
   {
       char input1;
       String inputInfo;
       String line = new String();

       printMenu();

       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader stdin = new BufferedReader(isr);

       Sieve s = new Sieve();
       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           // matches one of the case statements
           switch (input1)
            {
             case 'E':   //Enter an integer
               System.out.print("Maximum n to compute (0 to quit)? ");
			   int max = Integer.parseInt(stdin.readLine().trim());
			   s.computeTo(max);
			   s.reportResults();
			   int percent = s.getCount() * 100/s.getMax();
			   System.out.println("\n% of primes = " + percent);

               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
          }
         else
          {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
   }


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "E\t\tEnter an integer\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}
