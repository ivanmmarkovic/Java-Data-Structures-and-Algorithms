import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	
	int currentNumberOfVertices, maxNumberOfVertices;
	Vertex vertices[];
	HashMap<Vertex, ArrayList<Vertex>> neighbours;
	public Graph(int maxNumberOfVertices) {
		this.maxNumberOfVertices = maxNumberOfVertices;
		this.vertices = new Vertex[this.maxNumberOfVertices];
		this.currentNumberOfVertices = 0;
		this.neighbours = new HashMap<Vertex, ArrayList<Vertex>>();
	}
	
	public void addVertex(String label) {
		Vertex vertex = new Vertex(label);
		this.neighbours.put(vertex, new ArrayList<Vertex>());
		this.vertices[this.currentNumberOfVertices++] = vertex;
	}
	
	public void addVertex(Vertex vertex) {
		this.neighbours.put(vertex, new ArrayList<Vertex>());
		this.vertices[this.currentNumberOfVertices++] = vertex;
	}

	public void addEdge(String label1, String label2, int weight) {
		Vertex vertex = this.findVertexByLabel(label1);
		this.neighbours.get(vertex).add(new Vertex(label2, weight));
	}
	
	public void dijkstra(String labelStart, String labelEnd) {
		Vertex start = this.findVertexByLabel(labelStart);
		start.weight = 0;
		PriorityQueue pq = new PriorityQueue(this.maxNumberOfVertices);
		for(int i = 0; i < this.currentNumberOfVertices; i++)
			pq.insert(this.vertices[i]);
		//boolean found = false;
		Vertex minVertex, tmpVertex;
		while(!pq.isEmpty()/* && !found*/) {
			minVertex = pq.getMin();
			for (Vertex v : this.neighbours.get(minVertex)) {
				tmpVertex = this.findVertexByLabel(v.label);
				if (minVertex.weight + v.weight < tmpVertex.weight) {
					tmpVertex.weight = minVertex.weight + v.weight;
					tmpVertex.previous = minVertex.label;
				}
			}
			pq.deleteMin();
		}
		
		System.out.println(this.printPath(labelEnd));
	}
	
	public String printPath(String label) {
		Vertex vertex = this.findVertexByLabel(label);
		String result = "";
		if(vertex.previous == null)
			result += label;
		else
			result += (this.printPath(vertex.previous) + " -> " + label);
		return result;
	}
	
	public Vertex findVertexByLabel(String label) {
		boolean found = false;
		int count = 0;
		while(count < this.currentNumberOfVertices && !found) {
			if(this.vertices[count].label.equals(label))
				found = true;
			else
				count++;
		}
		if(found)
			return this.vertices[count];
		else
			return null;
	}
}
