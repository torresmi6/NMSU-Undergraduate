import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String title;
      String header1;
      String header2;
      String comboString;
      String firstWord = "";
      String numberString = "";
      int commaCount = 0;
      int commaIndex;
      boolean noInt = false;
      boolean noComma = false;
      boolean tooManyCommas = false;
      int number;
      int index = 0;
      int quit = 0;
      String spaces = "";
      String asterick = "";
      int numberLength;
      ArrayList<String> names = new ArrayList<String>();
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      
      System.out.println("Enter a title for the data:");
      title = scnr.nextLine();
      System.out.println("You entered: " + title + "\n");
      
      System.out.println("Enter the column 1 header:");
      header1 = scnr.nextLine();
      System.out.println("You entered: " + header1 + "\n");
      
      System.out.println("Enter the column 2 header:");
      header2 = scnr.nextLine();
      System.out.println("You entered: " + header2 + "\n");
      
      while(quit != -1) {
      quit = 0;
      noInt = false;
      noComma = false;
      commaCount = 0;
      index = 0;
      tooManyCommas = false;
      comboString = "";
      firstWord = "";
      numberString ="";
      System.out.println("Enter a data point (-1 to stop input):");
      comboString = scnr.nextLine();
      if(comboString.equals("-1")){
         quit = -1;
         break;
      }
      if((comboString.charAt(comboString.length()-1)) == '-'){
         quit = -1;
      }
      
      if(comboString.contains(",") == false){
         System.out.println("Error: No comma in string.\n");
         noComma = true;
         quit = 1;
      }
      
      
      for(int i=0; i < comboString.length(); i++){
        if(comboString.charAt(i) == ',')
            commaCount++;
      }
      
      if(commaCount > 1) {
         System.out.println("Error: Too many commas in input.\n");
         tooManyCommas = true;
         quit = 1;
      }
      
      commaIndex = comboString.indexOf(",");
      for(int i=commaIndex+1; i < comboString.length(); i++){
        if(comboString.charAt(i) != ' ') {
         if(comboString.charAt(i) != '1' && comboString.charAt(i) != '2' && comboString.charAt(i) != '3' && comboString.charAt(i) != '4' && comboString.charAt(i) != '5' && comboString.charAt(i) != '6' && comboString.charAt(i) != '7' && comboString.charAt(i) != '8' && comboString.charAt(i) != '9' && comboString.charAt(i) != '0'){
            noInt = true;
            quit = 1;
         }
        }
        
      }
      if(noInt == true && noComma == false && tooManyCommas == false){
         System.out.println("Error: Comma not followed by an integer.\n");
      }
      
      for(int i=0; i < comboString.length(); i++){
        if(comboString.charAt(i) == ',')
            commaCount++;
      }
      
      if (quit == 0){      
      while(comboString.charAt(index) != ',') {
            firstWord = firstWord + comboString.charAt(index);
            index++;
         }
      System.out.println("Data string: " + firstWord);
      names.add(firstWord);
      
      for (int i = index + 1; i < comboString.length(); i++) {
            if(comboString.charAt(i) == '-'){
               break;
            }
            if(comboString.charAt(i) != ' '){
            numberString = numberString + comboString.charAt(i);
            }
         }
      number = Integer.parseInt(numberString);
      System.out.println("Data integer: " + number +"\n");
      numbers.add(number);
      }
      }
      
      for(int i = 0; i < (33 - title.length()); i++){
            spaces = spaces + " ";
         }
      System.out.println("\n" + spaces + title);
      spaces = "";
      for(int i = 0; i < (20 - header1.length()); i++){
            spaces = spaces + " ";
         }
      
      System.out.print(header1 + spaces + "|");
      spaces = "";
      for(int i = 0; i < (23 - header2.length()); i++){
            spaces = spaces + " ";
         }
         
      System.out.println(spaces + header2);
      System.out.println("--------------------------------------------");

      spaces = "";
      for(int i = 0; i < names.size(); i++){
         for(int a = 0; a < (20 - (names.get(i)).length()); a++){
            spaces = spaces + " ";
         }
         
         System.out.print(names.get(i) + spaces + "|");
         spaces = "";
         numberLength = String.valueOf(numbers.get(i)).length();
         for(int b = 0; b < (23 - numberLength); b++){
            spaces = spaces + " ";
         }
         System.out.println(spaces + numbers.get(i));
         spaces = "";
      }
      
      System.out.println();
      
      for(int i = 0; i < numbers.size(); i++){
         for(int a = 0; a < (numbers.get(i)); a++){
            asterick = asterick + "*";
         }
         for(int b = 0; b < (20 - (names.get(i)).length()); b++){
            spaces = spaces + " ";
         }
      System.out.println(spaces + names.get(i) + " " + asterick);
      spaces = "";
      asterick = "";
      }
      return;
   }     
}