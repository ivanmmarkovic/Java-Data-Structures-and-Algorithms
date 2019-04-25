package trees.binarySearchTree;

public class Node<Key extends Comparable<Key>, T> {

	Key key;
	T payload;
	Node<Key, T> parent, leftChild, rightChild;
	
	public Node(Key key, T payload, Node<Key, T> parent, Node<Key, T> leftChild, Node<Key, T> rightChild) {
		this.key = key;
		this.payload = payload;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}	
	
}
