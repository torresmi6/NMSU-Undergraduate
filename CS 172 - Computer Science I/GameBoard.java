import java.util.Scanner;

public class GameBoard
{
// Creates new instances for each cell using default constructor
GameCell cell1 = new GameCell();
GameCell cell2 = new GameCell();
GameCell cell3 = new GameCell();
GameCell cell4 = new GameCell();
GameCell cell5 = new GameCell();
GameCell cell6 = new GameCell();
GameCell cell7 = new GameCell();
GameCell cell8 = new GameCell();
GameCell cell9 = new GameCell();

// Creates the 2D array using the GameCell objects
GameCell[][] board = {  
                        {cell1, cell2, cell3}, 
                        {cell4, cell5, cell6}, 
                        {cell7, cell8, cell9}, 
                        };


// Method that returns a specific cell's value
public char getCell(int rowIndex, int columnIndex){
return (board[rowIndex][columnIndex]).getCellValue();
}

// Method that sets a specific cell's value
public void setCell(int rowIndex, int columnIndex, char value){
(board[rowIndex][columnIndex]).setCellValue(value);
}

// Clears the board for a new game
 public void resetBoard()
  {
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        setCell(i, j, ' ');
        }
      }
  }

// Prints the current state of the board
 public void showBoard()
  {
    int numRow = 3;
    int numCol = 3;

    System.out.println();

    // Makes the blank header
    System.out.print("    ");
    for (int i = 0; i < numCol; i++)
      System.out.print("  ");
    System.out.print('\n');


    // Makes the Tic Tac Toe board with the cell's values
    for (int i = 0; i < numRow; i++) {
      System.out.print(" ");
      for (int j = 0; j < numCol; j++) {
        if (j != 0)
          System.out.print("|");
        System.out.print(" ");
        (board[i][j]).printCell();
        System.out.print(" ");
      }

      System.out.println();

      if (i != (numRow - 1)) {
        // The rest of the board
        System.out.print(" ");
        for (int j = 0; j < numCol; j++) {
          if (j != 0)
            System.out.print("+");
          System.out.print("---");
        }
        System.out.println();
      }
    }
    System.out.println();
  }

}