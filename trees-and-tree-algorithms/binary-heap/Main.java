package binaryHeap;

public class Main {

	public static void main(String[] args) {

		BinaryHeap bh = new BinaryHeap(10);
		bh.insert(117);
		bh.insert(3);
		bh.insert(1);
		bh.printHeap();
		
		while(!bh.isEmpty())
			System.out.println(bh.deleteMin());
		
		bh.printHeap();
		
		System.out.println("#####################################");
		
		
		int numbers[] = {117, 5, 45, 13, 91, 24, 3};
		bh.buildHeap(numbers);
		bh.printHeap();
		while(!bh.isEmpty())
			System.out.println(bh.deleteMin());
		bh.printHeap();
	}

}
