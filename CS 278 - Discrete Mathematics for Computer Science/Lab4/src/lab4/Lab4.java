// Michael Torres
// CS 278
// Lab4
// 2/19/20
// Disproves a statement by finding a counterexample.
//	The statement is Every odd number x, such that x>= 3
//	can be written as the sum of a prime number and twice a square.
//  Domain: All odd integers greater than or equal to 3.

package lab4;

public class Lab4 {

	public static boolean isPrime(int num) {
		// Negative numbers up to positive 1 are not prime
		if(num <= 1) {
			return false;
		}
		// Since 1 is checked, we start at 2
		//	(loop checks for i to be bigger than 2, so if num is
		//		is 2, it won't go through the loop.)
		for(int i = 2; i < num; i++) {
			if((num % i) == 0) {
				return false;
			} // end if
		} // end for
		return true;
	} // end isPrime
	
	public static int[] buildSquareArray() {
		int[] array = new int[100];
		for(int i = 0; i < array.length; i++) {
			array[i] = i * i;
		} // end for
		return array;
	} // end buildSquareArray
	
	public static void main(String[] args) {
		
		int x, p;
		boolean hold = false;
		int[] array = buildSquareArray();
		for(x = 3; x < 10000; x = x + 2) {
			for(int i = 0; i < array.length || i > (x/2); i++) {
				p = x - 2*array[i];
				if(isPrime(p)) {
					hold = true;
					break;
				} // end if
				else {
					hold = false;
				} // end else
			} // end for i
			if(!hold) {
				break;
			} // end if
		} // end for x
		if(x < 10000) {
			System.out.println("A counterexample for this statement" +
					" was found at x = " + x + ".");
		} //end if
		else {
			System.out.println("No counterexample was found.");
		} // end else

	} // end main

} // end Lab4
