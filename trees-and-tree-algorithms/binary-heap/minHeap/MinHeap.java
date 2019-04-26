package trees.binaryHeap.minHeap;

public class MinHeap{
	
	Integer queue[];
	int size, currentNumber;
	public MinHeap(int size) {
		this.size = size;
		this.queue = new Integer[this.size];
		this.currentNumber = 0;
	}
	
	public boolean isEmpty() {
		return this.currentNumber == 0;
	}
	
	public void insert(Integer Integer) {
		this.queue[++this.currentNumber] = Integer;
		this.percUp(this.currentNumber);
	}
	
	public void percUp(int index) {
		Integer tmpInteger = null;
		while(index / 2 > 0) {
			if(this.queue[index/2] > this.queue[index]) {
				tmpInteger = this.queue[index];
				this.queue[index] = this.queue[index/2];
				this.queue[index/2] = tmpInteger;
			}
			index = index / 2;
		}
	}
	
	public Integer deleteMin() {
		Integer toDelete = this.queue[1];
		this.queue[1] = this.queue[currentNumber--];
		this.percDown(1);
		return toDelete;
	}
	
	public void percDown(int index) {
		Integer tmpInteger;
		while(index * 2 <= this.currentNumber) {
			int minIndex = this.getMinIndex(index); 
			if(this.queue[index] > this.queue[minIndex]) {
				tmpInteger = this.queue[index];
				this.queue[index] = this.queue[minIndex];
				this.queue[minIndex] = tmpInteger;
			}
			index = minIndex;
		}
	}
	
	public int getMinIndex(int index) {
		if(index * 2 + 1 > this.currentNumber) {
			return index * 2;
		}
		else {
			if(this.queue[index * 2] <= this.queue[index * 2 + 1]) {
				return index * 2;
			}
			else {
				return index * 2 + 1;
			}
		}
	}
	
	public Integer getMin() {
		return this.queue[1];
	}
	
	public MinHeap buildHeap(int numbers[]) {
		MinHeap mh = new MinHeap(numbers.length);
		for(int number: numbers)
			mh.insert(number);
		return mh;
	}

}
