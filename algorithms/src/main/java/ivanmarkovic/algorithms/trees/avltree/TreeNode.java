package ivanmarkovic.algorithms.trees.avltree;


import java.util.NoSuchElementException;

public class TreeNode {
	
	TreeNode parent, leftChild, rightChild;
	int key, leftSubtreeHeight, rightSubtreeHeight, balanceFactor;
	
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode(int key) {
		this();
		this.key = key;
	}
	
	public TreeNode(int key, TreeNode parent){
		this();
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

}

