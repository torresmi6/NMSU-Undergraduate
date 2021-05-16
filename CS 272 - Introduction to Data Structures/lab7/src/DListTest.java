
public class DListTest {

	public static void main(String[] args) {
		
		// Test Case 1
		// Tests if the no argument constructor works properly
		// toString should return an empty list
		System.out.println("Test Case 1");
		DoublyLinkedListDummy list1 = new DoublyLinkedListDummy();
		System.out.println(list1.toString());
		
		// Test Case 2
		// Tests if method addEnd works properly
		// List should be 1, 2, 3, 1, 3, 3
		System.out.println("\nTest Case 2");
		list1.addEnd(1);
		list1.addEnd(2);
		list1.addEnd(3);
		list1.addEnd(1);
		list1.addEnd(3);
		list1.addEnd(3);
		
		System.out.println(list1.toString());
		
		// Test Case 3
		// Tests if method countOccurence works properly
		// input 1 should return 2, input 2 should return 1, input 3 
		//    should return 3. input 5 should return 0
		System.out.println("\nTest Case 3");
		System.out.println(list1.countOccurrence(1));
		System.out.println(list1.countOccurrence(2));
		System.out.println(list1.countOccurrence(3));
		System.out.println(list1.countOccurrence(5));
		
		// Test Case 4
		// Tests if the method removeAll works properly
		// removeAll(1) should return true
		// removeAll(5) should return false
		// List should now be 2, 3, 3, 3
		System.out.println("\nTest Case 4");
		System.out.println(list1.removeAll(1));
		System.out.println(list1.removeAll(5));
		System.out.println(list1.toString());
		
		// Test Case 5
		// Tests if the method subList works properly
		// input 0, 2 should return 2, 3, 3
		// input 1, 2 should return 3, 3
		// input 3, 3 should return 3
		System.out.println("\nTest Case 5");
		System.out.println(list1.subList(0, 2).toString());
		System.out.println(list1.subList(1, 2).toString());
		System.out.println(list1.subList(3, 3).toString());
		
		// Test Case 6
		// Tests if the method printStatistics works properly
		// should print each number once, with their occurrence
		System.out.println("\nTest Case 6");
		list1.printStatistics();
		list1.addEnd(7);
		list1.addEnd(6);
		list1.addEnd(5);
		list1.addEnd(7);
		System.out.println("\n");
		list1.printStatistics();
	}

}
