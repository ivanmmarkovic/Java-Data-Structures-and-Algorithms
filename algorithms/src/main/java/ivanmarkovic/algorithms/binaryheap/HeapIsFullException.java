package ivanmarkovic.algorithms.binaryheap;

public class HeapIsFullException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeapIsFullException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Heap is full";
	}

}
