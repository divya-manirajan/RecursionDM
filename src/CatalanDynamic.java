/**
 * This class is the main method to find the Catalan number dynamically
 * and enter the data into the CatalanDynamicFile.txt file
 * 
 * @author Divya Manirajan
 * @version Oct 29 2019
 * Recursion Project - Catalan Dynamic
 * Fall Semester/2019
 */
//imports
import java.io.*;
import java.util.Scanner;

public class CatalanDynamic {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in); //creates a scanner called scan
		FileWriter CatDynFile = new FileWriter("CatalanDynamicFile.txt"); //creates a FileWriter to write to CatalanDynamicFile.txt
		String temp = ""; //temp holds value to check if another N will be entered
		
		//do-while lasts until user stops entering Y or y for temp value
		do {
		System.out.println("What value would you like to use for N: ");
		int n = scan.nextInt(); //n holds the value used for the calculation
		long startDyn = System.currentTimeMillis();	//startDyn holds beginning time in milliseconds			
		long resDyn = value(n); //resDyn holds the result of the dynamic catalan result with the entered value
		long endDyn = System.currentTimeMillis(); //endDyn holds end time in milliseconds
		long dynTime = (endDyn-startDyn)/1000; //dynTime holds time elapsed and converts to seconds
		if(dynTime < 1) {
			dynTime = 1;
		} //conditional to set dynTime to 1 if it is less than 1
		//Displays values and result to screen
		System.out.println("C("+n+") = "+resDyn);
		//Writes values to CatalanDynamicFile.txt but will not display until sentinel loop closes
		CatDynFile.write(""+n+", "+resDyn+", "+dynTime/60+" minute(s) "+dynTime%60+" second(s).");
		CatDynFile.write(System.lineSeparator()); //separates each value to a different line
		
		System.out.println("Would you like to enter another N and K? (Y/N):");
		temp = scan.next(); //temp holds value for continuing/ending loop
	}while(temp.equals("Y")||temp.equals("y"));
		//below lines occur when user signals they are done calculating Catalan numbers
		System.out.println("<END RUN>");
		CatDynFile.close(); //closes file and displays results in the file
		
}//end main
	/**
	 * value returns the dynamically calculated catalan number
	 * @param n the value of n that is sent to this method
	 * @return the catalan number calculated dynamically
	 */
	public static long value(int n) {
		long array [] = new long [n+2];
		array[0] = 1;
		array[1] = 1;
		
		for(int i = 2; i<=n; i++) {
			array[i] = 0;
			for(int j = 0; j<i; j++) {
				array[i] += array[j] * array[i-j-1];
			}
		}
		return array[n];
	}//end value

}//end CatalanDynamic
