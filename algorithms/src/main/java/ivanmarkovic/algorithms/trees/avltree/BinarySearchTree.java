package ivanmarkovic.algorithms.trees.avltree;


import java.util.NoSuchElementException;

public class BinarySearchTree {
	
	TreeNode root;
	int length;
	
	public BinarySearchTree() {
		this.length = 0;
	}
	
	public void put(int key) {
		this.length++;
		if(this.root == null) {
			this.root = new TreeNode(key);
		}
		else
			this.put(this.root, key);
	}
	
	private void put(TreeNode node, int key) {
		if(node.key == key)
			return;
		else if(node.key > key) {
			if(node.hasLeftChild())
				this.put(node.leftChild, key);
			else {
				node.leftChild = new TreeNode(key);
				this.update(node);
			}
		}
		else {
			if(node.hasRightChild())
				this.put(node.rightChild, key);
			else {
				node.rightChild = new TreeNode(key);
				this.update(node);
			}
		}
	}
	
	public TreeNode get(int key) {
		if(this.root == null)
			throw new NoSuchElementException("Node with key " + key + " doesn't exists");
		else
			return this.get(this.root, key);
	}
	
	private TreeNode get(TreeNode node, int key) {
		if(node.key == key)
			return node;
		else if(node.key > key) {
			if(node.hasLeftChild())
				return this.get(node.leftChild, key);
			else
				throw new NoSuchElementException("Node with key " + key + " doesn't exists");
		}
		else {
			if(node.hasRightChild())
				return this.get(node.rightChild, key);
			else
				throw new NoSuchElementException("Node with key " + key + " doesn't exists");
		}
	}
	
	public void delete(int key) throws NoSuchElementException {
		TreeNode toDelete = this.get(key);
		if(this.root == toDelete) {
			if(this.root.isLeaf()) {
				this.length--;
				this.root = null;
			}
			else if(this.root.hasBothChildren()) {
				TreeNode tmp = this.root.leftChild.findMax();
				int tmpKey = tmp.key;
				this.delete(tmpKey);
				toDelete.key = tmpKey;
			}
			else {
				this.length--;
				if(this.root.hasLeftChild()) {
					this.root = this.root.leftChild;
					this.root.parent = null;
				}
				else {
					this.root = this.root.rightChild;
					this.root.parent = null;
				}
			}
		}
		else {
			TreeNode parent = toDelete.parent;
			if(toDelete.isLeaf()) {
				this.length--;
				if(toDelete.isLeftChild()) 
					toDelete.parent.leftChild = null;
				else
					toDelete.parent.rightChild = null;
				this.update(parent);
			}
			else if(toDelete.hasBothChildren()) {
				TreeNode tmp = toDelete.leftChild.findMax();
				int tmpKey = tmp.key;
				this.delete(tmpKey);
				toDelete.key = tmpKey;
			}
			else {
				this.length--;
				if(toDelete.hasLeftChild()) {
					if(toDelete.isLeftChild()) {
						toDelete.parent.leftChild = toDelete.leftChild;
						toDelete.leftChild.parent = toDelete.parent;
					}
					else {
						toDelete.parent.rightChild = toDelete.leftChild;
						toDelete.leftChild.parent = toDelete.parent;
					}
				}
				else {
					if(toDelete.isLeftChild()) {
						toDelete.parent.leftChild = toDelete.rightChild;
						toDelete.rightChild.parent = toDelete.parent;
					}
					else {
						toDelete.parent.rightChild = toDelete.rightChild;
						toDelete.rightChild.parent = toDelete.parent;
					}
				}
				this.update(parent);
			}
		}
	}
	
	public boolean contains(int key) {
		if(this.root == null)
			return false;
		else
			return this.contains(this.root, key);
	}
	
	private boolean contains(TreeNode node, int key) {
		boolean found = false;
		while (node != null && !found) {
			if(node.key == key)
				found = true;
			else if(node.key > key)
				node = node.leftChild;
			else
				node = node.rightChild;
		}
		return found;
	}
	
	public int size() {
		return this.length;
	}

	private void update(TreeNode node) {
		int oldbalanceFactor = node.balanceFactor;
		if(node.hasLeftChild())
			node.leftSubtreeHeight = Math.max(node.leftChild.leftSubtreeHeight, node.leftChild.rightSubtreeHeight) + 1;
		else
			node.leftSubtreeHeight = 0;
		if(node.hasRightChild())
			node.rightSubtreeHeight = Math.max(node.rightChild.leftSubtreeHeight, node.rightChild.rightSubtreeHeight) + 1;
		else
			node.rightSubtreeHeight = 0;
		node.balanceFactor = node.leftSubtreeHeight - node.rightSubtreeHeight;
		if(node.balanceFactor < -1 || node.balanceFactor > 1) {
			this.rebalance(node);
			return;
		}
		if(oldbalanceFactor != node.balanceFactor && node.hasParent())
			update(node.parent);
		
	}
	
	private void rebalance(TreeNode node) {
		if(node.balanceFactor < 0) {
			if(node.rightChild.balanceFactor > 0)
				this.rotateRight(node.rightChild);
			else
				this.rotateLeft(node);
		}
		else {
			if(node.leftChild.balanceFactor < 0)
				this.rotateLeft(node.leftChild);
			else
				this.rotateRight(node);
		}
	}
	
	private void rotateLeft(TreeNode node) {
		TreeNode oldRoot = node;
		TreeNode newRoot = node.rightChild;
		oldRoot.rightChild = newRoot.leftChild;
		if(newRoot.hasLeftChild()) 
			newRoot.leftChild.parent = oldRoot;
		newRoot.parent = oldRoot.parent;
		if(oldRoot.hasParent()) {
			if(oldRoot.isLeftChild()) 
				oldRoot.parent.leftChild = newRoot;
			else
				oldRoot.parent.rightChild = newRoot;
		}
		else
			this.root = newRoot;
		oldRoot.parent = newRoot;
		newRoot.leftChild = oldRoot;
		this.update(oldRoot);
	}
	
	private void rotateRight(TreeNode node){
		TreeNode oldRoot = node;
		TreeNode newRoot = node.rightChild;
		oldRoot.leftChild = newRoot.rightChild;
		if(newRoot.hasRightChild()) 
			newRoot.rightChild.parent = oldRoot;
		newRoot.parent = oldRoot.parent;
		if(oldRoot.hasParent()) {
			if(oldRoot.isLeftChild()) 
				oldRoot.parent.leftChild = newRoot;
			else
				oldRoot.parent.rightChild = newRoot;
		}
		else
			this.root = newRoot;
		oldRoot.parent = newRoot;
		newRoot.rightChild = oldRoot;
		this.update(oldRoot);
	}
}

