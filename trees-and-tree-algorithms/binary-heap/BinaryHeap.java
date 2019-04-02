package binaryHeap;

import java.util.ArrayList;

public class BinaryHeap {
	
	Integer heap[];
	int size;
	public BinaryHeap(int size) {
		this.size = 0;
		this.heap = new Integer[size];
		this.heap[this.size] = null;
	}
	
	public void insert(int element) {
		this.size++;
		this.heap[this.size] = element;
		this.percDown(this.size);
	}
	
	public void percDown(int index) {
		while((int)(index / 2) >= 1) {
			if(this.heap[(int)(index / 2)] > this.heap[index]) {
				int tmp = this.heap[(int)(index / 2)];
				this.heap[(int)(index / 2)] =  this.heap[index];
				this.heap[index] = tmp;
			}
			index = (int)(index / 2);
		}
	}
	
	public Integer getMin() {
		return this.heap[1];
	}
	
	public Integer deleteMin() {
		Integer min = this.heap[1];
		this.heap[1] = this.heap[this.size];
		this.heap[this.size] = null;
		this.size--;
		this.percUp(1);
		return min;
	}
	
	public void percUp(int index) {
		while(index * 2 <= this.size) {
			int minIndex = this.getMinIndex(index);
			if(this.heap[index] > this.heap[minIndex]) {
				int tmp = this.heap[index];
				this.heap[index] = this.heap[minIndex];
				this.heap[minIndex] = tmp;
			}
			index = minIndex;
		}
	}
	
	public int getMinIndex(int index) {
		if(index * 2 + 1 > this.size)
			return index * 2;
		else {
			if(this.heap[index * 2] < this.heap[index * 2 +1])
				return index * 2;
			else
				return index * 2 + 1;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void buildHeap(int elements[]) {
		for(int element: elements)
			this.insert(element);
	}
	
	public void printHeap() {
		for(Integer element: this.heap)
			System.out.print(element + " ");
		System.out.println();
	}
	
	

}
