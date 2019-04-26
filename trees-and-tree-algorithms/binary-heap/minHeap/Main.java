package trees.binaryHeap.minHeap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap mh = new MinHeap(10);
		System.out.println(mh.isEmpty());
		mh.insert(117);
		mh.insert(3);
		mh.insert(5);
		
		System.out.println(mh);
		
		System.out.println("Min is " + mh.getMin());
		
		System.out.println(mh.isEmpty());

		System.out.println(mh.deleteMin());
		
		while(!mh.isEmpty()) {
			System.out.println(mh.deleteMin());
		}
		

	}

}
