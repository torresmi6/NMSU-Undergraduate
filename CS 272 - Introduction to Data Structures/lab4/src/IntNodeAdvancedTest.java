
public class IntNodeAdvancedTest {

	public static void main(String[] args) {
		
		IntNode node1 = new IntNode(6);
		node1.addNodeAfterThis(5);
		node1.addNodeAfterThis(4);
		node1.addNodeAfterThis(3);
		node1.addNodeAfterThis(2);
		node1.addNodeAfterThis(1);
		
		IntNode node2 = new IntNode(10);
		node2.addNodeAfterThis(11);
		node2.addNodeAfterThis(12);
		node2.addNodeAfterThis(13);
		node2.addNodeAfterThis(14);
		node2.addNodeAfterThis(15);
		
		// Test Case 1
		// Should return 3 since 2, 4, and 6 are even in the list
		System.out.println("Test Case 1");
		System.out.println(node1.listEvenNumber(node1));
		System.out.println("");
		
		// Test Case 2
		// Should return summation of the last x numbers in the list
		// where x is user input
		System.out.println("Test Case 2");
		// Should return 9 since 5 + 4 = 9
		System.out.println(node1.sumLast(node1, 2));
		// Should return 12 since 5 + 4 + 3 = 12
		System.out.println(node1.sumLast(node1, 3));
		// Should return 21 since 9 is bigger than the list, which
		// adds up the entire list instead
		// 5 + 4 + 3 + 2 + 1 + 6 = 21
		System.out.println(node1.sumLast(node1, 9));
		System.out.println("");
		
		// Test Case 3
		// should return 
		System.out.println("Test Case 3");
		System.out.println(node1.copyOdd(node1).toString());
		System.out.println("");
		
		// Test Case 1
		// Should return 3 since 2, 4, and 6 are even in the list
		System.out.println("Test Case 4");
		System.out.println(node1.removeAll(node1, 29).toString());
		System.out.println(node1.removeAll(node1, 95).toString());
		System.out.println(node1.removeAll(node1, 9).toString());
		node1.addNodeAfterThis(59);
		node1.addNodeAfterThis(59);
		System.out.println(node1.toString());
		System.out.println(node1.removeAll(node1, 59).toString());
		System.out.println("");
		
		// Test Case 1
		// Should return 3 since 2, 4, and 6 are even in the list
		System.out.println("Test Case 5");
		System.out.println(node1.toString());
		System.out.println(node1.reverse(node1));
		
		// Test Case 1
		// Should return 3 since 2, 4, and 6 are even in the list
		System.out.println("Test Case 6");
		System.out.println(node2.toString());
		System.out.println(node2.reverse(node2));
		System.out.println("");
		
		// Test Case 1
		// Should return 3 since 2, 4, and 6 are even in the list
		System.out.println("Test Case 7");
		System.out.println(node1.hasCycle(node1));
		IntNode nodeCycle = new IntNode(5);
		nodeCycle.addNodeAfterThis(6);
		nodeCycle.addNodeAfterThis(7);
		nodeCycle.addNodeAfterThis(8);
		nodeCycle.addNodeAfterThis(9);
		IntNode cursorCycle = nodeCycle;
		while(cursorCycle.getLink() != null) {
			cursorCycle = cursorCycle.getLink();
		}
		cursorCycle.setLink(nodeCycle);
		
		System.out.println(nodeCycle.hasCycle(nodeCycle));

	}

}
