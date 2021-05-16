import java.util.Scanner;
import java.io.IOException;
 
public class CelsiusToFahrenheit
{
    public static void main(String[] args) throws IOException
    {
        // Request input from the user.
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter temperature in Celsius: ");

        // Read the input from the user.
        double celsius = s.nextDouble();

        // Convert from Celsius to Fahrenheit.
        double fahrenheit = ((9.0/5.0)*celsius) + 32;
        System.out.println("Temperature in Fahrenheit is: " + fahrenheit);
    }
}






