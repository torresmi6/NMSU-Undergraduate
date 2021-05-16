import java.util.*;

public class ArraylistStack <E> implements StackInterface <E> {

	ArrayList<E> list = new ArrayList<E> ();
	
	public void push(E e) {

		list.add(e);
	}
	
	public E pop() {
		
		if(list.isEmpty() == true) {
			throw new EmptyStackException();
		}
		else {
			E x = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return x;
		}
	}
	
	public E top() {
		
		if(list.isEmpty() == true) {
			throw new EmptyStackException();
		}
		else {
			E x = list.get(list.size() - 1);
			return x;
		}
	}
	
	public int size() {
		
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
}
