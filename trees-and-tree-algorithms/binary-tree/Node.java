package trees.binaryTree;

public class Node<T> {

	T payload;
	Node<T> leftChild, rightChild;
	
	public Node(T payload, Node<T> leftChild, Node<T> rightChild) {
		this.payload = payload;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	
}
