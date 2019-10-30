/**
 * This class is the main method to find the Binomial Coefficient 
 * Recursively and enter the data into the BCRecursiveFile.txt file
 * 
 * @author Divya Manirajan
 * @version Oct 29 2019
 * Recursion Project - Binomial Coefficient Recursive
 * Fall Semester/2019
 */
//imports
import java.util.Scanner;
import java.io.*;
public class BCRecursive {
	public static void main(String [] args) throws IOException {
		Scanner scan = new Scanner(System.in); //creates a scanner called scan
		FileWriter BCRecFile = new FileWriter("BCRecursiveFile.txt");//creates a FileWriter to write to BCRecursiveFile.txt
		String temp = "";//temp holds value to check if another N and K will be entered
		
		//do-while lasts until user stops entering Y or y for entering values
		do {
		System.out.println("What value would you like to use for N: ");
		int n = scan.nextInt(); //n holds number of items
		System.out.println("What value would you like to use for K: ");
		int k = scan.nextInt(); //k holds size of subsets
		
		//conditional checks if n and k values are applicable
		if(k>n) {
			System.out.println("N and K values do not work");
			System.out.println("N must be greater than or equal to K");
		}
		else {
			long startRec = System.currentTimeMillis();	 //startRec holds beginning time in milliseconds		
			long resRec = value(n, k); //resRec holds the result of the recursive binomial coefficient with the entered values
			long endRec = System.currentTimeMillis(); //endRec holds the end time in milliseconds
			long recTime = (endRec-startRec)/1000; //recTime holds time elapsed and converts to seconds
			if(recTime < 1) {
				recTime = 1;
			} //conditional to set recTime to 1 if it is less than 1
		//Displays values and result to screen
		System.out.println("There are "+resRec+" ways to choose "+k+" subsets from "+n+" items.");
		//Writes values to BCRecursiveFile.txt but will not display until sentinel loop closes 
		BCRecFile.write(""+n+", "+k+", "+resRec+", "+recTime/60+" minute(s) "+recTime%60+" second(s).");
		BCRecFile.write(System.lineSeparator()); //separates each value to a different line
		}
		System.out.println("Would you like to enter another N and K? (Y/N):");
		temp = scan.next(); //temp holds value for continuing/ending loop
	}while(temp.equals("Y")||temp.equals("y"));
		//below lines occur when user signals they are done calculating binomial coefficients
		System.out.println("<END RUN>");
		BCRecFile.close(); //closes file and displays results in the file
		
}//end main
	/**
	 * value returns the recursively calculated binomial coefficient 
	 * @param n the value of n that is sent to this method
	 * @param k the value of k that is sent to this method
	 * @return the binomial coefficient calculated recursively 
	 */
	public static long value(int n, int k) {
		if(k==0||k==n) {
			return 1;
		}
		else {
			return value(n-1, k-1)+ value(n-1, k);
		}
	}//end value
}//end BCRecursive
