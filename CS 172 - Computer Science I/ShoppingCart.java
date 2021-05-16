import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingCart
{
  
  private String customerName;
  private String currentDate;
  ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

/* removed new scanner. Scanner should be shared. */
  Scanner scnr;// = new Scanner(System.in);

/* Chito - added function to share scanner. */
public void setScanner(Scanner s)
{
    scnr = s;
}
  
  public ShoppingCart()
  {
  customerName = "none";
  currentDate = "January 1, 2016";
  }
  
  public ShoppingCart(String custName, String date)
  {
  customerName = custName;
  currentDate = date;
  }
  
  public String getCustomerName()
  {
  return customerName;
  }
  
  public String getDate()
  {
  return currentDate;
  }
  
  public void addItem(ItemToPurchase item)
  {
  if (cartItems != null){
  cartItems.add(item);
  }
  }
  
  public void removeItem(String item)
  {
  boolean match = false;
  for ( int i = 0;  i < cartItems.size(); i++){
            String tempItem = (cartItems.get(i)).getName();
            if(tempItem.equals(item)){
                cartItems.remove(i);
                match = true;
            }
        }
  if(match != true) {
  System.out.println("Item not found in cart. Nothing removed.");
  }
  }
  
  public void modifyItem(ItemToPurchase item){
  boolean match = false;
  int itemIndex;
  String description = item.getDescription();
  for ( int i = 0;  i < cartItems.size(); i++){
            String tempItem = (cartItems.get(i)).getName();
            if(tempItem.equals(item.getName())){
                match = true;
                itemIndex = i;
            }
        }
  if( match == true) {
      if(description.equals("none")){
      }
      else {
      item.setDescription(scnr.nextLine());
      item.setPrice(scnr.nextInt());
      item.setQuantity(scnr.nextInt());
      }
  }
  else if(match == false) {
  System.out.println("Item not found in cart. Nothing modified.");
  }
  }
  public int getNumItemsInCart() 
  {
  int count = 0;
   for ( int i = 0;  i < cartItems.size(); i++){
   count = count + (cartItems.get(i)).getQuantity();
   }
  return count;
  }
  
  public int getCostOfCart()
  {
  int cartCost = 0;
  for ( int i = 0;  i < cartItems.size(); i++){
   cartCost = cartCost + ((cartItems.get(i)).getPrice() * (cartItems.get(i)).getQuantity());
   }
  return cartCost;
  }
  
  public void printTotal()
  {
  System.out.println(customerName + "'s Shopping Cart - " + currentDate);
  System.out.println("Number of Items: " + getNumItemsInCart() + "\n");
   if(getNumItemsInCart() == 0) {
   System.out.println("SHOPPING CART IS EMPTY\n");
   System.out.println("Total: $0");
   }

   for ( int i = 0; i < cartItems.size(); i++){
   System.out.println((cartItems.get(i)).getName() + " " + (cartItems.get(i)).getQuantity() + " @ $" + (cartItems.get(i)).getPrice() + " = $" + ((cartItems.get(i)).getPrice() * (cartItems.get(i)).getQuantity()));
   
   }
   if(getNumItemsInCart() != 0) {
   System.out.println("\nTotal: $" + getCostOfCart());
   }
  }
  
  public void printDescriptions()
  {
  System.out.println(customerName + "'s Shopping Cart - " + currentDate);
  System.out.println("\nItem Descriptions");
   for ( int i = 0; i < cartItems.size(); i++){
   (cartItems.get(i)).printItemDescription();
   }
  }
   public void printMenu(ShoppingCart cart)
   {
   char input;
   String name;
   String description;
   int price;
   int quantity;
   int itemIndex;
   
 

   
   do {
   /* changed to print from println */
   System.out.println("\nMENU");
   System.out.println("a - Add item to cart");
   System.out.println("d - Remove item from cart");
   System.out.println("c - Change item quantity");
   System.out.println("i - Output items' descriptions");
   System.out.println("o - Output shopping cart");
   System.out.println("q - Quit\n");
      do{
      System.out.println("Choose an option:");
      input = scnr.nextLine().charAt(0);
      } while(input != 'a' && input != 'd' && input != 'c' && input != 'i' && input != 'o' && input != 'q');
   switch (input) {
      case 'a':   System.out.println("ADD ITEM TO CART");
                  System.out.println("Enter the item name:");
                  name = scnr.nextLine();
   
                  System.out.println("Enter the item description:");
                  description = scnr.nextLine();
                  
                  System.out.println("Enter the item price:");
                  price = scnr.nextInt();
   
                  System.out.println("Enter the item quantity:");
                  quantity = scnr.nextInt(); scnr.nextLine();
                  
                  ItemToPurchase item1 = new ItemToPurchase(name, description, price, quantity);
                  cart.addItem(item1);
                  break;
                  
      case 'd':   System.out.println("REMOVE ITEM FROM CART");
                  System.out.println("Enter name of item to remove:");
                  
                  
                  cart.removeItem(scnr.nextLine());
                  break;
                  
      case 'c':   boolean match = false;
                  System.out.println("CHANGE ITEM QUANTITY");
                  System.out.println("Enter the item name:");
                  name = scnr.nextLine();
                  System.out.println("Enter the new quantity:");
                  quantity = scnr.nextInt(); scnr.nextLine();
                     for ( int i = 0;  i < cartItems.size(); i++){
                     String tempItem = (cartItems.get(i)).getName();
                     if(tempItem.equals(name)){
                     itemIndex = i;
                     (cartItems.get(itemIndex)).setQuantity(quantity);
                     match = true;
                     }
                     }
                     if(match == false){
                     System.out.println("Item not found in cart. Nothing modified.");
                     }
                  break;

      
      case 'i':   System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                  cart.printDescriptions();
                  break;
                  
      case 'o':   System.out.println("OUTPUT SHOPPING CART");
                  cart.printTotal();
                  break;
     
}
}
while (input != 'q');
   }

}
   
   