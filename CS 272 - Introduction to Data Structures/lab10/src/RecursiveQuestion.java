public class RecursiveQuestion {
	
	// prints the kth Fibonacci number
	// @param k the iteration in the Fibonacci sequence that will be printed
	// @return int the kth Fibonacci number
	public static int FibBinaryRecursive(int k) {
		
			if(k == 0) {
				return 0;
			}
			if(k == 1) {
				return 1;
			}
		
		return FibBinaryRecursive(k-1) + FibBinaryRecursive(k-2);
	}
	
	// solves the towers of Hanoi problem given n discs
	// @param src the source peg that all the discs start on
	// @param dest the destination peg that the discs will end on
	// @param temp the 3rd peg that will be utilized
	// @param n the number of discs on the source peg
	public static void HanoiTower(int src, int dest, int temp, int n) {
		
		if(n < 1) {
			throw new IllegalArgumentException();
		}
		
		if(n == 1) {
			System.out.println("Moved disc from peg " + src + " to peg " + dest);
		}
		
		else {
			HanoiTower(src, temp, dest, n-1);
			System.out.println("Moved disc from peg " + src + " to peg " + dest);
			HanoiTower(temp, dest, src, n-1);
		}
	}
	
	// prints the levels of each recursion call given L levels
	// @param L the number of levels to be called
	// @param curl the call it is currently on
	// @return String the output representing the the level of each call
	public static String showCallLevel(int L, int curl) {
		
		if(L < curl) {
			return "";
		}
		else {
			
			String space = "";
			for(int i = 1; i < curl; i++) {
				space = space + "  ";
			}
			return space + "This was written by call number " + curl + "x.\n" 
			+ showCallLevel(L, curl + 1) + space + 
			"This was written by call number " + curl + "y.\n";
		}
		
	}
	
	// converts and prints an integer into a binary number
	// @param n the number to be converted
	public static void BinaryPrint (int n) {
		
		if(n == 0) {
	        System.out.print("0");
	        return;
		}
		if(n > 0)
        {
            int x = n % 2;
            
            if(n/2 == 0) {
            	System.out.print(x);
            	return;
            }
            BinaryPrint(n/2);
            
            System.out.print(x);

        }

	}
	
	// generates a specific pattern with a given largest number of stars in a line
	// @param indent the number of indentations that the star will have
	// @param the number of stars in the longest line of the pattern
	public static void Pattern(int indent, int stars) {
		
		
	}
	
	// produces all the permutations of an array of integers
	// @param array the array of numbers that the permutations will be based on
	// @param prefixLen the number that will remain constant until all permutations
	//  with that factor are produced
	public static void Permutation(int array[], int prefixLen) {
		
		if(prefixLen == array.length) {
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
			}
			System.out.println();
		}
		
		if(prefixLen < array.length) {
			for(int i = prefixLen; i < array.length; i++) {
				int temp = array[prefixLen];
				array[prefixLen] = array[i];
				array[i] = temp;
				Permutation(array, prefixLen + 1);
				temp = array[i];
				array[i] = array[prefixLen];
				array[prefixLen] = temp;
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println("0th Fib Num = " + FibBinaryRecursive(0));
		System.out.println("1th Fib Num = " + FibBinaryRecursive(1));
		System.out.println("2th Fib Num = " + FibBinaryRecursive(2));
		System.out.println("3th Fib Num = " + FibBinaryRecursive(3));
		System.out.println("4th Fib Num = " + FibBinaryRecursive(4));
		System.out.println("5th Fib Num = " + FibBinaryRecursive(5));
		System.out.println("6th Fib Num = " + FibBinaryRecursive(6));
		
		HanoiTower(1,2,3,3);
		System.out.println();
		HanoiTower(1,2,3,4);
		
		System.out.println();
		System.out.println(showCallLevel(4, 1));
		System.out.println(showCallLevel(6, 1));
		
		System.out.println();
		BinaryPrint(0);
		System.out.println();
		BinaryPrint(4);
		System.out.println();
		BinaryPrint(27);
		System.out.println();
		BinaryPrint(13);
		
		
		// Since the output of an array of 10 is extremely large, this should be
		// 	tested separately
		/*System.out.println("\n");
		int[] array1 = new int[] {1};
		int[] array2 = new int[] {1, 2};
		int[] array3 = new int[] {1, 2, 3, 4, 5};
		int[] array4 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Permutation(array1, 0);
		System.out.println("\n");
		Permutation(array2, 0);
		System.out.println("\n");
		Permutation(array3, 0);
		System.out.println("\n");
		Permutation(array4, 0);
		*/
	}

}
