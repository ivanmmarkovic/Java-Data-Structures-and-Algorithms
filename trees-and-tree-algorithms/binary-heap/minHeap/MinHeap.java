package trees.binaryHeap.minHeap;

public class MinHeap {
	
	int heap[];
	int pointer;
	public MinHeap(int size) {
		this.heap = new int[size];
		this.pointer = 0;
	}
	
	public boolean isEmpty() {
		return this.pointer == 0;
	}
	
	public void insert(int element) {
		if(this.pointer < this.heap.length - 1) {
			this.heap[++this.pointer] = element;
			this.percUp(this.pointer);
		}
		else {
			System.out.println("Heap is full");
		}
	}
	
	public void percUp(int index) {
		while(index / 2 > 0) {
			if(this.heap[index/2] > this.heap[index]) {
				int tmp = this.heap[index/2];
				this.heap[index/2] = this.heap[index];
				this.heap[index] = tmp;
			}
			index = index / 2;
		}
	}
	
	public Integer deleteMin() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			int retValue = this.heap[1];
			this.heap[1] = this.heap[this.pointer--];
			this.percDown(1);
			return retValue;
		}
	}
	
	public void percDown(int index) {
		while(index * 2 <= this.pointer) {
			int minIndex = this.getMinIndex(index);
			if(this.heap[index] > this.heap[minIndex]) {
				int tmp = this.heap[minIndex];
				this.heap[minIndex] = this.heap[index];
				this.heap[index] = tmp;
			}
			index = minIndex;
		}
	}
	
	public int getMinIndex(int index) {
		if(index * 2 + 1 > this.pointer) {
			return index;
		}
		else {
			if(this.heap[index * 2] <= this.heap[index * 2 + 1]) {
				return index * 2;
			}
			else {
				return index * 2 + 1;
			}
		}
	}
	
	public Integer getMin() {
		if(this.isEmpty())
			return null;
		else
			return this.heap[1];
	}
	
	public MinHeap buildHeap(int numbers[]) {
		MinHeap mh = new MinHeap(numbers.length);
		for(int element: numbers)
			mh.insert(element);
		return mh;
	}
	
	@Override 
	public String toString() {
		String s = "";
		for(int i = 1; i <= this.pointer; i++)
			s += this.heap[i] + ", ";
		return s;
	}

}
