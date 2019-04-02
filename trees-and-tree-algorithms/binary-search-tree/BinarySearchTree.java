package binarySearchTree;

public class BinarySearchTree {

	Integer key;
	Payload payload;
	BinarySearchTree leftChild, rightChild, parent;
	public BinarySearchTree(int key) {
		this.key = key;
		this.payload = null;
		this.leftChild = this.rightChild = null;
		this.parent = null;
	}
	
	public BinarySearchTree(int key, Payload payload, BinarySearchTree parent) {
		this.key = key;
		this.parent = parent;
		this.leftChild = this.rightChild = null;
		this.payload = payload;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hashRightChild() {
		return  this.rightChild != null;
	}
	
	public BinarySearchTree get(int key) {
		if(this.key == null)
			return null;
		else if(this.key == key)
			return this;
		else if(this.key > key) {
			if(this.hasLeftChild())
				return this.leftChild.get(key);
			else
				return null;
		}
		else if(this.key < key) {
			if(this.hashRightChild())
				return this.rightChild.get(key);
			else
				return null;
		}
		return null;
	}
	
	public void put(int key, Payload payload) {
		if(this.key == null) {
			this.key = key;
			this.payload = payload;
		}
		else if(this.key == key) {
			this.payload = payload;
		}
		else if(this.key > key) {
			if(this.hasLeftChild())
				this.leftChild.put(key, payload);
			else 
				this.leftChild = new BinarySearchTree(key, payload, this);
		}
		else if(this.key < key) {
			if(this.hashRightChild())
				this.rightChild.put(key, payload);
			else
				this.rightChild = new BinarySearchTree(key, payload, this);
		}
	}
	
	
}
