package trees.binaryTree;

public class BinaryTree<T> {
	
	Node<T> root;
	public BinaryTree() {
		// TODO Auto-generated constructor stub
		this.root = null;
	}
	
	public void setRootValue(T t) {
		this.root = new Node<T>(t, null, null);
	}
	
	public T getRootValue() {
		return this.root.payload;
	}
	
	public void insertLeft(T t) {
		if(this.root == null)
			this.root = new Node<T>(t, null, null);
		else {
			this.root.leftChild = new Node<T>(t, this.root.leftChild, null);
		}
	}
	
	public void insertRight(T t) {
		if(this.root == null)
			this.root = new Node<T>(t, null, null);
		else {
			this.root.rightChild = new Node<T>(t, null, this.root.rightChild);
		}
	}
	
	public Node<T> getLeftChild(){
		return this.root.leftChild;
	}
	
	public Node<T> getRightChild(){
		return this.root.rightChild;
	}
}
