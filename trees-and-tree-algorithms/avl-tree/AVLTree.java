package trees.AVLTree;

public class AVLTree<Key extends Comparable<Key>, T> {
	
	Node<Key, T> root;
	int size;
	
	public AVLTree() {
		this.root = null;
		this.size  = 0;
	}
	
	public void put(Key key, T payload) {
		if(this.root  == null) {
			this.root = new Node<Key, T>(key, payload, null, null, null);
			this.size++;
		}
		else 
			this.put(key, payload, this.root);
	}
	
	private void put(Key key, T payload, Node<Key, T> node) {
		if(node.key.equals(key))
			node.payload = payload;
		else {
			int comp = node.key.compareTo(key);
			if(comp > 0) {
				if(node.hasLeftChild())
					this.put(key, payload, node.leftChild);
				else {
					node.leftChild = new Node<Key, T>(key, payload, node, null, null);
					this.updateBalance(node, node.leftChild);
					this.size++;
				}
			}
			else {
				if(node.hasRightChild())
					this.put(key, payload, node.rightChild);
				else {
					node.rightChild = new Node<Key, T>(key, payload, node, null, null);
					this.updateBalance(node, node.rightChild);
					this.size++;
				}
			}
		}
	}
	
	public T get(Key key) {
		if(this.root == null)
			return null;
		else {
			return this.get(key, this.root);
		}
	}
	
	private T get(Key key, Node<Key, T> node) {
		if(node.key.equals(key))
			return node.payload;
		else {
			int comp = node.key.compareTo(key);
			if(comp > 0) {
				if(node.hasLeftChild())
					return this.get(key, node.leftChild);
				else
					return null;
			}
			else {
				if(node.hasRightChild())
					return this.get(key, node.rightChild);
				else
					return null;
			}
		}
	}
	
	public  boolean contains(Key key) {
		if(this.root == null)
			return false;
		else {
			return this.contains(key, this.root);
		}
	}
	
	private boolean contains(Key key, Node<Key, T> node) {
		if(node.key.equals(key))
			return true;
		else {
			int cmp = node.key.compareTo(key);
			if(cmp > 0) {
				if(node.hasLeftChild())
					return this.contains(key, node.leftChild);
				else
					return false;
			}
			else {
				if(node.hasRightChild())
					return this.contains(key, node.rightChild);
				else
					return false;
			}
		}
	}
	
	public T delete(Key key) {
		Node<Key, T> node = this.getNode(key);
		Node<Key, T> parentNode = null;
		T toReturn = null;
		if(node == null)
			return toReturn;
		else {
			toReturn = node.payload;
			if (node.isLeaf()) {
				if (node.hasParent()) {
					parentNode = node.parent;
					if (node.isLeftChild()) {
						node.parent.leftChild = null;
						node = null;
					} else {
						node.parent.rightChild = null;
						node = null;
					}
				} else {
					node = null;
				}
				this.size--;
			} else if (node.hasBothChildren()) {
				Node<Key, T> minNode = this.findMin(node.rightChild);
				Node<Key, T> refNode = new Node<Key, T>(minNode.key, minNode.payload, null, null,null);
				this.delete(minNode.key);
				node.key = refNode.key;
				node.payload = refNode.payload;
				// no need for this this.size--
			} else if (node.hasLeftChild()) {
				if (node.hasParent()) {
					parentNode = node.parent;
					if (node.isLeftChild()) {
						node.parent.leftChild = node.leftChild;
						node.leftChild.parent = node.parent;
						node = null;
					} else {
						node.parent.rightChild = node.leftChild;
						node.leftChild.parent = node.parent;
						node = null;
					}
				} else {
					this.root = node.leftChild;
					this.root.parent = null;
					node = null;
				}
				this.size--;
			} else { // if node has right child
				if (node.hasParent()) {
					parentNode = node.parent;
					if (node.isLeftChild()) {
						node.parent.leftChild = node.rightChild;
						node.rightChild.parent = node.parent;
						node = null;
					} else {
						node.parent.rightChild = node.rightChild;
						node.rightChild.parent = node.parent;
						node = null;
					}
				} else {
					this.root = node.rightChild;
					this.root.parent = null;
					node = null;
				}
				this.size--;
			}
			if(parentNode != null)
				this.updateBalanceAfterDeletion(parentNode);
			return toReturn;
		}
	}
	
	
	public Node<Key, T> findMin() {
		if(this.root == null)
			return null;
		else
			return this.findMin(this.root);
	}
	
	private Node<Key, T> findMin(Node<Key, T> node){
		if(node.hasLeftChild())
			return findMin(node.leftChild);
		else
			return node;
	}
	
	public Node<Key, T> findMax(){
		if(this.root == null)
			return null;
		else 
			return this.findMax(this.root);
	}
	
	private Node<Key, T> findMax(Node<Key, T> node){
		if(node.hasRightChild())
			return this.findMax(node.rightChild);
		else
			return node;
	}
	
	public Node<Key, T> getNode(Key key){
		if(this.root == null)
			return null;
		else {
			return this.getNode(key, this.root);
		}
	}
	
