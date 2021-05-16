import java.util.Random;

public class Sorting{

public static void selection(){           // First selection sort method

int[] numbers = new int[100000];          // Makes the array, and fills is with random integers (Must change the array size manually for different results)
int pick = 0;
Random r = new Random();

for (int i = 0; i < numbers.length; i++)
{
numbers[i] = r.nextInt(1000);
}
int indexSmallest = 0;
int temp = 0;


   for (int i = 0; i < numbers.length - 1; ++i) {

   // Find index of smallest remaining element
   indexSmallest = i;
   for (int j = i + 1; j < numbers.length; ++j) {

      if (numbers[j] < numbers[indexSmallest]) {
         indexSmallest = j;
      }
   }

   // Swap numbers[i] and numbers[indexSmallest]
   temp = numbers[i];
   numbers[i] = numbers[indexSmallest];
   numbers[indexSmallest] = temp;
   
  
   
}

}

public static void insertion(){                 // Insertion sort method

int i;
int j;
int temp;      // Temporary variable for swap
int[] numbers = new int[100000];                // Makes the array, and fills it with random integers
int pick = 0;

Random r = new Random();

for (i = 0; i < numbers.length; i++)
{
numbers[i] = r.nextInt(1000);
}

for (i = 1; i < numbers.length; ++i) {
     j = i;
         // Insert numbers[i] into sorted part 
         // stopping once numbers[i] in correct position
    while (j > 0 && numbers[j] < numbers[j - 1]) {

    // Swap numbers[j] and numbers[j - 1]
    temp = numbers[j];
    numbers[j] = numbers[j - 1];
    numbers[j - 1] = temp;
    --j;
    }
}

}


public static int partition(int [] numbers, int i, int k) { // partition method that is used for quicksort. Key component of quicksort method
      int l;
      int h;
      int midpoint;
      int pivot;
      int temp;
      boolean done;

      /* Pick middle element as pivot */
      midpoint = i + (k - i) / 2;
      pivot = numbers[midpoint];

      done = false;
      l = i;
      h = k;

      while (!done) {
         /* Increment l while numbers[l] < pivot */
         while (numbers[l] < pivot) {
            ++l;
         }

         /* Decrement h while pivot < numbers[h] */
         while (pivot < numbers[h]) {
            --h;
         }

         /* If there are zero or one items remaining,
            all numbers are partitioned. Return h */
         if (l >= h) {
            done = true;
         } 
         else {
            /* Swap numbers[l] and numbers[h],
               update l and h */
            temp = numbers[l];
            numbers[l] = numbers[h];
            numbers[h] = temp;

            ++l;
            --h;
         }
      }

      return h;
   }

   public static void quicksort(int [] numbers, int i, int k) {   // Actual quicksort method
      int j;

      /* Base case: If there are 1 or zero entries to sort,
       partition is already sorted */
      if (i >= k) {
         return;
      }

      /* Partition the data within the array. Value j returned
         from partitioning is location of last item in low partition. */
      j = partition(numbers, i, k);

      /* Recursively sort low partition (i to j) and
         high partition (j + 1 to k) */
      quicksort(numbers, i, j);
      quicksort(numbers, j + 1, k);
   }


public static void merge(int [] numbers, int i, int j, int k) {                  // merge method needed by merge sort method
      int mergedSize = k - i + 1;       // Size of merged partition
      int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
      int mergePos;                     // Position to insert merged number
      int leftPos;                      // Position of elements in left partition
      int rightPos;                     // Position of elements in right partition

      mergePos = 0;
      leftPos = i;                      // Initialize left partition position
      rightPos = j + 1;                 // Initialize right partition position

      // Add smallest element from left or right partition to merged numbers
      while (leftPos <= j && rightPos <= k) {
         if (numbers[leftPos] < numbers[rightPos]) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
         } 
         else {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
         }
         ++mergePos;
      }

      // If left partition is not empty, add remaining elements to merged numbers
      while (leftPos <= j) {
         mergedNumbers[mergePos] = numbers[leftPos];
         ++leftPos;
         ++mergePos;
      }

      // If right partition is not empty, add remaining elements to merged numbers
      while (rightPos <= k) {
         mergedNumbers[mergePos] = numbers[rightPos];
         ++rightPos;
         ++mergePos;
      }

      // Copy merge number back to numbers
      for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
         numbers[i + mergePos] = mergedNumbers[mergePos];
      }
   }

   public static void mergeSort(int [] numbers, int i, int k) {      // Actual merge sort method
      int j;   

      if (i < k) {
         j = (i + k) / 2;  // Find the midpoint in the partition

         // Recursively sort left and right partitions
         mergeSort(numbers, i, j);
         mergeSort(numbers, j + 1, k);

         // Merge left and right partition in sorted order
         merge(numbers, i, j, k);
      }
   }

public static void main(String[] args){   // main

int[] numbers = new int[100000];          // Makes the array, and fills is with random integers. This is only to be used for quicksort and merge sort
                                          // (Must change the array size manually for different results)
int pick = 0;                             //    as those are the only methods with parameters.

Random r = new Random();

for (int i = 0; i < numbers.length; i++)
{
numbers[i] = r.nextInt(1000);
}

long startTime = System.nanoTime();          // sets the current time to start time variable
   
//selection();                                  // Uses commenting to only record one method at a time
//insertion();
//quicksort(numbers, 0, numbers.length-1);
mergeSort(numbers, 0, numbers.length-1);

long duration = System.nanoTime() - startTime;  // Subtracts current time from start time to get the runtime
System.out.print(duration);   // Prints the runtime
}



}