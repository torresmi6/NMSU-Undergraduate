
public class SNode <E>{

	E data;
	SNode <E> link;
	
	public SNode() {
		
		link = null;
	}

	public SNode(E newData, SNode <E> next) {
		
		data = newData;
		link = next;
	}
	
	public SNode<E> getLink(){
		return link;
	}
	
	public E getData() {
		return data;
	}
	
	public int listLength() {
		
		int length = 0;
		SNode <E> cursor = new SNode <E> (data, link);
		
		while(cursor != null) {
			length++;
			cursor = cursor.getLink();
		}
		
		return length;
	}
}
