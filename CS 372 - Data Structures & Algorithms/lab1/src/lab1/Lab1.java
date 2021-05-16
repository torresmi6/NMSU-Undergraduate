package lab1;

public class Lab1 {

	public static void main(String[] args) {
		
		// Test functions
		//testFib1();
		//testFib2();
		
		// Runtime Data
		int x;
		long y, z;
		
		for(int i = 0; i < 51; i++) {
			
		y = System.nanoTime();
		x = fib1(i);
		z = System.nanoTime();
		System.out.println((z - y));
		}
	}
	
	public static int fib1(int n) {
		
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		return fib1(n-1) + fib1(n-2);
	}
	
	public static int fib2(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		
		int[] array = new int[n+1];
		array[0] = 0;
		
		array[1] = 1;

		
		for(int i = 2; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n];
	}
	
	public static void testFib1() {
		
		int[] answer = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
		
		for(int i = 0; i < 10; i++) {
			if(answer[i] != fib1(i)) {
				System.out.println("fib1 FAILED");
				return;
			}
		}
		System.out.println("fib1 PASSED");
		return;
	}
	
	public static void testFib2() {
		
		int[] answer = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
		
		for(int i = 0; i <= 10; i++) {
			if(answer[i] != fib2(i)) {
				System.out.println("fib2 FAILED");
				return;
			}
		}
		System.out.println("fib2 PASSED");
		return;
	}

}
