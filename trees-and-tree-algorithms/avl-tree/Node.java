package trees.AVLTree;

public class Node<Key extends Comparable<Key>, T> {

	Key key;
	T payload;
	Node<Key, T> parent, leftChild, rightChild;
	int leftHeight, rightHeight, height, balanceFactor;
	
	public Node(Key key, T payload, Node<Key, T> parent, Node<Key, T> leftChild, Node<Key, T> rightChild) {
		this.key = key;
		this.payload = payload;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.leftHeight = this.rightHeight = this.height = this.balanceFactor = 0;
	}
	
	public boolean isLeaf() {
		return !this.hasLeftChild() && !this.hasRightChild();
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}	
	
	public boolean hasBothChildren() {
		return this.hasLeftChild() && this.hasRightChild();
	}
	
	public boolean hasParent() {
		return this.parent != null;
	}
	
	public boolean isLeftChild() {
		return this.parent.leftChild == this;
	}
	
	public boolean isRightChild() {
		return this.parent.rightChild == this;
	}
	
	public void info() {
		String r = "";
		r += "Node with key " + this.key + ", has payload " + this.payload + ". \n";
		r += "Left height " + this.leftHeight + ", right height " + this.rightHeight + ". \n";
		r += "Balance factor " + this.balanceFactor + "\n";
		System.out.println(r);
	}
	
}

