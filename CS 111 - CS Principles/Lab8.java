import java.util.Scanner;

public class Lab8{

public static void main(String[] args){

   Scanner scnr = new Scanner(System.in);
   boolean prime = true;
   
   int[] numbers = new int[10]; // Makes the array
   
   for(int i = 0; i < 10; i++){ // loop that asks for user input and stores each number in the array
   
   System.out.println("Enter a number:");
   numbers[i] = scnr.nextInt();
   }
   
   System.out.println("\nPrime Numbers:");
   
   for(int a = 0; a < 10; a++){
   prime = true;
      
      for(int i = 2; i < numbers[a]; i++) {
         if(numbers[a] % i == 0)
         prime = false;
      }
      if(numbers[a] == 1){
      prime = false;
      }
      
   if(prime == true){
   System.out.println(numbers[a]);
   }
   }
   
  }
 }