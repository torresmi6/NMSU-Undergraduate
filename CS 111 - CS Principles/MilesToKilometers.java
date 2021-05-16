import java.util.Scanner;

public class MilesToKilometers {
    public static void main(String[] args) {
    
    // Sets up statements
        Scanner scnr = new Scanner(System.in);
        double input1;
        double inKilometers;
        
        System.out.println("Please input a number in miles:");
        input1 = scnr.nextDouble();
        
        inKilometers = input1 * 1.60935;
        System.out.println(input1 + " miles is " + inKilometers + " kilometers");
        
        }
        }