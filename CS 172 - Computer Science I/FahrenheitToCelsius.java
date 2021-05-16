import java.util.Scanner;
public class FahrenheitToCelsius
{
   public static void main(String[] args)
   {
      //Request input from user.
      Scanner s = new Scanner(System.in);
      System.out.print("Enter temperature in Fahrenheit: ");
      
      // Calculate celsius from fahrenheit
      double fahrenheit = s.nextDouble();
      double celsius = (fahrenheit - 32) * (0.5556);
      
      // Print result to the screen.
      System.out.println("Temperature in Celsius: " + celsius);
   }
}