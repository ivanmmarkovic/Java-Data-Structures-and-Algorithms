package ivanmarkovic.algorithms.binaryheap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap mh = new MinHeap(10);
		
		System.out.println(mh);
		try {
			//mh.getMin();
			mh.insert(117);
			mh.insert(30);
			mh.insert(1);
			mh.insert(20);
			mh.insert(2);
			System.out.println(mh.getMin());
			System.out.println(mh);
			while (!mh.isEmpty()) {
				System.out.println(mh.deleteMin());
			}
		} 
		catch (HeapIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(HeapIsFullException e) {
			e.printStackTrace();
		}
	}

}
