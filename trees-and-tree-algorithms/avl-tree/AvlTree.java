
public class AvlTree{

	Integer key;
	Payload payload;
	AvlTree parent, leftChild, rightChild;
	int leftHeight, rightHeight, balanceFactor;
	public AvlTree(int key, Payload payload, AvlTree parent) {
		this.key = key; 
		this.payload = payload; 
		this.parent = parent;
		this.leftChild = this.rightChild = null;
		this.leftHeight = this.rightHeight = this.balanceFactor = 0;
	}
	
	public static int max(int a,  int b) {
		if(a > b)
			return a;
		else
			return b;
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
	
	public AvlTree findMin() {
		if(this.hasLeftChild())
			return this.leftChild.findMin();
		else
			return this;
	}
	
	public AvlTree findMax() {
		if(this.hashRightChild())
			return this.rightChild.findMax();
		else
			return this;
	}
	
	public boolean contain(int key) {
		if(this.key == key)
			return true;
		else if(this.key > key)
			return this.leftChild.contain(key);
		else 
			return this.rightChild.contain(key);
	}
	
	public int size() {
		int result = 1;
		if(this.hasLeftChild())
			result +=  this.leftChild.size();
		if(this.hashRightChild())
			result += this.rightChild.size();
		return result;
	}
	
	public AvlTree get(int key) {
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
		if(this.key == null || this.key == key) {
			this.key = key;
			this.payload = payload;
		}
		else if(this.key > key) {
			if(this.hasLeftChild())
				this.leftChild.put(key, payload);
			else {
				this.leftChild = new AvlTree(key, payload, this);
				this.updateHeight(this.leftChild);
			}
		}
		else if(this.key < key) {
			if(this.hashRightChild())
				this.rightChild.put(key, payload);
			else {
				this.rightChild = new AvlTree(key, payload, this);
				this.updateHeight(this.rightChild);
			}
		}
	}
	
	public void delete(int key) {
		AvlTree tree = this.get(key);
		if(tree.isLeaf()) {
			if(tree.isRoot())
				tree = null;
			else if(tree.isLeftChild()) {
				tree.parent.leftChild = null;
				tree.parent.updateHeightAfterDeletion("left");
			}
			else if(tree.isRightChild()) {
				tree.parent.rightChild = null;
				tree.parent.updateHeightAfterDeletion("right");
			}
		}
		else if(tree.hasBothChildren()) {
			
		}
		else if(tree.hasLeftChild()) {
			if(tree.isRoot())
				tree.leftChild.parent = null;
			else if(tree.isLeftChild()) {
				tree.leftChild.parent = tree.parent;
				tree.parent.leftChild = tree.leftChild;
				tree.parent.updateHeightAfterDeletion("left");
			}
			else if(tree.isRightChild()) {
				tree.leftChild.parent = tree.parent;
				tree.parent.rightChild = tree.leftChild;
				tree.parent.updateHeightAfterDeletion("right");
			}
		}
		else if(tree.hashRightChild()) {
			if(tree.isRoot())
				tree.rightChild.parent = null;
			else if(tree.isLeftChild()) {
				tree.rightChild.parent = tree.parent;
				tree.parent.leftChild = tree.rightChild;
				tree.parent.updateHeightAfterDeletion("left");
			}
			else if(tree.isRightChild()) {
				tree.rightChild.parent = tree.parent;
				tree.parent.rightChild = tree.rightChild;
				tree.parent.updateHeightAfterDeletion("right");
			}
		}
	}
	
	public void updateHeight(AvlTree tree) {
		if(tree.isLeftChild())
			this.leftHeight += 1;
		else if(tree.isRightChild())
			this.rightHeight += 1;
		this.balanceFactor = this.leftHeight - this.rightHeight;
		if(this.balanceFactor < -1 || this.balanceFactor > 1) {
			this.rebalance();
			return;
		}
		if(this.hasParent() && this.balanceFactor != 0)
			this.parent.updateHeight(this);
	}
	
	public void updateHeightAfterDeletion(String side) {
		if(side.equals("left"))
			this.leftHeight -= 1;
		else if(side.equals("right"))
			this.rightHeight -= 1;
		this.balanceFactor = this.leftHeight - this.rightHeight;
		if(this.balanceFactor < -1 || this.balanceFactor > 1) {
			this.rebalance();
			return;
		}
		if(this.hasParent() && this.balanceFactor != 0)
			this.parent.updateHeight(this);
	}
	
	public void updateHeightAfterRotation() {
		this.leftHeight = this.hasLeftChild() ? max(this.leftChild.leftHeight, this.leftChild.rightHeight) + 1 : 0;
		this.rightHeight = this.hashRightChild() ? max(this.rightChild.leftHeight, this.rightChild.rightHeight) + 1 : 0;
		
		this.balanceFactor = this.leftHeight - this.rightHeight;
	}
	
	public void rebalance() {
		if(this.balanceFactor > 0) {
			if(this.leftChild.balanceFactor < 0) {
				this.leftChild.rotateLeft();
				this.rotateRight();
			}
			else {
				this.rotateRight();
			}
		}
		else if(this.balanceFactor < 0) {
			if(this.rightChild.balanceFactor > 0) {
				this.rightChild.rotateRight();
				this.rotateLeft();
			}
			else
				this.rotateLeft();
		}
	}
	
	public void rotateRight() {
		AvlTree oldRoot = this;
		AvlTree newRoot = oldRoot.leftChild;
		oldRoot.leftChild = newRoot.rightChild;
		if(newRoot.hashRightChild())
			newRoot.rightChild.parent = oldRoot;
		newRoot.parent = oldRoot.parent;
		if(oldRoot.isLeftChild())
			oldRoot.parent.leftChild = newRoot;
		else if(oldRoot.isRightChild())
			oldRoot.parent.rightChild = newRoot;
		oldRoot.parent = newRoot;
		newRoot.rightChild = oldRoot;
		
		oldRoot.updateHeight(this);
		newRoot.updateHeight(this);
	}
	
	public void rotateLeft() {
		AvlTree oldRoot = this;
		AvlTree newRoot = oldRoot.rightChild;
		oldRoot.rightChild = newRoot.leftChild;
		if(newRoot.hasLeftChild())
			newRoot.leftChild.parent = oldRoot;
		newRoot.parent = oldRoot.parent;
		if(oldRoot.isLeftChild())
			oldRoot.parent.leftChild = newRoot;
		else if(oldRoot.isRightChild())
			oldRoot.parent.rightChild = newRoot;
		oldRoot.parent = newRoot;
		newRoot.rightChild = oldRoot;
		
		oldRoot.updateHeight(this);
		newRoot.updateHeight(this);
	}
	
}
