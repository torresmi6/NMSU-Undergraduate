//This program demonstrates parts of greatest common divisor
// It shows how to calculate the remainder of two integers and also
// how a while loop works with a place holder (temp) variable

// Algorithm
// Read in two positive integer
// Using a while loop, print the remainder value, and then decrement the value
// Finally, print out the final value of gcd

// Michael Torres
// 3/22/19

import java.util.Scanner;

public class GCD {
 
    public static void main(String[] args) {
       
       // Initialize int members
       int firstNum;
       int secondNum;
       int gcd = 0;
       int temp;
       
       // new instance of Scanner class
       Scanner input = new Scanner( System.in );
       //user input the first number
       firstNum = input.nextInt();

       //user input the second number
       secondNum = input.nextInt();


       
       // If the first input is smaller than the second, switch the two numbers
       if (firstNum < secondNum){
       temp = firstNum;
       firstNum = secondNum;
       secondNum = temp;
       }
       
       // When the second number is 0, print out the first number
       if (secondNum == 0) {
       System.out.println(firstNum);
       gcd = firstNum;
       }

        //while loop    
       while ( secondNum != 0){  
          temp = firstNum%secondNum;   // set temp to the remainder of first and secondNum
          if(temp == 0) {
               gcd = secondNum;  // When temp is 0 (no remainder) gcd = the second number
          }
          firstNum = secondNum;  // Decrement all values by switching them with each other
          secondNum = temp;
          System.out.println(temp);         
       }      
      System.out.println("And finally gcd has the value of  " + gcd); // Print gcd

     }// of main
} // of class GCD