package ivanmarkovic.algorithms.trees.binarysearchtree;

public class BstNode {
	
	Integer key;
	BstNode parent, leftChild, rightChild;
	
	public BstNode(Integer key, BstNode parent, BstNode leftChild, BstNode rightChild) {
		this.key = key;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public BstNode(Integer key, BstNode parent) {
		this.key = key;
		this.parent = parent;
	}
	
	private boolean isRoot() {
		return this.parent == null;
	}
	
	public boolean isLeftChild() {
		return this.parent.leftChild == this;
	}
	
	public boolean isRightChild() {
		return this.parent.rightChild == this;
	}
	
	private boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	private boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	private boolean hasBothChildren() {
		return this.hasLeftChild() && this.hasRightChild();
	}
	
	public boolean isLeaf() {
		return !this.hasLeftChild() && !this.hasRightChild();
	}
	
	public void put(int key) {
		if(this.key == null || this.key == key)
			this.key = key;
		else if(this.key > key) {
			if(hasLeftChild())
				this.leftChild.put(key);
			else
				this.leftChild = new BstNode(key, this);
		}
		else {
			if(hasRightChild())
				this.rightChild.put(key);
			else
				this.rightChild = new BstNode(key, this);
		}
	}
	
	public BstNode get(int key) throws NodeNotFoundException {
		if(this == null)
			throw new NodeNotFoundException(key);
		if(this.key == null)
			throw new NodeNotFoundException(key);
		if(this.key == key)
			return this;
		else if(this.key > key)
			if(hasLeftChild())
				return this.leftChild.get(key);
			else
				return null;
		else
			if(hasRightChild())
				return this.rightChild.get(key);
			else
				return null;
	}
	
	public void delete(int key) throws NodeNotFoundException {
		BstNode toDelete = this.get(key);
		if(toDelete.isLeaf()) {
			if(!toDelete.isRoot()) {
				if(toDelete.isLeftChild())
					toDelete.parent.leftChild = null;
				else
					toDelete.parent.rightChild = null;
			}
		}
		else if(toDelete.hasBothChildren()) {
			BstNode tmp = toDelete.leftChild.findMax();
			toDelete.delete(tmp.key);
			toDelete.key = tmp.key;
		}
		else if(toDelete.hasLeftChild()) {
			if(toDelete.isRoot())
				this.leftChild.parent = null;
			else {
				if(toDelete.isLeftChild()) {
					toDelete.leftChild.parent = toDelete.parent;
					toDelete.parent.leftChild = toDelete.leftChild;
				}
				else {
					toDelete.leftChild.parent = toDelete.parent;
					toDelete.parent.rightChild = toDelete.leftChild;
				}
			}
		}
		else {
			if(toDelete.isRoot())
				toDelete.rightChild.parent = null;
			else {
				if(toDelete.isLeftChild()) {
					toDelete.rightChild.parent = toDelete.parent;
					toDelete.parent.leftChild = toDelete.leftChild;
				}
				else {
					toDelete.rightChild.parent = toDelete.parent;
					toDelete.parent.rightChild = toDelete.leftChild;
				}
			}
		}
	}
	
	public boolean hasNode(int key) {
		if(this == null)
			return false;
		if(this.key == null)
			return false;
		if(this.key == key)
			return true;
		else if(this.key > key)
			if(hasLeftChild())
				return this.leftChild.hasNode(key);
			else
				return false;
		else
			if(hasRightChild())
				return this.rightChild.hasNode(key);
			else
				return false;
	}
	
	public BstNode findMin() {
		if(this.hasLeftChild())
			return this.leftChild.findMin();
		else
			return this;
	}
	
	public BstNode findMax() {
		if(this.hasRightChild())
			return this.rightChild.findMax();
		else
			return this;
	}
	
	public int size() {
		if(this == null)
			return 0;
		int count = 1;
		if(hasLeftChild())
			count += this.leftChild.size();
		if(hasRightChild())
			count += this.rightChild.size();
		return count;
	}

	
}
