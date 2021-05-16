package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lab3 {

	int[][][] H = new int[11][8][5];
	int[][][][] B = new int[11][8][5][3];
	int a = 0;
	
	public void pouring(int c1, int c2, int c3, int c4, int c5, int c6) {
		
		H[c4][c5][c6] = 2;
		H[c1][c2][c3] = 1;
		if(H[c1][c2][c3] == 2) return;
		
		//c1 to c2
		a = Math.min(7-c2, c1);
		if(H[c1-a][c2+a][c3] != 1) {
			H[c1-a][c2+a][c3] = 1;
			if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] == 0) {
				B[c1-a][c2+a][c3][0] = c1;
				B[c1-a][c2+a][c3][1] = c2;
				B[c1-a][c2+a][c3][2] = c3;
			}
			pouring(c1-a, c2+a, c3, c4, c5, c6);
		}
		
		//c2 to c1
		a = Math.min(10-c1, c2);
		if(H[c1+a][c2-a][c3] != 1) {
			H[c1+a][c2-a][c3] = 1;
			if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] == 0) {
				B[c1+a][c2-a][c3][0] = c1;
				B[c1+a][c2-a][c3][1] = c2;
				B[c1+a][c2-a][c3][2] = c3;
			}
			pouring(c1+a, c2-a, c3, c4, c5, c6);
		}
		//c1 to c3
		a = Math.min(4-c3, c1);
		if(H[c1-a][c2][c3+a] != 1) {
			H[c1-a][c2][c3+a] = 1;
			if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] == 0) {
				B[c1-a][c2][c3+a][0] = c1;
				B[c1-a][c2][c3+a][1] = c2;
				B[c1-a][c2][c3+a][2] = c3;
			}
			pouring(c1-a, c2, c3+a, c4, c5, c6);
		}
		//c3 to c1
		a = Math.min(10-c1, c3);
		if(H[c1+a][c2][c3-a] != 1) {
			H[c1+a][c2][c3-a] = 1;
			if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] == 0) {
				B[c1+a][c2][c3-a][0] = c1;
				B[c1+a][c2][c3-a][1] = c2;
				B[c1+a][c2][c3-a][2] = c3;
			}
			pouring(c1+a, c2, c3-a, c4, c5, c6);
		}
		//c2 to c3
		a = Math.min(4-c3, c2);
		if(H[c1][c2-a][c3+a] != 1) {
			H[c1][c2-a][c3+a] = 1;
			if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] == 0) {
				B[c1][c2-a][c3+a][0] = c1;
				B[c1][c2-a][c3+a][1] = c2;
				B[c1][c2-a][c3+a][2] = c3;
			}
			pouring(c1, c2-a, c3+a, c4, c5, c6);
		}
		//c3 to c2
		a = Math.min(7-c2, c3);
		if(H[c1][c2+a][c3-a] != 1) {
			H[c1][c2+a][c3-a] = 1;
			if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] == 0) {
				B[c1][c2+a][c3-a][0] = c1;
				B[c1][c2+a][c3-a][1] = c2;
				B[c1][c2+a][c3-a][2] = c3;
			}
			pouring(c1, c2+a, c3-a, c4, c5, c6);
		}
		
	}
	
	public void backTrack(int c1, int c2, int c3, int c4, int c5, int c6) {
		
		//If the target has no back track, the pouring was not successful
		if(B[c4][c5][c6][0] == 0 && B[c4][c5][c6][1] == 0 && B[c4][c5][c6][2] ==0) {
			System.out.println("No sequence of pourings from (" + c1 + ", " +
					c2 + ", " + c3 + ") to (" + c4 + ", " + c5 + ", " + c6 + ")");
			return;
		}
		
		// Use backtrack array to follow the path from target to source and store them
		// Reverse the order and print
		int temp4;
		int temp5;
		int temp6;
		String bucket = "";
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("(" + c4 + "," + c5 + "," + c6 + ")");
		
		while(!(c4 == c1 && c5 == c2 && c6 == c3)) {// && !(B[temp4][temp5][temp6][0] == 0 && B[temp4][temp5][temp6][1] == 0 && B[temp4][temp5][temp6][2] == 0)) {
			
			temp4 = c4;
			temp5 = c5;
			temp6 = c6;
		
			bucket = "(" + B[c4][c5][c6][0] + "," + B[c4][c5][c6][1] + "," + B[c4][c5][c6][2] + ")";
			ans.add(bucket);
			c4 = B[temp4][temp5][temp6][0];
			c5 = B[temp4][temp5][temp6][1];
			c6 = B[temp4][temp5][temp6][2];
			
		}
		
		 Collections.reverse(ans);
		 System.out.println(ans.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lab3 test = new Lab3();
		
		System.out.println("\nTest Case (0, 7, 4) to (2, 7, 2):");
		test.pouring(0, 7, 4, 2, 7, 2);
		test.backTrack(0, 7, 4, 2, 7, 2);
		test = new Lab3();
		
		System.out.println("\nTest Case (10, 0, 4) to (2, 7, 2):");
		test.pouring(10,  0,  4,  2,  7,  2);
		test.backTrack(10,  0,  4,  2,  7,  2);
		test = new Lab3();
		
		System.out.println("\nTest Case (8, 6, 3) to (7, 6, 4):");
		test.pouring(8,  6,  3,  7,  6,  4);
		test.backTrack(8,  6,  3,  7,  6,  4);
		test = new Lab3();
		
		System.out.println("\nTest Case (1, 7, 4) to (3, 6, 2):");
		test.pouring(1,  7,  4,  3,  6,  2);
		test.backTrack(1,  7,  4,  3,  6,  2);
		test = new Lab3();
		
		System.out.println("\nTest Case (2, 7, 4) to (3, 6, 2):");
		test.pouring(2,  7,  4,  3,  6,  2);
		test.backTrack(2,  7,  4,  3,  6,  2);
		test = new Lab3();
		
		System.out.println("\nTest Case (6, 3, 3) to (3, 6, 3):");
		test.pouring(6,  3,  3,  3,  6,  3);
		test.backTrack(6,  3,  3,  3,  6,  3);
	}

}
