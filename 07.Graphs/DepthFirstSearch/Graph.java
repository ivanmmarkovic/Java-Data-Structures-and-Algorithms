
import java.util.Stack;

public class Graph {
	
	int maxNumberOfVertices;
	int currentNumberOfVertices;
	Vertex vertices[];
	boolean adjacencyMatrix[][];
	Stack<Vertex> stack;
	
	public Graph(int maxNumberOfVertices) {
		this.maxNumberOfVertices = maxNumberOfVertices;
		this.vertices = new Vertex[this.maxNumberOfVertices];
		this.adjacencyMatrix = new boolean[this.maxNumberOfVertices][this.maxNumberOfVertices];
		this.currentNumberOfVertices = 0;
		this.stack = new Stack<Vertex>();
	}
	
	public void addVertex(Vertex v) {
		this.vertices[this.currentNumberOfVertices] = v;
		v.index = this.currentNumberOfVertices;
		this.adjacencyMatrix[this.currentNumberOfVertices][this.currentNumberOfVertices] = false;
		this.currentNumberOfVertices++;
	}
	
	public void addVertex(String label) {
		this.vertices[this.currentNumberOfVertices] = new Vertex(label);
		this.vertices[this.currentNumberOfVertices].index = this.currentNumberOfVertices;
		this.adjacencyMatrix[this.currentNumberOfVertices][this.currentNumberOfVertices] = false;
		this.currentNumberOfVertices++;
	}
	
	public void addEdge(int start, int end) {
		this.adjacencyMatrix[start][end] = true;
		this.adjacencyMatrix[end][start] = true;
	}
	
	public void addEdge(String label1, String label2) {
		int start = this.getIndexByLabel(label1);
		int end = this.getIndexByLabel(label2);
		if(start == -1 || end == -1)
			return;
		this.adjacencyMatrix[start][end] = true;
		this.adjacencyMatrix[end][start] = true;
	}
	
	public int getIndexByLabel(String label) {
		int index = 0;
		boolean found = false;
		while(index < this.vertices.length && !found) {
			if(this.vertices[index].label.equals(label))
				found = true;
			else
				index++;
		}
		if(found)
			return index;
		else
			return -1;
	}
	public void depthFirstSearch() {
		Vertex startVertex = this.vertices[0];
		Vertex peekedVertex;
		startVertex.visited = true;
		this.stack.push(startVertex);
		System.out.println("Visited : " + startVertex.label);
		while(!this.stack.isEmpty()) {
			peekedVertex = this.stack.peek();
			int index = this.getUnvisitedNeighbour(peekedVertex.index);
			if(index == -1)
				this.stack.pop();
			else {
				this.vertices[index].visited = true;
				this.stack.push(this.vertices[index]);
				System.out.println("Visited : " + this.vertices[index].label);
			}
		}
		for(int i = 0; i < this.currentNumberOfVertices; i++)
			this.vertices[i].visited = false;
	}
	public void depthFirstSearch(String label1, String label2) {
		int startVertexIndex = this.getIndexByLabel(label1);
		if(startVertexIndex == -1)
			return;
		Vertex startVertex = this.vertices[startVertexIndex];
		startVertex.visited = true;
		this.stack.push(startVertex);
		System.out.println("Visited : " + startVertex.label);
		boolean found = false;
		Vertex peekedVertex;
		while(!this.stack.isEmpty() && !found) {
			peekedVertex = this.stack.peek();
			int index = this.getUnvisitedNeighbour(peekedVertex.index);
			if(index == -1)
				this.stack.pop();
			else {
				this.vertices[index].visited = true;
				this.stack.push(this.vertices[index]);
				if(this.vertices[index].label.equals(label2))
					found = true;
				System.out.println("Visited : " + this.vertices[index].label);
			}
		}
		for(int i = 0; i < this.currentNumberOfVertices; i++)
			this.vertices[i].visited = false;
	}
	public int getUnvisitedNeighbour(int index) {
		int count = 0;
		boolean found = false;
		while(count < this.currentNumberOfVertices && !found) {
			if(this.adjacencyMatrix[index][count] == true && this.vertices[count].visited == false)
				found = true;
			else
				count++;
		}
		if(found)
			return count;
		else
			return -1;
	}

}
