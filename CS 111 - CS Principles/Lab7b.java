import java.util.Scanner;
public class Lab7b{

public static void main(String [] args){

   Scanner scan = new Scanner(System.in);//Problem 1. reverse the characters in a string
   
   
   System.out.println("Problem 1 reverse the characters in a string");
   
   System.out.println("Enter a string:");
   String input = scan.nextLine();
   
   String answer = "";
   for (int i = input.length(); i > 0; i--){
   
   answer = answer + input.charAt(i-1);
   }
   
   System.out.println(answer);
   
   System.out.println();
   
   //Problem # 2 - display a table of number with their squares from 1 - 80
   //
   System.out.println("This is problem # 2\n");
   String space = "    ";
   
   for (int i = 0; i < 1; i++){
   System.out.println("Num  Square  Num  Square  Num  Square  Num  Square");
      for (int j = 1; i < 21; i++){
      space = "    ";
      if(i >= 10){
      space = "   ";
      }
      System.out.print(i + space); 
      space = "       ";
      if(i>=4){
      space = "      ";
      }
      if(i>=10){
      space = "     ";
      }
      System.out.print((i*i) + space); 
      space = "   ";
      System.out.print((i+20) + space);
      space = "     ";
      if(i >= 12){
      space = "    ";
      }
      
      System.out.print((i+20)*(i+20) + space);
      space = "   ";
      System.out.print((i+40) + space);
      space = "    "; 
      System.out.print((i+40)*(i+40) + space);
      space = "   ";
      System.out.print((i+60) + space + (i+60)*(i+60));
      System.out.println();
      }
      System.out.println("");
   }
   
   
   //Problem # 3 - display the number of an user input in reverse
   //
   
   System.out.println("This is problem # 3\n");
   System.out.println("Enter an integer number that more than 2 digits");
   int userNum = scan.nextInt();
   int reverseNum = 0;
   
   while (userNum != 0) {
    reverseNum = (reverseNum * 10) + (userNum % 10);
    userNum = userNum / 10;   
   }
   System.out.println("The number in reverse is " + reverseNum);
   System.out.println("");
   
   
   
   // Problem # 4 - array: create an integer array with 5 elements and use for loop to take user inputs of 5 integer numbers. 
   // Then print out the array element one by one on one row
   
   System.out.println("Problem 4 ");   // create an array with 5 integer elements
   
   int[] numbers = new int[5];
   
   for(int i = 0; i < 5; i++){
   numbers[i] = scan.nextInt();
   }
   
   for(int i = 0; i < 5; i++){
   System.out.print(numbers[i] + " ");
   }
   
 }
}