/**
 * This class is the main method to find the Catalan number recursively
 * and enter the data into the CatalanRecursiveFile.txt file
 * 
 * @author Divya Manirajan
 * @version Oct 29 2019
 * Recursion Project - Catalan Recursive
 * Fall Semester/2019
 */
//imports
import java.util.Scanner;
import java.io.*;

public class CatalanRecursive {
		public static void main (String [] args) throws IOException {
			Scanner scan = new Scanner(System.in); //creates a scanner called scan
			FileWriter CatRecFile = new FileWriter("CatalanRecursiveFile.txt"); //creates a FileWriter to write to CatalanRecursiveFile.txt
			String temp = ""; //temp holds value to check if another N will be entered 
			
			//do-while lasts until user stops entering Y or y for temp value
			do {
			System.out.println("What value would you like to use for N: ");
			int n = scan.nextInt(); //n holds the value used for the calculation
			long startRec = System.currentTimeMillis(); //startRec holds beginning time in milliseconds
			long resRec = value(n); //resRec holds the result of the Recursive catalan result with the entered value
			long endRec = System.currentTimeMillis(); //endRec holds end time in milliseconds
			long recTime = (endRec-startRec)/1000; //recTime holds time elapsed and converts to seconds
			if(recTime < 1) {
				recTime = 1;
			} //conditional to set recTime to 1 if it is less than 1
			//Displays values and results to screen
			System.out.println("C("+n+") = "+resRec);
			//Writes values and results to CatalanRecursiveFile.txt but will not display until sentinel loop closes
			CatRecFile.write(""+n+", "+resRec+", "+recTime/60+" minute(s) "+recTime%60+" second(s).");
			CatRecFile.write(System.lineSeparator()); //separates each value to a different line
			
			System.out.println("Would you like to enter another N and K? (Y/N):");
			temp = scan.next(); //temp holds value for continuing/ending loop
		}while(temp.equals("Y")||temp.equals("y"));
			//below lines occur when user signals they are done calculating Catalan numbers
			System.out.println("<END RUN>");
			CatRecFile.close(); //closes file and displays results in the file
		} //end main
		/**
		 * value returns the recursively calculated catalan number
		 * @param n the value of n that is sent to this method
		 * @return the catalan number calculated recursively
		 */
		public static long value(int n) {
			long result = 0;
			if(n<=1) {
				return 1;
			}
			else {
				for (int i = 0; i<n; i++) {
					result += value(i) * value(n-i-1);
				}

			}	
			return result;
		} //end value
} //end CatalanRecursive
