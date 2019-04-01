
public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = createTree();
		binaryTree.inorder();
		System.out.println("---------------");
		binaryTree.preorder();
		System.out.println("---------------");
		binaryTree.postorder();
		
		System.out.println("###################");
		
		displayInorder(binaryTree);
	}
	
	public static<T> BinaryTree<T> createTree(){
		BinaryTree<T> binaryTree= new BinaryTree<>();
		binaryTree.key = "a";
		binaryTree.insertRight("f", null);
		binaryTree.insertRight("c", null);
		binaryTree.getRightChild().insertLeft("e", null);
		
		binaryTree.insertLeft("b", null);
		binaryTree.getLeftChild().insertRight("d", null);
		return binaryTree;
	}
	
	public static<T> void displayInorder(BinaryTree<T> binaryTree) {
		if(binaryTree.leftChild != null)
			displayInorder(binaryTree.leftChild);
		System.out.println(binaryTree.key);
		if(binaryTree.rightChild != null)
			displayInorder(binaryTree.rightChild);
	}

}
