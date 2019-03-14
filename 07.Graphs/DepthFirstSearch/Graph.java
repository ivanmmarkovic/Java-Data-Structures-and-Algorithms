import java.util.Stack;

public class Graph {
	
	int maxNumberOfVertices, currentNumberOfVertices;
	Vertex vertices[];
	boolean adjacencyMatrix[][];
	public Graph(int maxNumberOfVertices) {
		this.maxNumberOfVertices = maxNumberOfVertices;
		this.currentNumberOfVertices = 0;
		this.vertices = new Vertex[this.maxNumberOfVertices];
		this.adjacencyMatrix = new boolean[this.maxNumberOfVertices][this.maxNumberOfVertices];
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
	
	public int findNextVertex(int index) {
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
	
	public void depthFirstSearch() {
		Vertex vertex = this.vertices[0];
		vertex.visited = true;
		System.out.println("Visited : " + vertex.label);
		Stack<Vertex> stack = new Stack<>();
		stack.push(vertex);
		while(!stack.isEmpty()) {
			Vertex lastInVertex = stack.peek();
			int neighbourIndex = this.findNextVertex(lastInVertex.index);
			if(neighbourIndex == -1)
				stack.pop();
			else {
				stack.push(this.vertices[neighbourIndex]);
				this.vertices[neighbourIndex].visited = true;
				System.out.println("Visited : " + this.vertices[neighbourIndex].label);
			}
		}
		for(int j = 0; j < this.currentNumberOfVertices; j++)
			this.vertices[j].visited = false;
	}
	
	public void depthFirstSearch(String startLabel, String endLabel) {
		 int startIndex = this.returnIndexByLabel(startLabel);
		 Vertex startVertex = this.vertices[startIndex];
		 boolean found = false;
		 Stack<Vertex> stack = new Stack<>();
		 startVertex.visited = true;
		 stack.push(startVertex);
		 System.out.println("Visited : " + stack.peek().label);
		 while(stack.isEmpty() || !found) {
			Vertex lastInVertex = stack.peek();
			int neighbourIndex = this.findNextVertex(lastInVertex.index);
			if (neighbourIndex == -1)
				stack.pop();
			else {
				stack.push(this.vertices[neighbourIndex]);
				this.vertices[neighbourIndex].visited = true;
			}
			 System.out.println("Visited : " + stack.peek().label);
			 if(stack.peek().label.equals(endLabel))
				 found = true;
			 
		 }
	}

}
