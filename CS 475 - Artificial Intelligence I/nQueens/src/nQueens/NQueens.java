// Michael Torres
// Warm Up
// 2-2-21
// Provides a solution (if it exists) for n queens problem with input n

package nQueens;

import java.util.ArrayList;

public class NQueens {

	// input n: size of chess board n x n
	// output: prints solution if exists
	public static void nQueens(int n) {
		// current holds the current board state to be checked
		// possible holds all the remaining possible solutions
		Integer [] current = new Integer[n];
		ArrayList<ArrayList<Integer>> possible = new ArrayList<ArrayList<Integer>>();
		
		// the element refers to the row number (1 through n). If zero, the column is undefined
		// {1, u, u, u} is equivalent to {1, 0, 0, 0}
		for(int i = 1; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			for(int a = 0; a < n-1; a++) {
				temp.add(0);
			}
			possible.add(temp);
		}
		
		while(!possible.isEmpty()) {
			//System.out.println(possible.toString());
			// keeps track of column position of current board, to add new possibilities
			int count = 0;
			current = possible.get(possible.size() - 1).toArray(current);
			possible.remove(possible.size() - 1);
			if(checkAttack(current)) {
				continue;
			}
		
			// If the last element is not a zero, the solution is complete
			if(current[n-1] != 0) {
				System.out.print("Solution: [");
				for(int s = 0; s < n; s++) {
					System.out.print(current[s] + ", ");
				}
				System.out.println("]");
				return;
			}
		
			for(int b = 0; b < n; b++) {
				if(current[b] == 0) {
					count++;
				}
			}
			
			// Create new possibilities based of current accepted board state and add them to end of possible list
			for(int d = 1; d <= n; d++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				for(int p = 0; p < (n - count); p++) {
					temp.add(current[p]);
				}
				temp.add(d);
				for(int a = 0; a < count-1; a++) {
					temp.add(0);
				}
				possible.add(temp);
			}
		}
		System.out.println("No Solution");
	}
	
	// Checks if any queens can attack each other. Returns true if queens are in danger, false if not
	public static boolean checkAttack(Integer[] current) {

		for(int i = 0; i < current.length; i++) {
			for(int a = i+1; a < current.length; a++) {
				
				if(current[i] != 0 && current[a] != 0) {
					// Check rows
					if(current[i] == current[a]) {
						return true;
					}
					// Check diagonals
					if(Math.abs(((double)current[a].intValue() - (double)current[i].intValue()) / ((a+1) - (i+1))) == 1) {
						//Testing diagonal checker with slope
						//System.out.println("HIT a = " + a + " i = " + i + " ay = " + current[a] + " iy = " + current[i]);
						return true;
					}
				}
			}
		}
		
		// If not returned true by now, no attacks possible
		return false;
	}
	
	public static void main(String[] args) {

		// Each call will print a statement with solution or no solution
		// Test Cases - all have solutions except for 2 and 3
		nQueens(1);
		nQueens(2);
		nQueens(3);
		nQueens(4);
		nQueens(5);
		nQueens(6);
		nQueens(7);
	}

}
