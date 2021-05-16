
public class IntNodeTest {

	public static void main(String[] args) {
		
		// Test Case 1
		// No argument constructor should set data to 0 and link to null
		
		IntNode node1 = new IntNode();
		System.out.println("Test Case 1");
		System.out.println("Data: " + node1.getData() + "   Link: " + node1.getLink());
		System.out.println("\n");
		
		// Test Case 2
		// Two argument constructor should set data and link to the given values
		
		IntNode node2 = new IntNode(5, node1);
		System.out.println("Test Case 2");
		System.out.println("Data: " + node2.getData() + "   Link: " + node2.getLink().getData());
		System.out.println("\n");
		
		// Test Case 3
		// Getters and Setters 
		
		System.out.println("Test Case 3");
		node1.setData(9);
		node1.setLink(node2);
		node2.setLink(null);
		
		System.out.println("Node1 Data: " + node1.getData() + "   Node1 Link: " 
		+ node1.getLink().getData() + "   Node2 Link: " + node2.getLink());
		
		node2.setData(80);
		
		System.out.println("Node1 Data: " + node1.getData() + "   Node1 Link: " 
		+ node1.getLink().getData() + "   Node2 Link: " + node2.getLink());
		
		System.out.println("\n");
		
		// Test Case 4
		// addNodeAfterThis should correctly place a given int into a node after the 
		// one used to call this method
		
		System.out.println("Test Case 4");
		node2.addNodeAfterThis(95);
		
		System.out.println("Node1 Data: " + node1.getData() + "   Node1 Link: " 
		+ node1.getLink().getData() + "   Node2 Link: " + node2.getLink().getData() + "   Node3 Link: " + node2.getLink().getLink());
		
		System.out.println("\n");
		
		// Test Case 5
		// toString should return all the nodes as one string
		
		System.out.println("Test Case 5");
		System.out.println(node1.toString());
		System.out.println(node2.toString());
		System.out.println(node2.getLink().toString());
		System.out.println("\n");
		
		// Test Case 6
		// removeNodeAfter should remove the node after the one used to call this method without breaking
		// the list. List should remove 80, keeping 9 and 95.
		
		System.out.println("Test Case 6");
		node1.removeNodeAfterThis();
		System.out.println(node1.toString());
		System.out.println("\n");
		
		// Test Case 7
		// listLength should return the size of the list.
		
		System.out.println("Test Case 7");
		System.out.println(node1.listLength(node1));
		
		node1.addNodeAfterThis(59);
		node1.addNodeAfterThis(29);
		node1.addNodeAfterThis(102);
		node1.addNodeAfterThis(5);
		node1.addNodeAfterThis(73);
		System.out.println(node1.listLength(node1));
		System.out.println("\n");
		
		// Test Case 8
		// search should return true is it correctly finds the given int and false otherwise
		
		System.out.println("Test Case 8");
		// 95 is in the list, should print true
		System.out.println(node1.search(node1, 95));
		// 80 was removed earlier, should print false
		System.out.println(node1.search(node1, 80));
		// 9 is in the list, but the head given is after 9, should print false
		System.out.println(node1.search(node2.getLink(), 9));
		System.out.println("\n");
		
		node1.addToEnd(6);
		System.out.println(node1.toString());
		System.out.println("\n");
		
		
	}

}
