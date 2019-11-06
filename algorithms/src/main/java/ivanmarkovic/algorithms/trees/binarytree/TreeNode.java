package ivanmarkovic.algorithms.trees.binarytree;

public class TreeNode<T> {
	
	private T key;
	private TreeNode<T> leftChild, rightChild;
	
	public TreeNode(T key) {
		this.key = key;
	}
	
	public TreeNode(T key, TreeNode<T> leftChild, TreeNode<T> rightChild) {
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public T getKey() {
		return key;
	}
	
	public void setKey(T key) {
		this.key = key;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(T key) {
		this.leftChild = new TreeNode<T>(key, this.leftChild, null);
	}
	
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(T key) {
		this.rightChild = new TreeNode<T>(key, null, this.rightChild);
	}
	
	public void preorder() {
		if(this == null)
			return;
		System.out.println(this.key);
		if(this.leftChild != null)
			this.leftChild.preorder();
		if(this.rightChild != null)
			this.rightChild.preorder();
	}
	
	public void inorder() {
		if(this == null)
			return;
		if(this.leftChild != null)
			this.leftChild.inorder();
		System.out.println(this.key);
		if(this.rightChild != null)
			this.rightChild.inorder();
	}
	
	public void postorder() {
		if(this == null)
			return;
		if(this.leftChild != null)
			this.leftChild.postorder();
		if(this.rightChild != null)
			this.rightChild.postorder();
		System.out.println(this.key);
	}
	
}
