import java.util.*;
class ContactList {
   public static void main(String[] args) {
       ContactNode contactList = new ContactNode();
       String name;
       String phoneNum;
       Scanner sc = new Scanner(System.in);
       for(int i=0;i<3;i++) {
           System.out.println("Person " + (i+1));
           System.out.println("Enter name:");
           name = sc.nextLine();
           System.out.println("Enter phone number:");
           phoneNum = sc.nextLine();
           contactList.insertAfter(new ContactNode(name,phoneNum));
           System.out.println("You entered: " + name + ", " + phoneNum +"\n");
       }
       System.out.println("CONTACT LIST");
       contactList.printContactNode();
       return;
   }
}  