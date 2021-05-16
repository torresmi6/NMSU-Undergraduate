class ContactNode {
public ContactNode() {
        nextNodePtr= null;
        contactName = null;
        contactPhoneNum = null;
   }
   public ContactNode(String name, String phoneNum) {
       contactName=name;
       contactPhoneNum=phoneNum;
   }
   public void insertAfter(ContactNode nextNode) {
       ContactNode temp;
       if(contactName == null && contactPhoneNum == null) {
           contactName = nextNode.getName();
           contactPhoneNum = nextNode.getPhoneNumber();
       }  
       else if(nextNodePtr == null)
           nextNodePtr = nextNode;
       else {
           temp=nextNodePtr;
           while(temp.getNext() != null) {
               temp=temp.getNext();
           }
           temp.nextNodePtr = nextNode;
       }
   }
   public String getName() {
       return contactName;
   }
   public String getPhoneNumber() {
       return contactPhoneNum;
   }
   public ContactNode getNext() {
       return nextNodePtr;
   }
   public void printContactNode() {
       ContactNode temp;
       System.out.println("Name: " + getName());
       System.out.println("Phone number: " + getPhoneNumber() + "\n");
       if(nextNodePtr!= null)
           getNext().printContactNode();
   }
   private String contactName;
   private String contactPhoneNum;
   private ContactNode nextNodePtr;
}