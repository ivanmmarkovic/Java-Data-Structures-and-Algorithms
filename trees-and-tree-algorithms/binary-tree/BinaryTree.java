
public class BinaryTree<T> {

	String key;
	T payload;
	BinaryTree<T> leftChild, rightChild;
	
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryTree(String key) {
		this.key = key;
	}
	
	public BinaryTree(String key, T payload) {
		this.key = key;
		this.payload = payload;
	}
	
	public BinaryTree(String key, T payload, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
		this.key = key;
		this.payload = payload;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public void setRootValue(String key) {
		this.key = key;
	}
	
	public String getRootValue() {
		return this.key;
	}
	
	public void insertLeft(String key, T payload) {
		this.leftChild = new BinaryTree(key, payload, this.leftChild, null);
	}
	
	public void insertRight(String key, T payload){
		this.rightChild = new BinaryTree(key, payload, null, this.rightChild);
	}
	
	public BinaryTree<T> getLeftChild(){
		return this.leftChild;
	}
	
	public BinaryTree<T> getRightChild(){
		return this.rightChild;
	}
	
}
