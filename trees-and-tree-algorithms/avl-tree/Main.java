package trees.AVLTree;

public class Main {

	public static void main(String[] args) {
		AVLTree<Integer, String> avl = new AVLTree<Integer, String>();
		avl.put(30, "string - 30");
		avl.getNode(30).info();
		System.out.println("########################");
		
		avl.put(20, "string - 20");
		avl.getNode(30).info();
		avl.getNode(20).info();
		System.out.println("########################");
		
		avl.put(25, "string - 25");
		avl.getNode(30).info();
		avl.getNode(20).info();
		avl.getNode(25).info();
		System.out.println("########################");
		
		
	}

}
