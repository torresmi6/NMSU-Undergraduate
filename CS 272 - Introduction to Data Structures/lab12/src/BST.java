
/**
 *  Node for Binary Tree
 * 
 * @author Huiping Cao
 */
class BSTNode{
	private int data;   //the element value for this node
	private BST left;	//the left child of this node
	private BST right;	//the right child of this node
	
	/**
	 * No-argument constructor
	 */
	public BSTNode(){}
	
	/**
	 * Constructor with the initial element
	 * @param initData: the initial element
	 */
	public BSTNode(int initData){
		data = initData; 
		left = new BST();
		right = new BST();
	}
	
	/**
	 * Constructor with the initial element, initial left and right children
	 * @param initData: the initial element
	 * @param initParent: the initial parent tree
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public BSTNode(int initData, BST initLeft, BST initRight){
		data = initData;
		left = initLeft;
		right = initRight;
	}

	/**
	 * Evaluate whether this node is a leaf node or not
	 * @return true if it is a leaf node; otherwise, return false.
	 */
	public boolean isLeaf()
	{
		return (((left==null)||(left!=null && left.root==null))
				&&((right==null)||(right!=null && right.root==null)));
	}
	
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param set the element in this node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left child
	 */
	public BST getLeft() {
		return left;
	}

	/**
	 * @param the left child to be set
	 */
	public void setLeft(BST left) {
		this.left = left;
	}

	/**
	 * @return the right child
	 */
	public BST getRight() {
		return right;
	}

	/**
	 * @param the right child to be set
	 */
	public void setRight(BST right) {
		this.right = right;
	}
	
	
	/**
	 * Convert this BTNode to a string
	 */
	public String toString()
	{
		String str="";
		
		if((left==null)||(left!=null && left.root==null)) str +="(null)";
		else str +="("+left.root.getData()+")";
		
		str += data;
		
		if((right==null)||(right!=null&&right.root==null)) str +="(null)";
		else str +="("+right.root.getData()+")";
		
		return str;
	}
}


/**
 * The class for Binary Search Tree
 * @author Huiping Cao
 *
 */
public class BST {
	protected BSTNode root; //the tree root
	
	
	/**
	 * Get the left subtree of this tree
	 * @return the left subtree of this tree
	 */
	private BST getLeftSubtree(){
		return root.getLeft();
	}
	
	/**
	 * Get the right subtree of this tree
	 * @return the right subtree of this tree
	 */
	private BST getRightSubtree(){
		return root.getRight();
	}
	
	/**
	 * Print the tree using in-order traversal strategy
	 */
	public void inOrderPrt(){
		inOrderPrt(0);
	}
	
	/**
	 * private, recursive function
	 *     I slightly changed the method to print right subtree first
	 *     It is to make the display more easier to read
	 * 
	 * @param node
	 * @param indentation
	 * @param branch
	 */
	private void inOrderPrt(int indentation){
		if(root!=null){
			if(getRightSubtree()!=null) getRightSubtree().inOrderPrt(indentation+1);
			
			for(int i=0;i<indentation*4;i++) System.out.print(" ");
			
			System.out.println(root.getData());
			
			if(getLeftSubtree()!=null) getLeftSubtree().inOrderPrt(indentation+1);
		}
	}
	
	
	/**
	 * Debug function, print the tree for debugging purpose
	 */
	public String toString()
	{
		if(root!=null) return root.toString();
		else return null;
	}
	
	///////////////////////////////////////
    ///////////////////////////////////////
	// Please add the functions required for your lab homework here.
	
	// inserts a new node into the tree, in order with duplicate verification
	// @param e the data to be stored in the new node
	// @return true if successful, false if duplicate
	public boolean insert (int e) {
		
		if(root == null) {
			root = new BSTNode(e, new BST(), new BST());
			return true;
		}
		
		if(e == root.getData()) {
			return false;
		}
		
		if(e < root.getData()) {
			return root.getLeft().insert(e);
			
		}
		else {
			return root.getRight().insert(e);
			
		}
	}
	
	// removes the node in the tree containing the given data
	// @param e the data  of the node to be removed
	// @return true if successful, false if not found
	public boolean remove (int e) {
		
		if(root == null) {
			return false;
		}
		
		if(e == root.getData()) {
			
			if(root.getLeft().root == null && root.getRight().root == null) {
				root = null;
			}
			else if(root.getLeft().root == null && root.getRight().root != null) {
				root = root.getRight().root;
			}
			else if(root.getLeft().root != null && root.getRight().root == null) {
				root = root.getLeft().root;
			}
			else if(root.getLeft().root != null && root.getRight().root != null) {
				int maxDataLeft = root.getLeft().removeMax();
				root.setData(maxDataLeft);
			}
			return true;
		}
		
		if(e < root.getData()) {
			return getLeftSubtree().remove(e);
		}
		else {
			return getRightSubtree().remove(e);
		}
	}
	
	// removes and returns the max value in the given subtree
	// @return the data of the node that was removed
	public int removeMax() {
		
		int maxData;
		if(getRightSubtree().root == null) {
			maxData = root.getData();
			root = getLeftSubtree().root;
			return maxData;
		}
		else {
			return getRightSubtree().removeMax();
		}
	}
	
	// searches the tree for the given element recursively
	// @param e the data of the node the function will search for
	// @return the node that contains the given data
	public BSTNode searchRecursion(int e) {
		
		if(root == null) {
			return null;
		}
		
		if(e == root.getData()) {
			return root;
		}
		
		if(e < root.getData()) {
			return root.getLeft().searchRecursion(e);
		}
		else {
			return root.getRight().searchRecursion(e);
		}
	}
	
