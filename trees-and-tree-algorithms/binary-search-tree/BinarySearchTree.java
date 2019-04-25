package trees.binarySearchTree;

public class BinarySearchTree<Key extends Comparable<Key>, T> {
	
	Node<Key, T> root;
	int size;
	
	public BinarySearchTree() {
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
					this.size++;
				}
			}
			else {
				if(node.hasRightChild())
					this.put(key, payload, node.rightChild);
				else {
					node.rightChild = new Node<Key, T>(key, payload, node, null, null);
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
		T toReturn = null;
		if(node == null)
			return toReturn;
		else {
			toReturn = node.payload;
			if (node.isLeaf()) {
				if (node.hasParent()) {
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
	
	
}
