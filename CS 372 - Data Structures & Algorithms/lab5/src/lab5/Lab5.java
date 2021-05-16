package lab5;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lab5 {

	public static int max(int x, int y) {
		if(x > y) {
			return x;
		}
		else {
			return y;
		}
	}
	public static void knapSackDp(int[] S, int[] V, int M){
		
		int itmCnt = S.length;
		int table[][] = new int[itmCnt + 1][M + 1];
		
		for (int i = 0; i <= itmCnt; i++) { 
            for (int x = 0; x <= M; x++) { 
                if (i == 0 || x == 0) 
                    table[i][x] = 0; 
                else if (S[i - 1]<= x) 
                    table[i][x] = max(V[i - 1] + table[i - 1][x - S[i - 1]], table[i - 1][x]); 
                else
                    table[i][x] = table[i - 1][x]; 
            } 
        }
		
		int ans = table[itmCnt][M], ansCpy = table[itmCnt][M];
		int weightCopy = M;
		int count = 1;
		
		if(ans == 0) {
			System.out.println("No item was chosen");
			return;
		}
		for (int i = itmCnt; i > 0 && ans > 0; i--) { 
            if (ans == table[i - 1][weightCopy]) {
            }
            else { 
                System.out.println("Item " + count + ": W = " + S[i - 1] + ", V = " + V[i-1]); 
                count++;
                ans = ans - V[i - 1]; 
                weightCopy = weightCopy - S[i - 1]; 
            } 
        }
		System.out.println("were chosen and the total value is " + ansCpy + ".\n");
		
	}
	
	public static void knapSackGa(int[] S, int[] V, int M){
		
		//HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		ArrayList<Item> items = new ArrayList<Item>();
		for(int i = 0; i < S.length; i++) {
			//map.put(V[i], S[i]);
			items.add(new Item(S[i], V[i]));
		}
		
		Collections.sort(items, new ItemValueComparator());
		
		int count = 1;
		int currentCap = 0;
		int index = items.size() - 1;
		int tempW, totalV = 0;
		
		while(index > -1 && currentCap < M) {
			
			tempW = items.get(index).getWeight();
			if(tempW <= (M - currentCap)) {
				System.out.println("Item " + count + ": W = " + tempW + ", V = " + V[index]);
				count++;
				currentCap = currentCap + tempW;
				totalV = totalV + V[index];
			}
			index--;
		}
		
		if(currentCap == 0) {
			System.out.println("No items were chosen\n");
		}
		else {
			System.out.println("were chosen and the total value is " + totalV + "\n");
		}
	}
	
	public static void test() {
		
		// Test 1
		System.out.println("Test 1 - Dynamic");
		int[] W = {4, 5, 7};
		int[] V = {2, 3, 4};
		int M = 10;
		knapSackDp(W, V, M);
		System.out.println("Test 1 - Greedy");
		knapSackGa(W,V, M);
		
		// Test 2
		System.out.println("Test 2 - Dynamic");
		int[] W2 = {6, 5, 7, 3, 1};
		int[] V2 = {7, 3, 4, 4, 3};
		int M2 = 13;
		knapSackDp(W2, V2, M2);
		System.out.println("Test 2 - Greedy");
		knapSackGa(W2,V2,M2);
		
		// Test 3
		System.out.println("Test 3 - Dynamic");
		int[] W3 = {2, 3, 5, 5, 3, 7};
		int[] V3 = {3, 4, 10, 9, 6, 13};
		int M3 = 15;
		knapSackDp(W3, V3, M3);
		System.out.println("Test 3 - Greedy");
		knapSackGa(W3,V3,M3);
		
		// Test 4
		System.out.println("Test 4 - Dynamic");
		int[] W4 = {10, 13, 17, 15};
		int[] V4 = {21, 17, 30, 23};
		int M4 = 30;
		knapSackDp(W4, V4, M4);
		System.out.println("Test 4 - Greedy");
		knapSackGa(W4,V4,M4);
		
		// Test 5
		System.out.println("Test 5 - Dynamic");
		int[] W5 = {5, 4, 7, 6, 3, 4, 2, 1, 7, 6};
		int[] V5 = {3, 1, 3, 2, 1, 3, 2, 3, 1, 4};
		int M5 = 30;
		knapSackDp(W5, V5, M5);
		System.out.println("Test 5 - Greedy");
		knapSackGa(W5,V5,M5);
	}
	
	public static void runtime() {
		
		long runtime;
		int limit;
		int n = 5;
		Random rand = new Random();
		ArrayList<Long> runD = new ArrayList<Long>();
		ArrayList<Long> runG = new ArrayList<Long>();
		
		for(int i = 0; i < 10; i++) {
			int[] arrW = new int[n];
			int[] arrV = new int[n];
			for(int x = 0; x < n; x++) {
				arrW[x] = rand.nextInt(21) + 10;
				arrV[x] = rand.nextInt(41) + 10;
			}
			limit = n * 10;
			
			System.out.println("Dynamic - M = " + limit + "   n = " + n);
			runtime = System.nanoTime();
			knapSackDp(arrW, arrV, limit);
			runtime = System.nanoTime() - runtime;
			runD.add(runtime);
			
			runtime = System.nanoTime();
			System.out.println("Greedy - M = " + limit + "   n = " + n);
			knapSackGa(arrW, arrV, limit);
			runtime = System.nanoTime() - runtime;
			runG.add(runtime);
			n = n + 5;
		}
		
		System.out.println("Dynamic\n" + runD.toString() + "\nGreedy\n" + runG.toString());
	}
	
	public static void main(String[] args) {
		test();
		runtime();
	}

}

class Item{
	public int weight;
	public int value;
	
	public Item(int w, int v) {
		weight = w;
		value = v;
	}
	
	public void setWeight(int w) {
		weight = w;
		return;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setValue(int v) {
		value = v;
		return;
	}
	public int getValue() {
		return value;
	}
}

class ItemValueComparator implements Comparator<Item> {
	
	@Override
	public int compare(Item i1, Item i2) {
		return Integer.compare(i1.getValue(), i2.getValue());
	}
}

