
public class IntNode {

	private int data;
	private IntNode link;
	
	/**
	 * No argument constructor, sets data to 0 and link to null.
	 */
	public IntNode(){
		
		data = 0;
		link = null;
	}
	/**
	 * Constructor; sets data to given value and link to null
	 * @param value the new data you want the node to contain 
	 */ 
	public IntNode(int value) {
		
		data = value;
		link = null;
		
	}
	/**
	 * Constructor; sets data and link to the given values
	 * @param value the new data you want the node to contain 
	 * @param node  the node you want this node to point/link to
	 */  
	public IntNode(int value, IntNode node) {
		
		data = value;
		link = node;
		
	}
	
	/** 
	 * Getter; returns the data
	 * @return the data in the node
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * Getter; returns IntNode link
	 * @return the next node in the list
	 */
	public IntNode getLink() {
		return link;
	}
	
	/**
	 * Setter; sets data to given value
	 * @param value the new value data will be set to
	 */
	public void setData(int value) {
		data = value;
	}
	
	/**
	 * Setter; sets link to given value
	 * @param node the new node this node will point to
	 */
	public void setLink(IntNode node) {
		link = node;
	}
	
	/**
	 * Converts all node values into a string
	 * @return the string of all the node values
	 */
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
	
	/** 
	 * Adds a new node, with given value, after the node 
	 * used to call this method
	 * @param newData the value the new node will contain
	 */ 
	public void addNodeAfterThis(int newData) {
		
		link = new IntNode(newData, link);
		
	}
	
	/** 
	 * Removes the node that is after the one used to 
	 * call this method
	 */ 
	public void removeNodeAfterThis() {
		
		link = getLink().getLink();
	}
	
	/**
	 * Gives the length of the entire list
	 * @return the size of the list
	 * @param head tells the method where to start counting
	 */
	public static int listLength(IntNode head) {
		
		int cnt = 0;
		IntNode cursor = head;
		
		while(cursor != null) {
			cnt++;
			cursor = cursor.getLink();
		}
		return cnt;
	}
	
	/**
	 * Searches the list for a node with same value as the 
	 * given one
	 * @return true if it finds a match, false otherwise
	 * @param data the data this function is looking for
	 * @param head tells the method where to start looking
	 */ 
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
	
	public static int listEvenNumber(IntNode head) {
		
		if(head == null) {
			return 0;
		}
		
		int even = 0;
		IntNode cursor = head;
		while(cursor != null) {
			
			if(cursor.getData() % 2 == 0) {
				even++;
			}
			cursor = cursor.getLink();
		}
		
		
		return even;
	}
	
	public void addToEnd(int newData) {

		IntNode cursor = this.getLink();
		
		if(cursor == null) {
			addNodeAfterThis(newData);
		}
		if(cursor != null) {
			while(cursor.getLink() != null) {

				cursor = cursor.getLink();
			}
		
			if(cursor.getLink() == null) {
				cursor.addNodeAfterThis(newData);
			}
		}

	}
	
	public static int sumLast(IntNode head, int num) {
		
		int sum = 0;
		int size = 0;
		IntNode cursor = head;
		
		while(cursor != null) {
			size++;
			cursor = cursor.getLink();
		}
		cursor = head;
		if(num > size) {
			
			while(cursor != null) {
				sum = sum + cursor.getData();
				cursor = cursor.getLink();
			}
		return sum;
		}
		
		else {
			
			for(int i = 0; i < (size - num); i++) {
				cursor = cursor.getLink();
			}
			
			for(int x = 0; x < num; x++) {
				
				sum = sum + cursor.getData();
				cursor = cursor.getLink();
			}
			return sum;
		}
	}
	
	public static IntNode copyOdd(IntNode head) {
		
		if(head == null) {
			return null;
		}
		
		else {
			IntNode cursor = head;
			IntNode oddList = new IntNode();
			IntNode temp = new IntNode();
			int x = 1;
			while(cursor != null) {
				
				if(cursor.getData() % 2 != 0) {
					temp.setData(cursor.getData());
					if(x == 1) {
						oddList.setData(cursor.getData());
					}
					else {
					oddList.addToEnd(cursor.getData());
					}
				}
				cursor = cursor.getLink();
				x++;
			}
			return oddList;
		}
		
	}
	
	public static IntNode removeAll(IntNode head, int e) {
		if(head == null) {
			return null;
		}
		else {
			IntNode cursor = head;
			if(cursor.getData() == e) {
				head = cursor.getLink();
			}
			
			while(cursor.getLink() != null) {

				while(cursor.getLink().getData() == e) {
					cursor.removeNodeAfterThis();
				}
				cursor = cursor.getLink();
			}
			return head;
		}
	}
	
	public static IntNode reverse (IntNode head) {
		
		IntNode cursor = head;
		IntNode cursor2 = head;
		IntNode reverseList = new IntNode();
		int count = 0;
		int x = 0;
		while(cursor.getLink() != null) {
			count++;
			cursor = cursor.getLink();
		}
		reverseList.setData(cursor.getData());
		cursor2 = reverseList;
		cursor = head;
		
		for(int y = 0; y < count; y++) {
			for(int i= 0; i < count - x - 1; i++) {
			
				cursor = cursor.getLink();
			}
			cursor2.addNodeAfterThis(cursor.getData());
			cursor2 = cursor2.getLink();
			cursor = head;
			x++;
		}

		return reverseList;
	}
	
	public static boolean hasCycle(IntNode head) {
		
		IntNode cursor = head;
		while(cursor != null) {
			
			if(cursor.getLink()== head) {
				return true;
			}
			cursor = cursor.getLink();
		}
		return false;
	}


}
