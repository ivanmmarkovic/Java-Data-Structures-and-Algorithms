package binarySearchTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst = new BinarySearchTree(50);
		bst.put(30, null);
		bst.put(40, null);
		bst.put(45, null);
		bst.put(20, null);
		bst.put(25, null);
		bst.put(27, null);
		bst.put(15, null);
		
		bst.put(60, null);
		bst.put(70, null);
		bst.put(80, null);
		bst.put(75, null);
		
		bst.printBinarySearchTree();
		System.out.println();
		System.out.println("Size : " + bst.size());
		bst.delete(30);
		bst.printBinarySearchTree();
		System.out.println();
		System.out.println("Size : " + bst.size());
		
		
	}

}
