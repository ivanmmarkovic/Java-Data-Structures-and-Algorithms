package ivanmarkovic.algorithms.graphs.dijkstra;

import java.util.NoSuchElementException;

public class BinaryHeap {
	
	private int pointer;
	private int size;
	private Vertex heap[];
	
	public BinaryHeap(int size) {
		this.size = size;
		this.pointer = 0;
		this.heap = new Vertex[this.size];
	}
	
	public boolean isEmpty() {
		return this.pointer == 0;
	}
	
	public void insert(Vertex vertex) {
		if(this.pointer + 1 >= this.size)
			return;
		this.pointer++;
		vertex.setKey(this.pointer);
		this.heap[this.pointer] = vertex;
		this.percUp(this.pointer);
	}
	
	public void percUp(int index) {
		Vertex tmp;
		while(index / 2 > 0) {
			if(this.heap[index].getWeight() < this.heap[index/2].getWeight()) {
				tmp = this.heap[index];
				this.heap[index] = this.heap[index/2];
				this.heap[index/2] = tmp;
				this.heap[index].setKey(index);
				this.heap[index/2].setKey(index/2);
			}
			index = index / 2;
		}
	}
	
	public void decreaseKey(int key) {
		this.percUp(key);
	}
	
	public Vertex getMin() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		else
			return this.heap[1];
	}
	
	public Vertex deleteMin() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		Vertex toDelete = this.heap[1];
		if(this.pointer == 1) {
			this.pointer = 0;
			return toDelete;
		}
		this.heap[1] = this.heap[this.pointer];
		this.heap[1].setKey(1);
		this.pointer--;
		this.percDown(1);
		return toDelete;
	}
	
	public void percDown(int index) {
		Vertex tmp;
		while(index * 2 <= this.pointer) {
			int minIndex = this.getMinIndex(index);
			if(this.heap[index].getWeight() > this.heap[minIndex].getWeight()) {
				tmp = this.heap[index];
				this.heap[index] = this.heap[minIndex];
				this.heap[minIndex] = tmp;
				this.heap[index].setKey(index);
				this.heap[minIndex].setKey(minIndex);
			}
			index = minIndex;
		}
	}
	
	public int getMinIndex(int index) {
		if(index * 2 + 1 > this.pointer)
			return index * 2;
		else {
			if(this.heap[index * 2].getWeight() <= this.heap[index * 2 + 1].getWeight())
				return index * 2;
			else
				return index * 2 + 1;
		}	
	}

}
