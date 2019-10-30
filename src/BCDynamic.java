/**
 * This class is the main method to find the Binomial Coefficient 
 * Dynamically and enter the data into the BCDynamicFile.txt file
 * 
 * @author Divya Manirajan
 * @version Oct 29 2019
 * Recursion Project - Binomial Coefficient Dynamic
 * Fall Semester/2019
 */
//imports
import java.io.*;
import java.util.Scanner;

public class BCDynamic {
	public static void main(String [] args)throws IOException {
		Scanner scan = new Scanner(System.in); //creates a scanner called scan
		FileWriter BCDynFile = new FileWriter("BCDynamicFile.txt"); //creates a FileWriter to write to BCDynamicFile.txt
		String temp = ""; //temp holds value to check if another N and K will be entered
		
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
			long startDyn = System.currentTimeMillis();	//startDyn holds beginning time in milliseconds		
			long resDyn = value(n, k); //resDyn holds the result of the dynamic binomial coefficient with the entered n and k values
			long endDyn = System.currentTimeMillis(); //endDyn holds end time in milliseconds
			long dynTime = (endDyn-startDyn)/1000; //dynTime holds time elapsed and converts to seconds
			if(dynTime < 1) {
				dynTime = 1;
			}//conditional to set dynTime to 1 if it is less than 1
		//Displays values and result to screen
		System.out.println("There are "+resDyn+" ways to choose "+k+" subsets from "+n+" items.");
		//Writes values to BCDynamicFile.txt but will not display until sentinel loop closes 
		BCDynFile.write(""+n+", "+k+", "+resDyn+", "+dynTime/60+" minute(s) "+dynTime%60+" second(s).");
		BCDynFile.write(System.lineSeparator()); //separates each value to a different line
		}
		System.out.println("Would you like to enter another N and K? (Y/N):");
		temp = scan.next(); //temp holds value for continuing/ending loop
	}while(temp.equals("Y")||temp.equals("y"));
		//below lines occur when user signals they are done calculating binomial coefficients
		System.out.println("<END RUN>");
		BCDynFile.close(); //closes file and displays results in the file
		
		
	}//end main
	/**
	 * min is used in value to return the lowest of 2 numbers
	 * @param a the first number passed into method
	 * @param b the second number passed into method
	 * @return the lowest of the 2 numbers
	 */
	public static int min(int a, int b) {
		if(a<b)
			return a;
		else
			return b;
	}//end min
	/**
	 * value returns the dynamically calculated binomial coefficient 
	 * @param n the value of n that is sent to this method
	 * @param k the value of k that is sent to this method
	 * @return the binomial coefficient calculated dynamically 
	 */
	public static long value(int n, int k) {
		long array [] [] = new long [n+1] [k+1];
		
		for(int i = 0; i<= n; i++) {
			for(int j = 0; j <= min(i,k); j++) {
				if(j==0 || j==i ) {
					array[i][j] = 1;
				}
				else {
					array[i][j] = array[i-1][j-1] + array[i-1][j];
				}
			}
		}
		return array[n][k];
	}//end value
}//end BCDynamic
