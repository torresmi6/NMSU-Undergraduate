import java.util.*;

public class LinkStack <E> implements StackInterface <E>{

	SNode <E> top;
	
	public void push(E e) {
		
		top = new SNode(e, top);
	}
	
	public E pop() {
		
		if(top == null) {
			throw new EmptyStackException();
		}
		
		E x = top.getData();
		top = top.getLink();
		return x;
	}
	
	public E top() {
		
		if(top == null) {
			throw new EmptyStackException();
		}
		
		else {
			E x = top.getData();
			return x;
		}
	}
	
	public int size() {
		
		return top.listLength();
	}
	
	public boolean isEmpty() {
		
		return top == null;
	}
}
