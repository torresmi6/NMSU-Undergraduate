import java.util.Scanner;

public class PlayerRoster {
   public static void main(String[] args) {
      /* Type your code here. */
      int[] rating = new int[5];
      int[] jersey = new int[5];
      Scanner scnr = new Scanner(System.in);
      char input;
      int jerseyNum;
      int ratingNum;
      int count = 1;
      int newJersey;
      int index = 0;
      

      for(int i = 0; i < 5; i++){
         
      System.out.println("Enter player " + (i+1) + "'s jersey number:");
      jersey[i] = scnr.nextInt();
      System.out.println("Enter player " + (i+1) + "'s rating:\n");
      rating[i] = scnr.nextInt();
      }

      System.out.println("ROSTER");
      System.out.println("Player 1 -- Jersey number: " + jersey[0] + ", Rating: " + rating[0]);
      System.out.println("Player 2 -- Jersey number: " + jersey[1] + ", Rating: " + rating[1]);
      System.out.println("Player 3 -- Jersey number: " + jersey[2] + ", Rating: " + rating[2]);
      System.out.println("Player 4 -- Jersey number: " + jersey[3] + ", Rating: " + rating[3]);
      System.out.println("Player 5 -- Jersey number: " + jersey[4] + ", Rating: " + rating[4]);
      
       do {  // Main menu for user to add, delete, and display animals in the zoo
   
   System.out.println("\nMENU");
   System.out.println("u - Update player rating");
   System.out.println("a - Output players above a rating");
   System.out.println("r - Replace player");
   System.out.println("o - Output roster");
   System.out.println("q - Quit\n");
 
      do{
      System.out.println("Choose an option:");
      input = scnr.next().charAt(0);
      } while(input != 'u' && input != 'a' && input != 'r' && input != 'o' && input != 'q');  // Asks for input until user submits a valid character
   switch (input) {
      case 'u':   System.out.println("\nEnter a jersey number:");
                  jerseyNum = scnr.nextInt();
                  System.out.println("Enter a new rating for player:");
                  ratingNum = scnr.nextInt();
                  rating[java.util.Arrays.asList(jersey).indexOf(jerseyNum)] = ratingNum;
                  break;
                  
      case 'a':   System.out.println("\nEnter a rating:");
                  ratingNum = scnr.nextInt();
                  
                  System.out.println("\nABOVE " + ratingNum);
                  
                  for(int i = 0; i < 5; i++){
                     if(rating[i] > ratingNum){
                        System.out.println("Player " + count + " -- Jersey number: " + jersey[i] + ", Rating: " + rating[i]);
                        
                     }
                     count++;
                  }
                  count = 1;
                  break;
                  
      case 'r':   System.out.println("\nEnter a jersey number:");
                  jerseyNum = scnr.nextInt();
                  System.out.println("Enter a new jersey number:");
                  newJersey = scnr.nextInt();
                  System.out.println("Enter a rating for the new player:");
                  ratingNum = scnr.nextInt();
                  for (int i = 0; i < 5; i++) {
                        if (jersey[i] == jerseyNum) {
                        index = i;
                        }
                  }
                        jersey[index] = newJersey;
                        rating[index] = ratingNum;
                    
                     
                  break;

      
      case 'o':   System.out.println("\nROSTER");
                  System.out.println("Player 1 -- Jersey number: " + jersey[0] + ", Rating: " + rating[0]);
                  System.out.println("Player 2 -- Jersey number: " + jersey[1] + ", Rating: " + rating[1]);
                  System.out.println("Player 3 -- Jersey number: " + jersey[2] + ", Rating: " + rating[2]);
                  System.out.println("Player 4 -- Jersey number: " + jersey[3] + ", Rating: " + rating[3]);
                  System.out.println("Player 5 -- Jersey number: " + jersey[4] + ", Rating: " + rating[4]);
                  
                  break;
                  
     
      }
       }
       while (input != 'q');
   }
}