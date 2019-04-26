package trees.binaryHeap.maxHeap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap mh = new MaxHeap(10);
		System.out.println(mh.isEmpty());
		mh.insert(117);
		mh.insert(3);
		mh.insert(5);
		
		System.out.println(mh);
		
		System.out.println("Max is " + mh.getMax());
		
		System.out.println(mh.isEmpty());

		System.out.println(mh.deleteMax());
		
		while(!mh.isEmpty()) {
			System.out.println(mh.deleteMax());
		}
		

	}

}
