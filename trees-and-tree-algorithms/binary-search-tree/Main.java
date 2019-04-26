package trees.binarySearchTree;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		bst.put(30, "string - 30");
		bst.put(20, "string - 20");
		bst.put(25, "string - 25");
		bst.put(40, "string - 40");
		bst.put(50, "string -  50");
		bst.put(35, "string - 35");
		
		System.out.println("Size : " + bst.size);
		bst.inorder();
		
		System.out.println(bst.contains(25));
		System.out.println(bst.contains(101));
		
		bst.delete(40);
		bst.inorder();
		System.out.println("---------------");
		bst.delete(30);
		bst.inorder();
		System.out.println(bst.root.key); // 35
		System.out.println("Size : " + bst.size);
	}

}
