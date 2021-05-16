import java.util.Scanner;
import java.lang.String;
 
public class Assignment8 {
    public static void main(String[] args) {
    // Sets up statements
        Scanner scnr = new Scanner(System.in);
        
        String yesOrNo = "n";
    // Sets loop for if the user wants to continue the program or terminate it
    while(yesOrNo.equals("n")){
        System.out.print("Please enter the 1st String: ");
        String string1 = scnr.next();
        System.out.print("Please enter the 2nd String: ");
        String string2 = scnr.next();
        
        // If method returns a valid index number, it prints it
        if (findIndex(string1, string2) < string1.length() && findIndex(string1, string2) > -1) {
            System.out.println("The index of " + string2 + " in " + string1 + " is: " + findIndex(string1, string2));
            // If it is not a valid index number, it says it is unknown
        } else {
            System.out.println("The index of " + string2 + " in " + string1 + " is unknown.");
        }
        System.out.println("Would you like to quit (y/n)?");
         yesOrNo = scnr.next();
        }
    }   
    // Method "findIndex" for checking if the 2nd string is in the first
    public static int findIndex(String string1, String string2) {
        char c;
        char d;
        int index = -1;
        boolean match = true;
        int count = 1;
        int counter = 0;
        boolean matchFound = false;
        for (int i = 0; i < string2.length(); i++) {
            c = string2.charAt(i);
            if (string2.length() > string1.length()) {
                match = false;
                break;
            }
            // Checks if the characters after the first of string 2 match in string 1
            if (matchFound == true) {
                for (int j = count + counter; j < string1.length(); j++) {
                    d = string1.charAt(j);
                    if (d != c) {
                         
                        match = false;
                    } else {
                        counter++;
                        index = j -1;
                        matchFound = true;
                        break;
                    }
                }
            }   
            // Checks for the first character in string2 in string1
            if (matchFound == false) {
                for (int k = 0; k < string1.length(); k++) {
                    d = string1.charAt(k);  
                    if (d != c) {
                        count ++;
                       
                        matchFound = false;
                    } else {
                        index = k;
                        matchFound = true;
                        break;
                    }   
                match = true;
                }   
            }   
        }
        // returns the index number
            return index;
            
     
    }
}