import java.util.Scanner;
public class Assignment6 {

    public static void main(String args[]) {
    
    // Initialize variables
    int num1;
    int num2;
    int num3;
    int num4;
    int currentNum;
    String yesOrNo = "n";
    Scanner scnr = new Scanner(System.in);
    
    // Overarching loop to see if the user wants to end the program or continue
    while(yesOrNo.equals("n")){
    // Assigning all numbers to 0 so they have something to compare to
    num1 = 0;
    num2 = 0;
    num3 = 0;
    num4 = 0;
    
    // First input
    System.out.println("Please enter the 4 numbers:");
    num1 = scnr.nextInt();
    
    // Loops the last three number inputs and sorts them individually
    for (int i = 0; i < 3; i++) {
    
    currentNum = scnr.nextInt();
    if (currentNum < num1) {
    num4 = num3;
    num3 = num2;
    num2 = num1;
    num1 = currentNum;
    }
    if (currentNum > num1) {
      if (num2 == 0) {
      num2 = currentNum;
      }
      if (currentNum < num2) {
      num4 = num3;
      num3 = num2;
      num2 = currentNum;
      }
      if (currentNum > num2) {
         if (num3 == 0) {
         num3 = currentNum;
         }
         if (currentNum < num3){
         num4 = num3;
         num3 = currentNum;
         }
         if (currentNum > num3) {
         num4 = currentNum;
         }
      }
    }
    }
    // Prints the sorted numbers and asks the user if they want to quit the program
    System.out.println("The numbers in sorted order from smallest to largest is: " + num1 + ", " + num2 + ", " + num3 + ", " + num4);
    System.out.println("Would you like to quit (y/n)?");
    yesOrNo = scnr.next();
}
  }  
  }
    
    
    
    