	private Node<Key, T> getNode(Key key, Node<Key, T> node){
		if(node.key.equals(key)) {
			return node;
		}
		else {
			int comp = node.key.compareTo(key);
			if(comp > 0) {
				if(node.hasLeftChild())
					return this.getNode(key, node.leftChild);
				else
					return null;
			}
			else {
				if(node.hasRightChild())
					return this.getNode(key, node.rightChild);
				else
					return null;
			}
		}
	}
	
	// this method is called after insertion
	public void updateBalance(Node<Key, T> parent, Node<Key, T> child) {
		if(child.isLeftChild())
			parent.leftHeight += 1;
		if(child.isRightChild())
			parent.rightHeight += 1;
		parent.height = Math.max(parent.leftHeight, parent.rightHeight);
		parent.balanceFactor = parent.leftHeight - parent.rightHeight;
		
		if(parent.balanceFactor < -1 || parent.balanceFactor > 1) {
			this.rebalance(parent);
			return;
		}
		
		if(parent.hasParent() && parent.balanceFactor != 0)
			this.updateBalance(parent.parent, parent);
		
	}
	
	public void rebalance(Node<Key, T> node) {
		if(node.balanceFactor < -1) {
			if(node.rightChild.balanceFactor > 0) {
				this.rotateRight(node.rightChild);
				this.rotateLeft(node);
			}
			else {
				this.rotateLeft(node);
			}
		}
		else if(node.balanceFactor > 1) {
			if(node.leftChild.balanceFactor < 0) {
				this.rotateLeft(node.leftChild);
				this.rotateRight(node);
			}
			else {
				this.rotateRight(node);
			}
		}
	}
	
	public void updateBalanceAfterRotation(Node<Key, T> node) {
		if(node.hasLeftChild())
			node.leftHeight = node.leftChild.height + 1;
		else
			node.leftHeight = 0;
		if(node.hasRightChild())
			node.rightHeight = node.rightChild.height + 1;
		else
			node.rightHeight = 0;
		node.height = Math.max(node.leftHeight, node.rightHeight);
		node.balanceFactor = node.leftHeight - node.rightHeight;
	}
	
	public void updateBalanceAfterDeletion(Node<Key, T> node) {
		if(node.hasLeftChild())
			node.leftHeight = node.leftChild.height + 1;
		else
			node.leftHeight = 0;
		if(node.hasRightChild())
			node.rightHeight = node.rightChild.height + 1;
		else
			node.rightHeight = 0;
		node.height = Math.max(node.leftHeight, node.rightHeight);
		node.balanceFactor = node.leftHeight - node.rightHeight;
		
		if(node.balanceFactor < -1 || node.balanceFactor > 1) {
			this.rebalance(node);
			return;
		}
		
		if(node.hasParent() && node.balanceFactor != 0)
			this.updateBalance(node.parent, node);
		
	}
	
	public void rotateLeft(Node<Key, T> node) {
		Node<Key, T> newRoot = node.rightChild;
		node.rightChild = newRoot.leftChild;
		if(newRoot.hasLeftChild())
			newRoot.leftChild.parent = node;
		if(node.hasParent()) {
			if(node.isLeftChild()) {
				node.parent.leftChild = newRoot;
				newRoot.parent = node.parent;
			}
			else {
				node.parent.rightChild = newRoot;
				newRoot.parent = node.parent;
			}
		}
		else {
			newRoot.parent = null;
			this.root = newRoot;
		}
		node.parent = newRoot;
		newRoot.leftChild = node;
		this.updateBalanceAfterRotation(node);
		this.updateBalanceAfterRotation(newRoot);
		
	}
	
	public void rotateRight(Node<Key, T> node) {
		Node<Key, T> newRoot = node.leftChild;
		node.leftChild = newRoot.rightChild;
		if(newRoot.hasRightChild())
			newRoot.rightChild.parent = node;
		if(node.hasParent()) {
			if(node.isLeftChild()) {
				node.parent.leftChild = newRoot;
				newRoot.parent = node.parent;
			}
			else {
				node.parent.rightChild = newRoot;
				newRoot.parent = node.parent;
			}
		}
		else {
			newRoot.parent = null;
			this.root = newRoot;
		}
		node.parent = newRoot;
		newRoot.rightChild = node;
		this.updateBalanceAfterRotation(node);
		this.updateBalanceAfterRotation(newRoot);
		
	}
	
	
	public void preorder() {
		if(this.root != null)
			this.preorder(this.root);
	}
	
	private void preorder(Node<Key, T> node) {
		System.out.println(node.payload);
		if(node.hasLeftChild())
			this.inorder(node.leftChild);
		if(node.hasRightChild())
			this.inorder(node.rightChild);
	}
	
	public void inorder() {
		if(this.root != null)
			this.inorder(this.root);
	}
	
	private void inorder(Node<Key, T> node) {
		if(node.hasLeftChild())
			this.inorder(node.leftChild);
		System.out.println(node.payload);
		if(node.hasRightChild())
			this.inorder(node.rightChild);
	}
	
	public void postorder() {
		if(this.root != null)
			this.postorder(this.root);
	}
	
	private void postorder(Node<Key, T> node) {
		if(node.hasLeftChild())
			this.inorder(node.leftChild);
		if(node.hasRightChild())
			this.inorder(node.rightChild);
		System.out.println(node.payload);
	}
	
	
}
