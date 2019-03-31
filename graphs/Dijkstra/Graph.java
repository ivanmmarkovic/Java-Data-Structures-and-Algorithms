import java.util.ArrayList;
import java.util.Stack;

public class Graph {
	
	ArrayList<Vertex> adjacencyList;
	Stack<Vertex> stack;
	public Graph() {
		this.adjacencyList = new ArrayList<Vertex>();
		this.stack = new Stack<Vertex>();
	}
	
	public void addVertex(Vertex v) {
		this.adjacencyList.add(v);
	}
	
	public void addEdge(Vertex v1, Vertex v2) {
		v1.addVertex(v2);
	}
	
	public void dijkstra(String labelStart, String labelEnd) {
		Vertex startVertex = this.getVertexByName(labelStart);
		startVertex.visited = true;
		this.stack.push(startVertex);
		boolean found = false;
		Vertex cheapestVertex;
		while(!this.stack.isEmpty() && !found) {
			if(this.stack.peek().label.equals(labelEnd))
				found = true;
			else {
				cheapestVertex = this.getVertexByName(stack.peek().findCheapestVertex().label);
				if(cheapestVertex == null)
					this.stack.pop();
				else {
					cheapestVertex.visited = true;
					this.stack.push(cheapestVertex);
				}
			}
		}
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		if(found) {
			while(!this.stack.isEmpty())
				path.add(this.stack.pop());
			for(int i = path.size() - 1; i >= 0; i--)
				System.out.print(path.get(i).label + " ");
		}
		
	}
	
	public Vertex getVertexByName(String label) {
		boolean found = false;
		int count = 0;
		while(count < this.adjacencyList.size() && !found) {
			if(this.adjacencyList.get(count).label.equals(label))
				found = true;
			else
				count++;
		}
		if(found)
			return this.adjacencyList.get(count);
		else
			return null;
	}

}
