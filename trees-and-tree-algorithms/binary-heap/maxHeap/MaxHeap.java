package trees.binaryHeap.maxHeap;

public class MaxHeap {
	
	Integer queue[];
	int size, currentNumber;
	public MaxHeap(int size) {
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
			if(this.queue[index/2] < this.queue[index]) {
				tmpInteger = this.queue[index];
				this.queue[index] = this.queue[index/2];
				this.queue[index/2] = tmpInteger;
			}
			index = index / 2;
		}
	}
	
	public Integer deleteMax() {
		Integer toDelete = this.queue[1];
		this.queue[1] = this.queue[currentNumber--];
		this.percDown(1);
		return toDelete;
	}
	
	public void percDown(int index) {
		Integer tmpInteger;
		while(index * 2 <= this.currentNumber) {
			int minIndex = this.getIndex(index); 
			if(this.queue[index] < this.queue[minIndex]) {
				tmpInteger = this.queue[index];
				this.queue[index] = this.queue[minIndex];
				this.queue[minIndex] = tmpInteger;
			}
			index = minIndex;
		}
	}
	
	public int getIndex(int index) {
		if(index * 2 + 1 > this.currentNumber) {
			return index * 2;
		}
		else {
			if(this.queue[index * 2] >= this.queue[index * 2 + 1]) {
				return index * 2;
			}
			else {
				return index * 2 + 1;
			}
		}
	}
	
	public Integer getMax() {
		return this.queue[1];
	}
	
	public MaxHeap buildHeap(int numbers[]) {
		MaxHeap mh = new MaxHeap(numbers.length);
		for(int number: numbers)
			mh.insert(number);
		return mh;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 1; i <= this.currentNumber; i++)
			s += this.queue[i] + ", ";
		return s;
	}

}
