public class Assignment7 {

    public static void main(String args[]) {
    
    String ast = "*";
    String space = " ";
    
    // Square/Rectangle
    // Creates the 5x length
    for (int a = 0; a < 5; a++) {
      //Creates the 5x width
      for (int i = 0; i < 5; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
    }
    
    // Right triangle
    System.out.println();
    System.out.println(ast);
    // Loops increase asterick size by one each time
      for (int i = 0; i < 2; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      for (int i = 0; i < 3; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      for (int i = 0; i < 4; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      for (int i = 0; i < 5; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      // Upside down right Triangle
      // Same as right triangle but in opposite order
      System.out.println();
      for (int i = 0; i < 5; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      for (int i = 0; i < 4; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      for (int i = 0; i < 3; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      for (int i = 0; i < 2; i++) {
      System.out.print(ast + space);
      }
      System.out.println();
      
      System.out.println(ast);
      
      // Diamond
      // Loops for spaces individually and astericks individually
      for (int i = 0; i < 6; i++) {
      System.out.print(space);
      }
      
      System.out.print(ast);
      
      System.out.println();
      for (int i = 0; i < 4; i++) {
      System.out.print(space);
      }
      
      for (int i = 0; i < 3; i++) {
      System.out.print(ast + space);
      }

      System.out.println();
      for (int i = 0; i < 2; i++) {
      System.out.print(space);
      }
      
      for (int i = 0; i < 5; i++) {
      System.out.print(ast + space);
      }
      
      System.out.println();
      for (int i = 0; i < 7; i++) {
      System.out.print(ast + space);
      }
      
      System.out.println();
      for (int i = 0; i < 2; i++) {
      System.out.print(space);
      }
      
      for (int i = 0; i < 5; i++) {
      System.out.print(ast + space);
      }
      
      System.out.println();
      for (int i = 0; i < 4; i++) {
      System.out.print(space);
      }
      
      for (int i = 0; i < 3; i++) {
      System.out.print(ast + space);
      }

      System.out.println();
      for (int i = 0; i < 6; i++) {
      System.out.print(space);
      }
      
      System.out.print(ast);
}
}