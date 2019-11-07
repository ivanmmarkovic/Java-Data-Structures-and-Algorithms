package ivanmarkovic.algorithms.binaryheap;

public class HeapIsEmptyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeapIsEmptyException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Heap is empty";
	}

}
