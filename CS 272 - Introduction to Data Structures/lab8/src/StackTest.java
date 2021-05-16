
public class StackTest {

	public static void main(String[] args) {
		
		StackInterface <Integer> list1 = new LinkStack();
		StackInterface <Integer> list2 = new ArraylistStack();

		// Test case 1 - LinkStack
		// ensures the no argument constructor worked properly
		// 	and the list is empty. Should return true
		System.out.println("Test Case 1 - LinkStack");
		System.out.println(list1.isEmpty());
		System.out.println("");
		
		// Test Case 2 - LinkStack
		// ensures push adds an element to the list. isEmpty
		// 	should return false. Size should return 1.
		System.out.println("Test Case 2 - LinkStack");
		list1.push(2);
		System.out.println(list1.isEmpty());
		System.out.println(list1.size());
		System.out.println("");
		
		// Test Case 3 - LinkStack
		// ensures size and isEmpty still work when adding 
		// 	multiple elements at once
		//  	should return false and 4
		System.out.println("Test Case 3 - LinkStack");
		list1.push(5);
		list1.push(32);
		list1.push(13);
		System.out.println(list1.isEmpty());
		System.out.println(list1.size());
		System.out.println("");
		
		// Test Case 4 - LinkStack
		// ensures pop works properly
		// 	should return 13, and 3 as the size
		System.out.println("Test Case 4 - LinkStack");
		System.out.println(list1.pop());
		System.out.println(list1.size());
		System.out.println("");
		
		// Test Case 5 - LinkStack
		// ensures top works properly
		// should return 32 but size should remain as 3
		System.out.println("Test Case 5 - LinkStack");
		System.out.println(list1.top());
		System.out.println(list1.size());
		System.out.println("");
		
		// Test case 6 - ArrayStack
		// ensures the no argument constructor worked properly
		// 	and the list is empty. Should return true
		System.out.println("Test Case 6 - ArrayStack");
		System.out.println(list2.isEmpty());
		System.out.println("");
		
		// Test Case 7 - ArrayStack
		// ensures push adds an element to the list. isEmpty
		// 	should return false. Size should return 1.
		System.out.println("Test Case 7 - ArrayStack");
		list2.push(2);
		System.out.println(list2.isEmpty());
		System.out.println(list2.size());
		System.out.println("");
		
		// Test Case 8 - ArrayStack
		// ensures size and isEmpty still work when adding 
		// 	multiple elements at once
		//  	should return false and 4
		System.out.println("Test Case 8 - ArrayStack");
		list2.push(5);
		list2.push(32);
		list2.push(13);
		System.out.println(list2.isEmpty());
		System.out.println(list2.size());
		System.out.println("");
		
		// Test Case 9 - ArrayStack
		// ensures pop works properly
		// 	should return 13, and 3 as the size
		System.out.println("Test Case 9 - ArrayStack");
		System.out.println(list2.pop());
		System.out.println(list2.size());
		System.out.println("");
		
		// Test Case 10 - ArrayStack
		// ensures top works properly
		// should return 32 but size should remain as 3
		System.out.println("Test Case 10 - ArrayStack");
		System.out.println(list2.top());
		System.out.println(list2.size());
		System.out.println("");
		
	}

}
