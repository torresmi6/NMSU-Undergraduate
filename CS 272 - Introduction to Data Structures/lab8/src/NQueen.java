import java.util.*;

public class NQueen {

	public static void printStack(int size, Object obj) {
		if(obj instanceof ArraylistStack == false) {
			throw new IllegalArgumentException();
		}
		else {
		StackInterface<Integer> stack = (ArraylistStack)obj;
		int num;
		for(int x = 0; x < size; x++) {
			num = stack.pop();
		
			for(int i = 1; i <= size; i++) {

				if(i == num) {
					System.out.print("Q ");
				}	
				else {
					System.out.print("- ");
				}
			}
			System.out.println(num);
			System.out.println();
			
		}
		}
	}
	
	public static boolean checkConflict(int position, Object obj) {
		
		StackInterface <Integer> temp = new ArraylistStack();
		int rowDif = 0, colDif = 0;
		
		if(obj instanceof ArraylistStack == false) {
			throw new IllegalArgumentException();
		}
		else {
		StackInterface<Integer> stack = (ArraylistStack)obj;
		
		while(stack.isEmpty() == false) {
			temp.push(stack.pop());
			rowDif++;
			if(stack.isEmpty() == true) {
				break;
			}
			colDif = position - stack.top();
			if(colDif == 0) {
				for(int x = 0; x < rowDif; x++) {
					stack.push(temp.pop());
				}
				return true;
			}
			if(colDif == rowDif) {
				for(int x = 0; x < rowDif; x++) {
					stack.push(temp.pop());
				}
				return true;
			}
			
		}
		for(int x = 0; x < rowDif; x++) {
			stack.push(temp.pop());
		}
		return false;
		}
	}
	
	public static void nQueens(int n) {
		
		boolean conflict = false;
		int qPos = 1, colID = 1, rowID = 1;
		StackInterface <Integer> s = new ArraylistStack();
		
		while(s.size() < n) {

			while(qPos <= n) {
				
				conflict = checkConflict(qPos, s);
				
				if(conflict == false) {

					s.push(qPos);
					System.out.println(s.top());
					qPos = 1;
					colID = 1;
					rowID = s.size() + 1;
					System.out.println(s.size());
				}
				else {
					qPos++;
					colID++;
					if(colID > n) {
						while(s.isEmpty() == false && colID > n) {
							s.pop();
							rowID--;
							qPos = colID = s.top();
							
						}	
					qPos++;
					colID++;
					}
				}

				
				if(colID > n) {
					break;
				}
				if(rowID > n) {
					break;
				}
				if(s.size() > n) {
					break;
				}
			}
		}
		printStack(n, s);
	}
	public static void main(String[] args) {

		nQueens(5);
	}

}
