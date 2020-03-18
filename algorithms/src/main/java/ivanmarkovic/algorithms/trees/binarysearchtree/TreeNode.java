package ivanmarkovic.algorithms.trees.binarysearchtree;


import java.util.NoSuchElementException;

public class TreeNode {
	
	TreeNode parent, leftChild, rightChild;
	int key;
	
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode(int key) {
		this.key = key;
	}
	
	public TreeNode(int key, TreeNode parent){
		this.key = key;
		this.parent = parent;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	public boolean isLeaf() {
		return !this.hasLeftChild() && !this.hasRightChild();
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
	
	public TreeNode findMin() {
		if(this.hasLeftChild())
			return this.leftChild.findMin();
		else
			return this;
	}
	
	public TreeNode findMax() {
		if(this.hasRightChild())
			return this.rightChild.findMax();
		else
			return this;
	}
	
	public void put(int key) {
		if(this.key == key)
			return;
		else if(this.key > key)
			if(this.hasLeftChild())
				this.leftChild.put(key);
			else
				this.leftChild = new TreeNode(key, this);
		else
			if(this.hasRightChild())
				this.rightChild.put(key);
			else
				this.rightChild = new TreeNode(key, this);
	}

	public TreeNode get(int key) {
		if(this.key == key)
			return this;
		else if(this.key > key)
			if(this.hasLeftChild())
				return this.leftChild.get(key);
			else
				throw new NoSuchElementException("Node with key " + key + " doesn't exists");
		else
			if(this.hasRightChild())
				return this.rightChild.get(key);
			else
				throw new NoSuchElementException("Node with key " + key + " doesn't exists");
	}

	public boolean contains(int key) {
		if(this.key == key)
			return true;
		else if(this.key > key)
			if(this.hasLeftChild())
				return this.leftChild.contains(key);
			else
				return false;
		else
			if(this.hasRightChild())
				return this.rightChild.contains(key);
			else
				return false;
	}

}

