
public class Main {

	public static void main(String[] args) {

		BinaryTree<Integer> binaryTree = createTree();
		
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

}
