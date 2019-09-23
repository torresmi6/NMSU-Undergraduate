
public class IntNode {

	private int data;
	private IntNode link;
	
	// No argument constructor, sets data to 0, link to null.
	public IntNode(){
		
		data = 0;
		link = null;
	}
	
	// 2 Argument constructor, sets data and link to the given values
	// int and IntNode parameters
	public IntNode(int value, IntNode node) {
		
		data = value;
		link = node;
		
	}
	
	// Getter, returns int data, no parameter
	public int getData() {
		return data;
	}
	
	// Getter, returns IntNode link, no parameter
	public IntNode getLink() {
		return link;
	}
	
	// Setter, no return, sets data to given value. int parameter
	public void setData(int value) {
		data = value;
	}
	
	// Setter, no return, sets link to given value. IntNode parameter
	public void setLink(IntNode node) {
		link = node;
	}
	
	// turns all node values into a string. returns a string, no parameter
	public String toString() {
		String listString = "";
		IntNode cursor = link;
		
		listString = listString + getData();
		while(cursor != null) {
			listString = listString + ", " + cursor.getData();
			cursor = cursor.getLink();
		}
		
		return listString;
	}
	
	// Adds a new node with given int value after the node used to call the method
	// No return, int parameter
	public void addNodeAfterThis(int newData) {
		
		link = new IntNode(newData, link);
		
	}
	
	// Removes the node that is after the one used to call the method
	// no return, no parameter
	public void removeNodeAfterThis() {
		
		link = getLink().getLink();
	}
	
	// gives the length of the entire list. Returns an int.
	// IntNode paramter that tells the method where to start counting
	public static int listLength(IntNode head) {
		
		int cnt = 0;
		IntNode cursor = head;
		
		while(cursor != null) {
			cnt++;
			cursor = cursor.getLink();
		}
		return cnt;
	}
	
	// Searches the list for a node with same value as the given one.
	// Returns a boolean, true if it finds a match, false otherwise
	// int and IntNode parameters of the value to search for and where to start looking
	public static boolean search(IntNode head, int data) {
		
		if(head != null) {
			
			IntNode cursor = head;
			while(cursor!= null) {
				
				if(cursor.getData() == data) {
					return true;
				}
				cursor = cursor.getLink();
			}
			return false;
			
		}
		return false;
	}
	
}