	// searches the tree for the given element non recursively
	// @param e the data of the node the function will search for
	// @return the node that contains the given data
	public BSTNode searchNonRecursion(int e) {
		
		BSTNode cursor = root;
		while(cursor != null) {

			if(e == cursor.getData()) {
				return cursor;
			}
			
			if(e < cursor.getData()) {
				cursor = cursor.getLeft().root;
			}
			else {
				cursor = cursor.getRight().root;
			}
		}
		return null;
	}
	
	// Traverses the tree and adds all of the nodes' values together
	// @return the summation of the tree
	public int sum() {
		
		if(root == null) {
			return 0;
		}
		
		return root.getData() + root.getLeft().sum() + root.getRight().sum();
	}
	/**
	 * Test cases provided by the instructor
	 * @throws Exception
	 */
	private static void test1() throws Exception{
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		
		boolean rc = true;
		
		//test 1: insert method, and test 2 in-order traversal
		rc = tree.insert(12); System.out.println("\nInsert 12, inserted="+rc+", after adding 12:"); tree.inOrderPrt();
		rc = tree.insert(6);  System.out.println("\nInsert 6, inserted="+rc+", after adding 6:"); tree.inOrderPrt();
		rc = tree.insert(19); System.out.println("\nInsert 19, inserted="+rc+", after adding 19:"); tree.inOrderPrt();
		rc = tree.insert(4);  System.out.println("\nInsert 4, inserted="+rc+", after adding 4:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8, inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(16); System.out.println("\nInsert 16, inserted="+rc+", after adding 16:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8 (second), inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(5);  System.out.println("\nInsert 5, inserted="+rc+", after adding 5:"); tree.inOrderPrt();
		rc = tree.insert(9);  System.out.println("\nInsert 9, inserted="+rc+", after adding 9:"); tree.inOrderPrt();
		rc = tree.insert(20);  System.out.println("\nInsert 20, inserted="+rc+", after adding 20:"); tree.inOrderPrt();
		
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
		//test 3: search method
		BSTNode node = tree.searchRecursion(6);
		System.out.println("searchRecursion 6, node="+node);
		node = tree.searchRecursion(22);
		System.out.println("searchRecursion 22, node="+node);
		node = tree.searchRecursion(8);
		System.out.println("searchRecursion 8, node="+node+"\n");
		
		node = tree.searchNonRecursion(6);
		System.out.println("searchNonRecursion 6, node="+node);
		node = tree.searchNonRecursion(22);
		System.out.println("searchNonRecursion 22, node="+node);
		node = tree.searchNonRecursion(8);
		System.out.println("searchNonRecursion 8, node="+node);
		
		//test 4: remove method
		rc = tree.remove(30); //test case 0: e does not exist
		System.out.println("\nRemove 30, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(20); //test case 1: leaf
		System.out.println("\nRemove 20, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(4); //test case 2: left is empty
		System.out.println("\nRemove 4, rc="+rc);
		tree.inOrderPrt();
		
		
		rc = tree.remove(19); //test case 3: right is empty
		System.out.println("\nRemove 19, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(6); //test case 4: no subtree is empty
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(12); //more tests: remove root
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(5); //more tests
		System.out.println("\nRemove 5, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		rc = tree.remove(16); //more tests
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("\nAdding a series of numbers:");
		tree.insert(30);
		tree.insert(20);tree.insert(10);tree.insert(25);tree.insert(28);tree.insert(24);
		tree.insert(11);tree.insert(5);tree.insert(11);tree.insert(12);
		tree.insert(50);tree.insert(40);tree.insert(35);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.print("sum="+tree.sum()+"\n");
		System.out.print("\n\n");
		
		System.out.println("\nRemove 20 (removeNode case 4):");
		tree.remove(20);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("Inorder traversal results: ");
		tree.inOrderPrt();
		System.out.print("\n");
		System.out.print("sum="+tree.sum()+"\n");
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//You need to let your program pass the  test cases in this function
		test1(); 
		
		//You can add your own test cases here. 
		System.out.println();
		BST tree1 = new BST();
		
		// Tests insert; true
		System.out.println("3 inserted: " + tree1.insert(3) + "\nTree: \n");
		tree1.inOrderPrt();
		
		// Tests multiple insertions; Tree should contain 3, 10, 1, 7
		System.out.println("10 inserted: " + tree1.insert(10));
		System.out.println("1 inserted: " + tree1.insert(1));
		System.out.println("7 inserted: " + tree1.insert(7) + "\nTree: \n");
		tree1.inOrderPrt();
		
		// Tests removal; 7 = true 13 = false
		System.out.println("\n7 removed: " + tree1.remove(7));
		System.out.println("13 removed: " + tree1.remove(13));
		
		// Tests both search functions; 3 Node should be printed, 20 is null
		System.out.println("\nSearch(Non-Recursion) 3 Node: " + tree1.searchNonRecursion(3));
		System.out.println("Search(Non-Recursion) 20 Node: " + tree1.searchNonRecursion(20));
		
		System.out.println("\nSearch(Recursion) 3 Node: " + tree1.searchRecursion(3));
		System.out.println("Search(Recursion) 20 Node: " + tree1.searchRecursion(20));
		
		// Tests sum; sum of 10, 3, 1 is 14; Second test sum is 73
		System.out.println("\nCurrent Tree:\n");
		tree1.inOrderPrt();
		System.out.println("\nSum: " + tree1.sum());
		
		tree1.insert(5); tree1.insert(9); tree1.insert(30); tree1.insert(15);
		System.out.println("\nTree after inserting 5, 9, 30, 15:\n");
		tree1.inOrderPrt();
		System.out.println("\nSum: " + tree1.sum());
	}

}
