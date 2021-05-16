// Michael Torres
// CS 278
// Lab1
// 1/29/20
// Prints all possible truth tables for three propositional
// 	variables, p, q, and r

package lab1;
import java.util.Scanner;

class Lab1 {

	public static char charArray[] = { 'T', 'F'};
	public static boolean boolArray[] = { true, false};
	
	// converts a boolean to its corresponding char, T or F
	// @param in the boolean to be converted
	// @return char the corresponding char
	public char booleanToChar(boolean in) {
		
		if(in == true) {
			return 'T';
		}
		else {
			return 'F';
		}
	}
	
	// converts a char to its corresponding boolean, true or false
	// @param in the char to be converted
	// @return boolean the corresponding boolean
	public boolean charToBoolean(char in) {
		
		if(in == 'T') {
			return true;
		}
		if(in == 'F') {
			return false;
		}
		else {
			throw new IllegalArgumentException("Parameter must be 'T' or 'F'.");
		}
	}
	
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
				}
			}
		}
		return array;
	}
	public static void main(String args[]) {
		
		//System.out.println("hello World!");
		int count = 1;
		String array[] = buildTableRows();
		
		for(char a: charArray) {
			for(char b: charArray) {
				for(char c: charArray) {
					for(char d: charArray) {
						for(char e: charArray) {
							for(char f: charArray) {
								for(char g: charArray) {
									for(char h: charArray) {
										
										char lastCol[] = {a, b, c, d, e, f, g, h};
										System.out.println("Truth Table " + count);
										System.out.println("p  q  r  proposition");
										System.out.println("-- -- -- -----------");
										for(int i = 0; i < array.length; i++) {
											System.out.println(array[i] + lastCol[i]);
										}
										System.out.println();
										count++;
									} // end for h
								} // end for g
							} // end for f
						} // end for e
					} // end for d
				} // end for c
			} // end for b
		} // end for a
	}
}
