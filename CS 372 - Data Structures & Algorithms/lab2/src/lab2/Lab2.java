package lab2;
import java.util.Random;

public class Lab2 {

	public static void mergeSort(int array[], int start, int end) {
		
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
		}
		else {
			return;
		}
	}
	
	public static void merge(int array[], int start, int mid, int end) {
		
		int temp[] = new int[array.length];
		int start1 = start;
		int start2 = mid + 1;
		int i = start;
		
		for(; start1 <= mid && start2 <= end; i++) {
			if(array[start1] <= array[start2]) {
				temp[i] = array[start1++];
			}
			else {
				temp[i] = array[start2++];
			}
		}
		
		while(start1 <= mid) {
			temp[i++] = array[start1++];
		}
		
		while(start2 <= end) {
			temp[i++] = array[start2++];
		}
		
		for(i = start; i <= end; i++) {
			array[i] = temp[i];
		}
		
	}
	
	public static void fillArr(int array[]) {
		
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(1001);
		}
	}
	
	// Prints the first and last 5 elements of given array to verify sort
	public static void printArr(int array[]) {
		
		System.out.println("//First 5");
		for(int i = 0; i < 5; i++) {
			System.out.println(array[i]);
		}
		System.out.println("//Last 5");
		for(int i = 0; i < 5; i++) {
			System.out.println(array[array.length-5+i]);
		}
	}
	
	public static void bubbleSort(int array[]) {
		int temp;
		
		for(int i = 0; i < array.length; i++) {
			for(int a = 0; a < array.length - 1 - i; a++) {
				
				if(array[a] > array[a+1]) {
					temp = array[a];
					array[a] = array[a+1];
					array[a+1] = temp;
				}
			}
		}
	}
	
	public static int partition(int array[], int start, int end) {
		
		int pivot = array[end];
		int i = (start - 1);
		
		for(int a = start; a < end; a++) {
			if(array[a] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[a];
				array[a] = temp;
			}
		}
		
		int temp = array[i+1];
		array[i+1] = array[end];
		array[end] = temp;
		
		return i+1;
	}
	
	public static void quickSort(int array[], int start, int end) {
		
		if(start < end) {
			int pIndex = partition(array, start, end);
			quickSort(array, start, pIndex-1);
			quickSort(array, pIndex+1, end);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = new int[512];
		int array2[] = new int[1024];
		int array3[] = new int[2048];
		int array4[] = new int[4096];
		
		long time1, time2;
		
		fillArr(array1);
		fillArr(array2);
		fillArr(array3);
		fillArr(array4);
		
		
		time1 = System.nanoTime();
		mergeSort(array1, 0, array1.length-1);
		time2 = System.nanoTime();	
		
		System.out.println("Array 512 MergeSort");
		printArr(array1);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array1);
		time1 = System.nanoTime();
		bubbleSort(array1);
		time2 = System.nanoTime();
		
		System.out.println("Array 512 BubbleSort");
		printArr(array1);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array1);
		time1 = System.nanoTime();
		quickSort(array1, 0, array1.length-1);
		time2 = System.nanoTime();
		
		System.out.println("Array 512 QuickSort");
		printArr(array1);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		
		time1 = System.nanoTime();
		mergeSort(array2, 0, array2.length-1);
		time2 = System.nanoTime();
		
		System.out.println("\nArray 1024");
		printArr(array2);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array2);
		time1 = System.nanoTime();
		bubbleSort(array2);
		time2 = System.nanoTime();
		
		System.out.println("Array 1024 BubbleSort");
		printArr(array2);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array2);
		time1 = System.nanoTime();
		quickSort(array2, 0, array2.length-1);
		time2 = System.nanoTime();
		
		System.out.println("Array 1024 QuickSort");
		printArr(array2);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		
		time1 = System.nanoTime();
		mergeSort(array3, 0, array3.length-1);
		time2 = System.nanoTime();
		
		System.out.println("\nArray 2048");
		printArr(array3);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array3);
		time1 = System.nanoTime();
		bubbleSort(array3);
		time2 = System.nanoTime();
		
		System.out.println("Array 2048 BubbleSort");
		printArr(array3);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array3);
		time1 = System.nanoTime();
		quickSort(array3, 0, array3.length-1);
		time2 = System.nanoTime();
		
		System.out.println("Array 2048 QuickSort");
		printArr(array3);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		
		time1 = System.nanoTime();
		mergeSort(array4, 0, array4.length-1);
		time2 = System.nanoTime();
		
		System.out.println("\nArray 4096");
		printArr(array4);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array4);
		time1 = System.nanoTime();
		bubbleSort(array4);
		time2 = System.nanoTime();
		
		System.out.println("Array 4096 BubbleSort");
		printArr(array4);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
		
		fillArr(array4);
		time1 = System.nanoTime();
		quickSort(array4, 0, array4.length-1);
		time2 = System.nanoTime();
		
		System.out.println("Array 4096 QuickSort");
		printArr(array4);
		System.out.println("Runtime: " + (time2 - time1) + " nanoseconds");
	}

}
