// Michael Torres
// CS 278
// Lab2
// 2/6/20
// Evaluates and prints truth tables for different compound
//	propositions and determines if they are tautologies 
//	or contradictions

package lab2;

public class Lab2 {

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
	
	public static void main(String args[]) {
	
		String[] rows = buildTableRows();
		char p, q, r, ans;
		int tCount = 0;
		System.out.println("p  q  r  Proposition 1");
		System.out.println("-- -- -- -------------");
		
		// Prints prop 1's truth table
		for(int i = 0; i < rows.length; i++) {
			System.out.print(rows[i]);
			p = rows[i].charAt(0);
			q = rows[i].charAt(3);
			r = rows[i].charAt(6);
			ans = and((implies(not(p), q)), implies(r, p));
			System.out.print(ans + "\n");
			if(ans == 'T') {
				tCount++;
			} // end if
		} // end for (prop 1)
		System.out.println("\n" + tCount +
				" combinations result in proposition 1 being T.");
		System.out.println((8 - tCount) + 
				" combinations result in proposition 1 being F.");
		if(tCount == 8) {
			System.out.println("Proposition 1 is a tautology.\n");
		} // end if
		if(tCount == 0) {
			System.out.println("Proposition 1 is a contradiction.\n");
		} // end if
		if(tCount != 8 && tCount != 0) {
			System.out.println("Proposition 1 is neither a tautology nor a contradiction.\n");
		} // end if
		
		
		// Prints prop 2's truth table
		tCount = 0;
		System.out.println("p  q  r  Proposition 2");
		System.out.println("-- -- -- -------------");
		
		for(int i = 0; i < rows.length; i++) {
			System.out.print(rows[i]);
			p = rows[i].charAt(0);
			q = rows[i].charAt(3);
			r = rows[i].charAt(6);
			ans = and(or(p, not(q)), or(r, not(implies(p, q))));
			System.out.print(ans + "\n");
			if(ans == 'T') {
				tCount++;
			} // end if
		} // end for (prop 2)
		System.out.println("\n" + tCount +
				" combinations result in proposition 2 being T.");
		System.out.println((8 - tCount) + 
				" combinations result in proposition 2 being F.");
		if(tCount == 8) {
			System.out.println("Proposition 2 is a tautology.\n");
		} // end if
		if(tCount == 0) {
			System.out.println("Proposition 2 is a contradiction.\n");
		} // end if
		if(tCount != 8 && tCount != 0) {
			System.out.println("Proposition 2 is neither a tautology nor a contradiction.\n");
		} // end if
		
		// Prints prop 3's truth table
		tCount = 0;
		System.out.println("p  q  r  Proposition 3");
		System.out.println("-- -- -- -------------");
		
		for(int i = 0; i < rows.length; i++) {
			System.out.print(rows[i]);
			p = rows[i].charAt(0);
			q = rows[i].charAt(3);
			r = rows[i].charAt(6);
			ans = implies(p, (implies(not(or(p, not(q))), and(p, q))));
			System.out.print(ans + "\n");
			if(ans == 'T') {
				tCount++;
			} // end if
		} // end for (prop 3)
		System.out.println("\n" + tCount +
				" combinations result in proposition 3 being T.");
		System.out.println((8 - tCount) + 
				" combinations result in proposition 3 being F.");
		if(tCount == 8) {
			System.out.println("Proposition 3 is a tautology.\n");
		} // end if
		if(tCount == 0) {
			System.out.println("Proposition 3 is a contradiction.\n");
		} // end if
		if(tCount != 8 && tCount != 0) {
			System.out.println("Proposition 3 is neither a tautology nor a contradiction.\n");
		} // end if
		
		// Prints prop 4's truth table
		tCount = 0;
		System.out.println("p  q  r  Proposition 4");
		System.out.println("-- -- -- -------------");
		
		for(int i = 0; i < rows.length; i++) {
			System.out.print(rows[i]);
			p = rows[i].charAt(0);
			q = rows[i].charAt(3);
			r = rows[i].charAt(6);
			ans = and(and(p, implies(p,q)), not(q));
			System.out.print(ans + "\n");
			if(ans == 'T') {
				tCount++;
			} // end if
		} // end for
		System.out.println("\n" + tCount +
				" combinations result in proposition 4 being T.");
		System.out.println((8 - tCount) + 
				" combinations result in proposition 4 being F.");
		if(tCount == 8) {
			System.out.println("Proposition 4 is a tautology.\n");
		} // end if
		if(tCount == 0) {
			System.out.println("Proposition 4 is a contradiction.\n");
		} // end if
		if(tCount != 8 && tCount != 0) {
			System.out.println("Proposition 4 is neither a tautology nor a contradiction.\n");
		} // end if
	} // end main
} // end class Lab2