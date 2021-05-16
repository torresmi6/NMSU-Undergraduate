import java.util.Scanner;

public class Game
{
  public static Scanner scnr = new Scanner(System.in);

  public static void main(String[] args)
  {
  // New instance of GameBoard and Game classes
  GameBoard gameBoard = new GameBoard();
  // Needed for static methods
  Game Game = new Game();
  
  // Members for program loop, and keeping track of wins
  String again = "y";
  int userWins = 0;
  int compWins = 0;
  
  // Main program
  do{
      // Resets the board for a new game
      gameBoard.resetBoard(); // initialize the board (with ' ' for all cells)



         // Set user and computer symbols
    
         char userSymbol = 'x';
          char compSymbol = 'o';


         char ans = 'y';

         int turn;  // 0 isthe user, 1 is the computer
         int remainCount = 9; // empty cell count

         // First move
          if (ans == 'y') {
            turn = 0;
            Game.userPlay(gameBoard, userSymbol); // user's move
         }
         else {
            turn = 1;
            Game.compPlay(gameBoard, compSymbol); // computer's move
         }
         // Prints the board, and decrements the count of empty cells.
         gameBoard.showBoard();
         remainCount--;

         // Runs the game until game is won.
         boolean done = false;
         int winner = -1;   // 0 is the user, 1 is the computer, -1 is a draw

         while (!done && remainCount > 0) {
            // If there is a winner, set the winner and the done flag to true.
            done = Game.isGameWon(gameBoard, turn, userSymbol, compSymbol); 

            if (done)
            winner = turn; // Last move decides winner
            else {
            // If there is no winner yet, start next turn.
            turn = (turn + 1 ) % 2;

            if (turn == 0)
               Game.userPlay(gameBoard, userSymbol);
            else
               Game.compPlay(gameBoard, compSymbol);

            // Show the board after  a movec, and decrement the empty cell count.
            gameBoard.showBoard();
            remainCount--;
         }
    }

    // When there is a winner, prints the outcome.
    if (winner == 0){
      System.out.println("\nWinner: user!");
      userWins++;
      System.out.println("The user is winning " + userWins + " games to " + compWins + " against the computer.");
      }
    else if (winner == 1){
      System.out.println("\nWinner: computer!");
      compWins++;
      System.out.println("The user is winning " + userWins + " games to " + compWins + " against the computer.");
      }
    else {
      System.out.println("\nDraw");
   }
   // Asks user if they want to continue, setting again to y or n.
   // continues or breaks the loop
   System.out.println("Play another game (y/n)?");
   again = scnr.next();
  } while(again.equals("y"));
}

  
  // Method to use when player makes a move
  public void userPlay(GameBoard board, char usym)
  {
    System.out.print("\nPlease enter your next move (row column): ");
    int rowIndex = (scnr.nextInt() - 1);
    int columnIndex = (scnr.nextInt() - 1);
   
   // Errors if input is invalid
    if(rowIndex > 2 || columnIndex > 2){
    System.out.println("Invalid column or row, Try again (row column):");
    rowIndex = (scnr.nextInt() - 1);
    columnIndex = (scnr.nextInt() - 1);
    }
    
    if(rowIndex < 0 || columnIndex < 0){
    System.out.println("Invalid column or row, Try again (row column):");
    rowIndex = (scnr.nextInt() - 1);
    columnIndex = (scnr.nextInt() - 1);
    }
    
      while (board.getCell(rowIndex, columnIndex) != ' ') {
      System.out.print("\n!! The cell is already taken.\nEnter the row and column indices: ");
      rowIndex = (scnr.nextInt() - 1);
      columnIndex = (scnr.nextInt() - 1);
    }
   // Sets cells with user input
    board.setCell(rowIndex, columnIndex, usym);
  }

   // Method to use when computer makes a move
  public void compPlay(GameBoard board, char csym)
  {
    // Computer makes a move.
    System.out.println("(computer makes move)");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.getCell(i, j) == ' ') { // empty cell
          board.setCell(i, j, csym);
          return;
        }
      }
    }
  }
   // Checks if the game is won
  public boolean isGameWon(GameBoard board, int turn, char usym, char csym)
  {
    char sym;
    if (turn == 0)
      sym = usym;
    else
      sym = csym;

    int i, j;
    boolean win = false;

    // Checks for a win by a row
    for (i = 0; i < 3 && !win; i++) {
      for (j = 0; j < 3; j++) {
        if (board.getCell(i, j) != sym)
          break;
      }
      if (j == 3)
        win = true;
    }

    // Checks for a win by a column
    for (j = 0; j < 3 && !win; j++) {
      for (i = 0; i < 3; i++) {
        if (board.getCell(i, j) != sym)
          break;
      }
      if (i == 3)
        win = true;
    }

    // Checks for a win by a diagonal (1)
    if (!win) {
      for (i = 0; i < 3; i++) {
        if (board.getCell(i, i) != sym)
          break;
      }
      if (i == 3)
        win = true;
    }

    // Checks for a win by a diagonal (2)
    if (!win) {
      for (i = 0; i < 3; i++) {
        if (board.getCell(i, 2 - i) != sym)
          break;
      }
      if (i == 3)
        win = true;
    }

    // Returns win
    return win;
  }
  }