import java.util.Scanner;

public class ShoppingCartManager
{

   public static void main(String[] args)
   {
   Scanner scnr = new Scanner(System.in);
   ItemToPurchase item1 = new ItemToPurchase();
   String name;
   String date;

   System.out.println("Enter Customer's Name:");
   name = scnr.nextLine();
   System.out.println("Enter Today's Date:");
   date = scnr.nextLine();

   ShoppingCart cart = new ShoppingCart(name, date);
/* Chito - need to share the scanner */
   cart.setScanner(scnr);
   
   System.out.println("\nCustomer Name: " + cart.getCustomerName());
   System.out.println("Today's Date: " + cart.getDate());
   
   cart.printMenu(cart);
/* Chito - be sure to always close the scanner when done */
   scnr.close();
   
   }
   }
