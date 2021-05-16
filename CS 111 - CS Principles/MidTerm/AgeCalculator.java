import java.util.Scanner;
public class AgeCalculator{
   public static void main(String[] args) {
   
   Scanner input = new Scanner(System.in);
   int age = 0;
   
   System.out.println("Please enter the year you were born");
   int year = input.nextInt();
   System.out.println("Please enter the month you were born in number form"); 
   int month = input.nextInt();
   
   if(month < 4) {
   age = 2019 - year;
   }
   
   if(month >= 4) {
   age = 2019 - year - 1;
   }
   System.out.println("You are " + age + " years old");
   }
   }