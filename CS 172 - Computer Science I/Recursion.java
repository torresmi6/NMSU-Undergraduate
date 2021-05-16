public class Recursion{

static int answer = 0;              // Variables used for printing outcomes
static int product = 1; 
public static void surprise(int n)
{
   
  if(n == 1){                    // Base case that prints answer's value, then resets answer to 0
  System.out.println(answer);
  answer = 0;
  }
  else {                         // Recursive algorithm that divides n in half, then adds 1 to answer's value. Then calls the method again with the new n value
    n = n / 2;
    answer++;
    surprise(n);
  }
  
  
}

public static void multiplication(int n)
{
  
  if(n == 0){                       // Base case that prints product's value and then resets it to 1
  System.out.println(product);
  product = 1;
  }
  else{                             // Recursive algorithm that multiplies product by the remainder of dividing n by 10. Then n is divided by ten to get rid of its last digit
    product = product * (n % 10);
    n = n / 10;
    multiplication(n);              // Then calls the method with the new n value
   }
   
}


public static void main(String[] args){
System.out.println("Surprise Method Test");           // Tests the surprise method with small and large numbers
surprise(12);
surprise(5);
surprise(100);
System.out.println("\nMultiplication Method Test");     // Tests the multiplication method with small and large numbers
multiplication(52);
multiplication(1);
multiplication(1568);
multiplication(1024);
}

}