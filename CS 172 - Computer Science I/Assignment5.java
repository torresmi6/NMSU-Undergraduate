import java.util.Scanner;
public class Assignment5 {

    public static void main(String args[]) {
    
    // Initialize variables
    int currentNumber;
    int smallestNumber;
    int largestNumber;
    Scanner scnr = new Scanner(System.in);
    
    // First Input and variable assignment
    System.out.println("Please enter a positive number (Enter -1 to quit):");
    currentNumber = scnr.nextInt();
    smallestNumber = currentNumber;
    largestNumber = currentNumber;
    
    // Loop that asks for input, compares it to previous number, sets smallest and largest if smaller/larger. Only loops if num is not -1.
    do{
      System.out.println("Please enter a positive number (Enter -1 to quit):");
      currentNumber = scnr.nextInt();
      
      if (currentNumber != -1){
      
         if (currentNumber < smallestNumber) {
         smallestNumber = currentNumber;
         }
         if (currentNumber > largestNumber) {
         largestNumber = currentNumber;
         }
    }
    }
    while (currentNumber > 0); 
    
    // Final print statement for smallest and largest numbers
    System.out.println("The largest number is: " + largestNumber);
    System.out.println("The smallest number is: " + smallestNumber);
  }
}