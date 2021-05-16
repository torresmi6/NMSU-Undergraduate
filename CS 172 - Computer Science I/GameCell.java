
public class GameCell
{
// Member that stores cell value
char cellValue;

// Default constructor that sets cell value to a space character
public void GameCell() {
cellValue = ' ';
}

// Constructor to set cell value
public void GameCell(char cellChar) {
cellValue = cellChar;
}

// Method to return cell value
public char getCellValue(){
return cellValue;
}

// Method to set cell value
public void setCellValue(char cellChar) {
cellValue = cellChar;
}

// Method to print cell value
public void printCell() {
System.out.print(cellValue);
}

}