package ivanmarkovic.algorithms.trees.avltree;

public class AVLTreeNode {
	
	Integer key; 
	int balanceFactor, leftSubtreeHeight, rightSubtreeHeight;
	AVLTreeNode parent, leftChild, rightChild;
	
	public AVLTreeNode(Integer key, AVLTreeNode parent, AVLTreeNode leftChild, AVLTreeNode rightChild) {
		this.key = key;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public AVLTreeNode(Integer key, AVLTreeNode parent) {
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
			else {
				this.leftChild = new AVLTreeNode(key, this);
				this.updateHeightAfterInsertion(this.leftChild);
			}
		}
		else {
			if(hasRightChild())
				this.rightChild.put(key);
			else {
				this.rightChild = new AVLTreeNode(key, this);
				this.updateHeightAfterInsertion(this.rightChild);
			}
		}
	}
	
	public AVLTreeNode get(int key) throws NodeNotFoundException {
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
		AVLTreeNode toDelete = this.get(key);
		AVLTreeNode parent;
		if(toDelete.isLeaf()) {
			if(!toDelete.isRoot()) {
				parent = toDelete.parent;
				if(toDelete.isLeftChild())
					toDelete.parent.leftChild = null;
				else
					toDelete.parent.rightChild = null;
				parent.updateHeightAfterDeletion();
			}
		}
		else if(toDelete.hasBothChildren()) {
			AVLTreeNode tmp = toDelete.leftChild.findMax();
			toDelete.delete(tmp.key);
			toDelete.key = tmp.key;
		}
		else if(toDelete.hasLeftChild()) {
			if(toDelete.isRoot())
				this.leftChild.parent = null;
			else {
				parent = toDelete.parent;
				if(toDelete.isLeftChild()) {
					toDelete.leftChild.parent = toDelete.parent;
					toDelete.parent.leftChild = toDelete.leftChild;
				}
				else {
					toDelete.leftChild.parent = toDelete.parent;
					toDelete.parent.rightChild = toDelete.leftChild;
				}
				parent.updateHeightAfterDeletion();
			}
		}
		else {
			if(toDelete.isRoot())
				toDelete.rightChild.parent = null;
			else {
				parent = toDelete.parent;
				if(toDelete.isLeftChild()) {
					toDelete.rightChild.parent = toDelete.parent;
					toDelete.parent.leftChild = toDelete.leftChild;
				}
				else {
					toDelete.rightChild.parent = toDelete.parent;
					toDelete.parent.rightChild = toDelete.leftChild;
				}
				parent.updateHeightAfterDeletion();
			}
		}
	}
	
	private void updateHeightAfterInsertion(AVLTreeNode node) {
		if(node.isLeftChild())
			this.leftSubtreeHeight += 1;
		if(node.isRightChild())
			this.rightSubtreeHeight += 1;
		this.balanceFactor = this.leftSubtreeHeight - this.rightSubtreeHeight;
		if(this.balanceFactor > 1 || this.balanceFactor < -1) {
			this.rebalance();
			return;
		}
		if(this.balanceFactor != 0 && this.parent != null) {
			this.parent.updateHeightAfterInsertion(this);
		}
	}
	
	private void updateHeightAfterRotation() {
		if(this.hasLeftChild())
			this.leftSubtreeHeight = Math.max(this.leftChild.leftSubtreeHeight, this.leftChild.rightSubtreeHeight) + 1;
		else
			this.leftSubtreeHeight = 0;
		if(this.hasRightChild())
			this.rightSubtreeHeight = Math.max(this.rightChild.leftSubtreeHeight, this.rightChild.rightSubtreeHeight) + 1;
		else
			this.rightSubtreeHeight = 0;
		this.balanceFactor = this.leftSubtreeHeight - this.rightSubtreeHeight;
		if(this.balanceFactor != 0 && this.parent != null) {
			this.parent.updateHeightAfterInsertion(this);
		}
	}
	
	private void updateHeightAfterDeletion() {
		if(this.hasLeftChild())
			this.leftSubtreeHeight = Math.max(this.leftChild.leftSubtreeHeight, this.leftChild.rightSubtreeHeight) + 1;
		else
			this.leftSubtreeHeight = 0;
		if(this.hasRightChild())
			this.rightSubtreeHeight = Math.max(this.rightChild.leftSubtreeHeight, this.rightChild.rightSubtreeHeight) + 1;
		else
			this.rightSubtreeHeight = 0;
		this.balanceFactor = this.leftSubtreeHeight - this.rightSubtreeHeight;
		if(this.balanceFactor > 1 || this.balanceFactor < -1) {
			this.rebalance();
			return;
		}
		if(this.balanceFactor != 0 && this.parent != null) {
			this.parent.updateHeightAfterInsertion(this);
		}
	}
	
	private void rebalance() {
		if(this.balanceFactor > 0) {
			if(this.leftChild.balanceFactor < 0) {
				this.leftChild.rotateLeft();
				this.rotateRight();
			}
			else
				this.rotateRight();
		}
		else {
			if(this.rightChild.balanceFactor > 0) {
				this.rightChild.rotateRight();
				this.rotateLeft();
			}
			else
				this.rotateLeft();
		}
	}
	
	private void rotateLeft() {
		AVLTreeNode oldRoot = this;
		AVLTreeNode newRoot = this.rightChild;
		oldRoot.rightChild = newRoot.leftChild;
		if(newRoot.hasLeftChild())
			newRoot.leftChild.parent = oldRoot;
		newRoot.parent = oldRoot.parent;
		if(oldRoot.parent != null) {
			if(oldRoot.isLeftChild()) 
				oldRoot.parent.leftChild = newRoot;
			else
				oldRoot.parent.rightChild = newRoot;
		}
		oldRoot.parent = newRoot;
		newRoot.leftChild = oldRoot;
		oldRoot.updateHeightAfterRotation();
		newRoot.updateHeightAfterRotation();
	}
	
	private void rotateRight() {
		AVLTreeNode oldRoot = this;
		AVLTreeNode newRoot = this.rightChild;
		oldRoot.leftChild = newRoot.rightChild;
		if(newRoot.hasRightChild())
			newRoot.rightChild.parent = oldRoot;
		newRoot.parent = oldRoot.parent;
		if(oldRoot.parent != null) {
			if(oldRoot.isLeftChild()) 
				oldRoot.parent.leftChild = newRoot;
			else
				oldRoot.parent.rightChild = newRoot;
		}
		oldRoot.parent = newRoot;
		newRoot.leftChild = oldRoot;
		oldRoot.updateHeightAfterRotation();
		newRoot.updateHeightAfterRotation();
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
	
	public AVLTreeNode findMin() {
		if(this.hasLeftChild())
			return this.leftChild.findMin();
		else
			return this;
	}
	
	public AVLTreeNode findMax() {
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
