
public class PriorityQueue {
	
	Vertex queue[];
	int size, currentNumber;
	public PriorityQueue(int size) {
		this.size = size;
		this.queue = new Vertex[this.size];
		this.currentNumber = 0;
	}
	
	public boolean isEmpty() {
		return this.currentNumber == 0;
	}
	
	public void insert(Vertex vertex) {
		this.queue[++this.currentNumber] = vertex;
		this.percUp(this.currentNumber);
	}
	
	public void percUp(int index) {
		Vertex tmpVertex = null;
		while(index / 2 > 0) {
			if(this.queue[index/2].weight > this.queue[index].weight) {
				tmpVertex = this.queue[index];
				this.queue[index] = this.queue[index/2];
				this.queue[index/2] = tmpVertex;
			}
			index = index / 2;
		}
	}
	
	public Vertex deleteMin() {
		Vertex toDelete = this.queue[1];
		this.queue[1] = this.queue[currentNumber--];
		this.percDown(1);
		return toDelete;
	}
	
	public void percDown(int index) {
		Vertex tmpVertex;
		while(index * 2 <= this.currentNumber) {
			int minIndex = this.getMinIndex(index); 
			if(this.queue[index].weight > this.queue[minIndex].weight) {
				tmpVertex = this.queue[index];
				this.queue[index] = this.queue[minIndex];
				this.queue[minIndex] = tmpVertex;
			}
			index = minIndex;
		}
	}
	
	public int getMinIndex(int index) {
		if(index * 2 + 1 > this.currentNumber) {
			return index * 2;
		}
		else {
			if(this.queue[index * 2].weight <= this.queue[index * 2 + 1].weight) {
				return index * 2;
			}
			else {
				return index * 2 + 1;
			}
		}
	}
	
	public Vertex getMin() {
		return this.queue[1];
	}

}
