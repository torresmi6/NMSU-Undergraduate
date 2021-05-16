// Michael Torres
// CS 278
// Lab5
// 3/4/20
// Inputs a set of numbers, the size of the set, and N
//	Outputs the subsets of the set whose sum is equal to N
package lab5;

import java.util.Scanner;

public class Lab5 {

   public static void printSubset(int set[], boolean mask[], int N) {
   
      String subsetString = "{ ";
      int intArray[] = new int[set.length];
      int a = 0;
      for (int i = 0; i < set.length; i++) {
         if (mask[i]) { 
            subsetString = subsetString + set[i] + ", ";
            intArray[a] = set[i];
            a++;
         }
      } // end for   
      if (subsetString.length() > 2) {
         subsetString = subsetString.substring(0, subsetString.length() - 2);
      }
      subsetString = subsetString + " }";
      int sum = 0;
      
      for(int i = 0; i < intArray.length; i++) {
    	  sum = sum + intArray[i];
      }
      if(sum == N) {
    	  System.out.println(subsetString);
      }
   } // end method
         
   public static boolean next( boolean mask[] ) {
      int i;  
      for (i = 0; i < mask.length && mask[i]; i++)
          mask[i] = false;
      if (i < mask.length) {
         mask[i] = true;
         return true;
      }
      return false;
   } // end method
      
   public static void main ( String args[] ) {
      
      int count = 0; 
      Scanner scan = new Scanner(System.in);
      
      // input the size of the set
      System.out.println("How many elements does your set have?");
      int n = scan.nextInt();

      // input the elements of the set      
      System.out.println("Enter " + n + " integers for the elements of the array:");
      int[] mySet = new int[n];
      for (int i = 0; i < mySet.length; i++)
         mySet[i] = scan.nextInt();
      
      // input the size of the set
      System.out.println("What is N?");
      int N = scan.nextInt();
      
      // create the initial mask with all false values
      boolean mask[] = new boolean[n];
      for (int index = 0; index < mask.length; index++ )
         mask[index] = false;
 
      System.out.println("Here are the subsets of your set whose sum is N:");
      // print the first subset set (note that this is the empty set)
      printSubset( mySet, mask, N );

      
      // Repeat until there are no more possible masks
      while (next( mask )) {
         printSubset( mySet, mask, N );
      } // end while
      
   } // end main
} // end class
      