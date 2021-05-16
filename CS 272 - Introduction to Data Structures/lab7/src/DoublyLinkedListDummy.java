
public class DoublyLinkedListDummy {

	DIntNode head = new DIntNode();
	DIntNode tail = new DIntNode();
	
	
	public DoublyLinkedListDummy() {
		
		head = new DIntNode();
		tail = new DIntNode();
		
		head.setNext(tail);
		tail.setPrev(head);;
	}
	
	public DIntNode getHead() {
		return head;
	}
	
	public DIntNode getTail() {
		return tail;
	}
	
	public void setHead(DIntNode node) {
		head = node;
	}
	
	public void setTail(DIntNode node) {
		tail = node;
	}
	
	// Time Complexity - O(n)
	public void addEnd(int element) {
		
		if(head.getNext() == tail) {
			DIntNode newNode = new DIntNode(element, head, tail);
			head.setNext(newNode);
			tail.setPrev(newNode);
		}
		
		else {
			DIntNode cursor = head.getNext();
			while(cursor.getNext() != tail) {
				cursor = cursor.getNext();
			}
			DIntNode newNode = new DIntNode(element, cursor, tail);
			cursor.setNext(newNode);
			tail.setPrev(newNode);
		}
		
	}
	
	// Time Complexity - O(1)
	public void removeFromHead() {
		
		if(head == null) {
			return;
		}
		
		head = head.getNext();
		head.setPrev(null);
		
	}
	
	public String toString() {
		
		String list = "(Forward)  ";
		
		for(DIntNode cursor = head.getNext(); cursor != tail; cursor = cursor.getNext()) {
			
			if(cursor.getNext() != tail) {
				list = list + cursor.getData() + "<->";
			}
			else {
				list = list + cursor.getData();
			}
		}

		String listB = "\n(Backward) ";
		
		for(DIntNode cursor = tail.getPrev(); cursor != head; cursor = cursor.getPrev()) {
			
			if(cursor.getPrev() != head) {
				listB = listB + cursor.getData() + "<->";
			}
			else {
				listB = listB + cursor.getData();
			}
		}
		
		list = list + listB;
		return list;
	}
	
	// Time complexity - O(n)
	public int countOccurrence(int e) {
		
		int count = 0;
		
		for(DIntNode cursor = head.getNext(); cursor != tail; cursor = cursor.getNext()) {
			
			if(cursor.getData() == e) {
				count++;
			}
		}
		return count;
	}
	
	public boolean removeAll(int e) {
		
		boolean answer = false;
		for(DIntNode cursor = head.getNext(); cursor != tail; cursor = cursor.getNext()) {
			
			if(cursor.getData() == e) {
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				answer = true;
			}
		}
		return answer;
	}
	
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		
		int size = 0;
		int index = 0;
		if(beginIdx >= 0 && beginIdx <= endIdx) {
			
			for(DIntNode cursor = head.getNext(); cursor != tail; cursor = cursor.getNext()) {
				
				size++;
			}
			
			if(beginIdx <= size) {

				DoublyLinkedListDummy subList = new DoublyLinkedListDummy();
				DIntNode cursor = head.getNext();
				for(int i = 0; i < beginIdx; i++) {
					cursor = cursor.getNext();
					
				}
				index = beginIdx;
				while(index <= endIdx) {
					
					subList.addEnd(cursor.getData());
					cursor = cursor.getNext();
					index++;
				}
				return subList;
			}
		}
		return null;

	}
	
	public void printStatistics() {
		int index = 0;
		boolean match = false;
		DIntNode cursor = new DIntNode();
		DIntNode cursor2 = new DIntNode();
		DoublyLinkedListDummy singleList = new DoublyLinkedListDummy();
		for(cursor = head.getNext(); cursor != tail; cursor = cursor.getNext()) {
			if(index == 0) {
				singleList.addEnd(cursor.getData());
			}
			else {
				for(cursor2 = singleList.getHead().getNext(); cursor2 != singleList.getTail(); cursor2 = cursor2.getNext()) {
					if(cursor.getData() == cursor2.getData()) {
						match = true;
						break;
					}
				}
				if(match == false) {
					singleList.addEnd(cursor.getData());
				}
			}
			match = false;
			index++;
		}
		
		System.out.println("Number     Occurrence");
		
		for(cursor = singleList.getHead().getNext(); cursor != singleList.getTail(); cursor = cursor.getNext()) {
			
			System.out.println(cursor.getData() + "          " + countOccurrence(cursor.getData()));
		}
	}
}
