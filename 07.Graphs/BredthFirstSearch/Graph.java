

import javax.print.attribute.standard.QueuedJobCount;

public class Graph {
	
	int maxNumberOfVertices;
	int currentNumberOfVertices;
	boolean adjacencyMatrix[][];
	Vertex vertices[];
	
	public Graph(int maxNumberOfVertices) {
		this.maxNumberOfVertices = maxNumberOfVertices;
		this.adjacencyMatrix = new boolean[this.maxNumberOfVertices][this.maxNumberOfVertices];
		this.vertices = new Vertex[this.maxNumberOfVertices];
		this.currentNumberOfVertices = 0;
	}
	
	public void addVertex(Vertex v) {
		this.vertices[this.currentNumberOfVertices] = v;
		v.index = this.currentNumberOfVertices;
		this.adjacencyMatrix[this.currentNumberOfVertices][this.currentNumberOfVertices] = false;
		this.currentNumberOfVertices++;
	}
	
	public void addVertex(String label) {
		this.vertices[this.currentNumberOfVertices] = new Vertex(label, this.currentNumberOfVertices);
		this.adjacencyMatrix[this.currentNumberOfVertices][this.currentNumberOfVertices] = false;
		this.currentNumberOfVertices++;
	}
	
	public void addEdge(int start, int end) {
		this.adjacencyMatrix[start][end] = true;
		this.adjacencyMatrix[end][start] = true;
	}
	
	public void addEdge(String labelStart, String labelEnd) {
		int start = this.returnIndexByLabel(labelStart);
		int end = this.returnIndexByLabel(labelEnd);
		if(start != -1 && end != -1)
			this.addEdge(start, end);
	}
	
	public int returnIndexByLabel(String label) {
		int index = -1;
		int count = 0;
		boolean found = false;
		while(count < this.currentNumberOfVertices && !found) {
			if(this.vertices[count].label.equals(label))
				found = true;
			else
				count++;
		}
		if(found)
			index = count;
		return index;		
	}
	
	public void bredthFirstSearch() {
		Queue<Vertex> queue = new Queue<Vertex>(); 
		queue.enqueue(this.vertices[0]);
		
		while(!queue.isEmpty()) {
			Vertex vertex = queue.dequeue().payload;
			vertex.visited = true;
			System.out.println("Visited : " + vertex.label);
			for(int j = 0; j <this.currentNumberOfVertices; j++) {
				if(this.adjacencyMatrix[vertex.index][j] == true && this.vertices[j].visited == false && this.vertices[j].included == false) {
					queue.enqueue(this.vertices[j]);
					this.vertices[j].included = true;
				}
			}
		}
				
	}

}
