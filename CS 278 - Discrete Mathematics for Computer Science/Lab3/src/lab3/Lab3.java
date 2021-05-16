// Michael Torres
// CS 278
// Lab3
// 2/12/20
// Inputs ten (non-duplicate) integers into an array.
//	Then uses the array to determine the truth value of 4 statements

package lab3;
import java.util.*;
public class Lab3 {

	public static char charArray[] = { 'T', 'F'};
	public static boolean boolArray[] = { true, false};
	
	// converts a boolean to its corresponding char, T or F
	// @param in the boolean to be converted
	// @return char the corresponding char
	public static char booleanToChar(boolean in) {
		
		if(in == true) {
			return 'T';
		} // end if
		else {
			return 'F';
		} // end else
	} // end booleanToChar
	
	// converts a char to its corresponding boolean, true or false
	// @param in the char to be converted
	// @return boolean the corresponding boolean
	public static boolean charToBoolean(char in) {
		
		if(in == 'T') {
			return true;
		} // end if
		if(in == 'F') {
			return false;
		} // end if
		else {
			throw new IllegalArgumentException("Parameter must be 'T' or 'F'.");
		} // end else
	} // end charToBoolean
	
	// Builds a truth table's first three columns assuming 3 variables
	// @param none
	// @return String[] the array with the rows of the table
	public static String[] buildTableRows() {
		
		String array[] = new String[8];
		int count = 0;
		
		for(char x: charArray) {
			for(char y: charArray) {
				for(char z: charArray) {
					array[count] = x + "  " + y + "  " + z + "  ";
					count++;
				} // end for z
			} // end for y
		} // end for x
		return array;
	} // end buildTableRows
	
	// Changes the truth value to its opposite value
	// @param c the input truth value T or F
	// @return char the opposite of the given truth value
	public static char not(char c) {
		
		char ans = '\0';
		try {
			
			boolean ansB = charToBoolean(c);
			
			if(ansB == true) {
				ansB = false;
			} // end if
			else {
				ansB = true;
			} // end else
			ans = booleanToChar(ansB);
			return ans;
		} // end try
		catch(IllegalArgumentException e){
			System.out.println("Character must be 'T' or 'F'");
		} // end catch
		
		return ans;
	} // end not
	
	// The or proposition returns T (true) if at least one of the variables is true
	//	returns F (false) for other cases
	// @param c1 the variable on the left of the or proposition
	// @param c2 the variable on the right of the or proposition
	// @return char the evaluated truth value
	public static char or(char c1, char c2) {
		
		if((c1 == 'T' || c1 == 'F') && (c2 == 'T' || c2 == 'F')) {

			char ans;
			if(c1 == 'T' || c2 == 'T') {
				ans = 'T';
			} // end if
			else {
				ans = 'F';
			} // end else
			return ans;
		} // end if
		else {
			throw new IllegalArgumentException("Parameter must be 'T' or 'F'");
		} // end else
	} // end or
	
	// The and proposition returns T only if both variables are true
	//	returns F for other cases
	// @param c1 the variable on the left of the and proposition
	// @param c2 the variable on the right of the and proposition
	// @return char the evaluated truth value
	public static char and(char c1, char c2) {
		
		if((c1 == 'T' || c1 == 'F') && (c2 == 'T' || c2 == 'F')) {
		
			char ans;
			if(c1 == 'T' && c2 == 'T') {
				ans = 'T';
			} // end if
			else {
				ans = 'F';
			} // end else
			return ans;
			} // end if
		else {
			throw new IllegalArgumentException("Parameter must be 'T' or 'F'");
		} // end else
	} // end and
	
	// The implies proposition returns F only if the left variable is true and the right variable is false
	//	returns T for other cases
	// @param c1 the variable on the left of the implies proposition
	// @param c2 the variable on the right of the implies proposition
	// @return char the evaluated truth value
	public static char implies(char c1, char c2) {
		
		if((c1 == 'T' || c1 == 'F') && (c2 == 'T' || c2 == 'F')) {
			
			char ans;
			if(c1 == 'T' && c2 == 'F') {
				ans = 'F';
			} // end if
			else {
				ans = 'T';
			} // end else
			return ans;
		} // end if
		
		else {
			throw new IllegalArgumentException("Parameter must be 'T' or 'F'");
		} // end else
	} // end implies
	
	// Uses the input array to check if it satisfies
	// 	For all x ( if x < 0 then x is even )
	// @param array the array used to check the statement
	// @return boolean true if satisfied, false if not
	public static boolean statementA(int[] array) {
		
		for(int x: array) {
			if(x < 0 && (x % 2 != 0)) {
				return false;
			} // end if
		} // end for each
		return true;
	} // end statementA
	
	// Uses the input array to check if it satisfies
	// 	There exists x ( if x < 0 then x is even )
	// @param array the array used to check the statement
	// @return boolean true if satisfied, false if not	
	public static boolean statementB(int[] array) {
		
		for(int x: array) {
			if(x > 0 || (x < 0 && x % 2 == 0)) {
				return true;
			} // end if
		} // end for each
		return false;
	} // end statementB
	
	// Uses the input array to check if it satisfies
	// 	There exists x ( x < 0 and x is even )
	// @param array the array used to check the statement
	// @return boolean true if satisfied, false if not
	public static boolean statementC(int[] array) {
		
		for(int x: array) {
			if(x < 0 && (x % 2 == 0)) {
				return true;
			} // end if
		} // end for each
		return false;
	} // end statementC
	
	// Uses the input array to check if it satisfies
	// 	For all x ( ( x - 1 ) % 3 == 0 or ( x - 1 ) % 2 == 0 )
	// @param array the array used to check the statement
	// @return boolean true if satisfied, false if not
	public static boolean statementD(int[] array) {
		
		for(int x: array) {
			if(((x-1) % 3 != 0) && ((x-1) % 2 != 0)) {
				return false;
			} // end if
		} // end for each
		return true;
	} // end statementD
	
	public static void main(String args[]) {
	
		int array[] = new int[10];
		Scanner scan = new Scanner(System.in);
		
		// Gets input and stores in array
		System.out.println("Please enter 10 different integers:");
		for(int i = 0; i < 10; i++) {
			array[i] = scan.nextInt();
		} // end for
		
		// Calls all statement functions
		System.out.println("a) is " + statementA(array));
		System.out.println("b) is " + statementB(array));
		System.out.println("c) is " + statementC(array));
		System.out.println("d) is " + statementD(array));
	} /// end main
} //end Lab3
