import java.util.Scanner;
public class Lab6b
{
   public static void main(String [] args)
   {
      Scanner input = new Scanner(System.in);
      // Problem 1
      System.out.println("Problem 1. print out odd numbers from 1 to 99");
      //complete the following for loop to print out odd number from 1 to 99
      
      for(int i = 1; i <100; i = i + 2)
      {
         System.out.println(i);
        
      }
      
      
      //Problem 2
      System.out.println("Problem 2. display a triangle made of asterisks");
      //hint: you need to use nested for loop to complete this problem 
      
      int n;
      
      System.out.println("Enter an integer value less than 50: ");
      n = input.nextInt();  
      if (n > 50 || n <= 0)
         System.out.print("Invalid input");
      else
      {
      //complete the nested for loops below to print out a triangele of asterisks
         for(int row = 1; row < n+1; row++) 
         { 
                  
            for (int star = 0; star < row; star++) 
            {
               System.out.print ("*"); 
            
            }   
                   
            System.out.println();
                   
         } 
         
      }
     
     // problem 3
     System.out.println("Problem 3 .return highest value of 10 integer");
     System.out.println("Enter 10 integers");
     
     int value1;
     value1 = input.nextInt(); 
     
     //complete the following for loop and if statement to return the largest of 10 integers that user input
     for (int s = 0; s < 9; s++)
     {
       int value = input.nextInt();
         if (value > value1)
        
        {
           value1 = value;
        }
                 
     }
     System.out.println("largest -> " + value1);
    input.nextLine();
    //Problem 4
    System.out.println ("Problem 4. count vowels");
    String vowels = input.nextLine(); // take a user input of string
    System.out.println("the length of the string vowels: " + vowels.length());

    vowels = vowels.toLowerCase();//conver all the character to lower case
    int countA = 0;
    int countE = 0;
    int countI = 0;
    int countO = 0;
    int countU = 0;
    for(int index = 0; index < vowels.length(); index++) //vowels.length() will give your the length of the string
    {
        if((vowels.charAt(index)) == ('a')){
        countA = countA + 1;
        }  
        
        if((vowels.charAt(index)) == ('e')){
        countE = countE + 1;
        }  
        
        if((vowels.charAt(index)) == ('i')){
        countI = countI + 1;
        }    
        
        if((vowels.charAt(index)) == ('o')){
        countO = countO + 1;
        }   
        
        if((vowels.charAt(index)) == ('u')){
        countU = countU + 1;
        }   
    }
    
    System.out.println("A: " + countA);
    System.out.println("E: " + countE);
    System.out.println("I: " + countI);
    System.out.println("O: " + countO);
    System.out.println("U: " + countU); 
    }
   }