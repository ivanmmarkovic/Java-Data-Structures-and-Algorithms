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
	
	public boolean isLeaf() {
		return this.leftChild == null && this.leftChild== null;
	}
	
	public boolean isLeftChild() {
		return this.parent.leftChild == this;
	}
	
	public boolean isRightChild() {
		return this.parent.rightChild == this;
	}
	
	public boolean hasBothChildren() {
		return this.leftChild != null && this.rightChild != null;
	}
	
	public boolean hasParent() {
		return this.parent != null;
	}
	
	public boolean isRoot() {
		return this.parent == null;
	}
	
	public BinarySearchTree findMin() {
		if(this.hasLeftChild())
			return this.leftChild.findMin();
		else
			return this;
	}
	
	public BinarySearchTree findMax() {
		if(this.hashRightChild())
			return this.rightChild.findMax();
		else
			return this;
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
	
	public BinarySearchTree delete(int key) {
		BinarySearchTree bst = this.get(key);
		BinarySearchTree treeToReturn = null;
		if(bst == null)
			treeToReturn = null;
		else {
			if(bst.isLeaf()) {
				if(bst.isRoot()) {
					treeToReturn = bst;
					bst = null;
				}
				else if(bst.isLeftChild()) {
					treeToReturn = bst;
					bst.parent.leftChild = null;
					bst = null;
				}
				else if(bst.isRightChild()) {
					treeToReturn = bst;
					bst.parent.rightChild =null;
					bst = null;
				}
			}
			else if(bst.hasBothChildren()) {
				treeToReturn = this.leftChild.findMax();
				Integer tmpKey = treeToReturn.key;
				Payload tmpPayload = treeToReturn.payload;
				this.delete(treeToReturn.key);
				this.key = tmpKey;
				this.payload = tmpPayload;
			}
			else if(bst.hasLeftChild()) {
				treeToReturn = bst;
				if(bst.isRoot()) {
					bst.leftChild.parent = null;
				}
				else if(bst.isRightChild()) {
					bst.parent.rightChild = bst.leftChild;
				}
				else if(bst.isLeftChild()) {
					bst.parent.leftChild = bst.leftChild;
				}
				bst = null;
			}
			else if(bst.hashRightChild()) {
				treeToReturn = bst;
				if(bst.isRoot()) {
					bst.rightChild.parent = null;
				}
				else if(bst.isRightChild()) {
					bst.parent.rightChild = bst.rightChild;
				}
				else if(bst.isLeftChild()) {
					bst.parent.leftChild = bst.rightChild;
				}
				bst = null;
			}
		}
		return treeToReturn;
	}
	
	public void printBinarySearchTree() {
		if(this.hasLeftChild())
			this.leftChild.printBinarySearchTree();
		System.out.println(this.key);
		if(this.hashRightChild())
			this.rightChild.printBinarySearchTree();
	}
	
}
