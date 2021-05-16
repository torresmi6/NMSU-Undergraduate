import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
    // Sets up statements
        Scanner scnr = new Scanner(System.in);
        double input1;
        double input2;
        double sum;
        double difference;
        double product;
        double division;
        
        System.out.println("Please input a number:");
        input1 = scnr.nextDouble();
        System.out.println("Please input a number:");
        input2 = scnr.nextDouble();
        
        sum = input1 + input2;
        difference = input1 - input2;
        product = input1 * input2;
        division = input1 / input2;
        
        System.out.println(input1 + "+" + input2 + "=" + sum);
        System.out.println(input1 + "-" + input2 + "=" + difference);
        System.out.println(input1 + "*" + input2 + "=" + product);
        System.out.println(input1 + "/" + input2 + "=" + division);
        
        }
        }