import java.util.Scanner;

public class final_8{

   public static void main(String[] args){
   
   int[] arrayA = new int[5];
   int[] arrayB = new int[5];
   Scanner scnr = new Scanner(System.in);
   
   for(int i = 0; i < 5; i++){
   
   arrayB[i] = scnr.nextInt();
   
   if(arrayB[i] % 2 != 0){
   arrayA[i] = arrayB[i];
   }
   
   }
   
   for(int i = 0; i < 5; i++){
   System.out.println(arrayA[i]);
   }
  }
}  
   