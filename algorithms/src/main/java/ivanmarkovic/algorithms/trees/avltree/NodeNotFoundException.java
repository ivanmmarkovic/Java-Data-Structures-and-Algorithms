package ivanmarkovic.algorithms.trees.avltree;

public class NodeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int key;
	public NodeNotFoundException(int key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return "Node with key " + this.key + " doesn't exists";
	}

}
