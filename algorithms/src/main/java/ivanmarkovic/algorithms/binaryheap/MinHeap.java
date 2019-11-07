package ivanmarkovic.algorithms.binaryheap;

public class MinHeap {
	
	private int numbers[];
	private int index;
	
	public MinHeap(int size) {
		this.index = 0;
		this.numbers = new int[size];
	}
	
	public boolean isEmpty() {
		return this.index == 0;
	}
	
	private boolean isFull() {
		return this.index == this.numbers.length;
	}
	
	public void insert(int item) throws HeapIsFullException {
		if(this.isFull())
			throw new HeapIsFullException();
		this.numbers[++this.index] = item;
		this.percUp(this.index);
	}
	
	private void percUp(int index) {
		int tmp;
		while (index / 2 > 0) {
			if(numbers[index / 2] > numbers[index]) {
				tmp = numbers[index/2];
				numbers[index/2] = numbers[index];
				numbers[index] = tmp;
			}
			index = index / 2;
		}
	}
	
	public Integer deleteMin() throws HeapIsEmptyException {
		if(this.isEmpty())
			throw new HeapIsEmptyException();
		int retValue = this.numbers[1];
		this.numbers[1] = this.numbers[this.index--];
		this.percDown(1);
		return retValue;
	}
	
	private void percDown(int index) {
		int tmp;
		while (index * 2 <= this.index) {
			int minIndex = this.getMinIndex(index);
			if(numbers[index] > numbers[minIndex]) {
				tmp = numbers[index];
				numbers[index] = numbers[minIndex];
				numbers[minIndex] = tmp;
			}
			index = minIndex;
		}
	}
	
	private int getMinIndex(int index) {
		if(index * 2 + 1 > this.index)
			return index * 2;
		else {
			if(numbers[index * 2] <= numbers[index * 2 + 1])
				return index * 2;
			else
				return index * 2 + 1;
		}
	}
	
	public int getMin() throws HeapIsEmptyException {
		if(this.isEmpty())
			throw new HeapIsEmptyException();
		return this.numbers[1];
	}
	
	public void buildHeap(int numbers[]) throws HeapIsFullException {
		for(int number: numbers)
			this.insert(number);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= this.index; i++) {
			if(i == this.index)
				sb.append(numbers[i]);
			else
				sb.append(numbers[i] + ", ");
		}
		return sb.toString();
	}

}
