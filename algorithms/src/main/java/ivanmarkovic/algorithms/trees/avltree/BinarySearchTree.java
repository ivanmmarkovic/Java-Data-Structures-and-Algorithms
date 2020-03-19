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
			else
				node.leftChild = new TreeNode(key);
		}
		else {
			if(node.hasRightChild())
				this.put(node.rightChild, key);
			else
				node.rightChild = new TreeNode(key);
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
				this.root.key = tmpKey;
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
			if(toDelete.isLeaf()) {
				this.length--;
				if(toDelete.isLeftChild()) 
					toDelete.parent.leftChild = null;
				else
					toDelete.parent.rightChild = null;
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

}

