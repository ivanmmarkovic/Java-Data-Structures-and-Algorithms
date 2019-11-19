package ivanmarkovic.algorithms.graphs.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	private int size;
	private int pointer;
	private Vertex vertices[];
	private HashMap<String, String> previous;
	private HashMap<String, List<Vertex>> adjacencyList;
	
	public Graph(int size) {
		this.size = size;
		this.pointer = 0;
		this.vertices = new Vertex[this.size];
		this.previous = new HashMap<String, String>();
		this.adjacencyList = new HashMap<String, List<Vertex>>();
	}
	
	public void addEdge(String label) {
		if(this.pointer == this.size)
			return;
		Vertex vertex = new Vertex(label, Integer.MAX_VALUE, this.pointer);
		this.vertices[this.pointer++] = vertex;
		this.previous.put(label, null);
		this.adjacencyList.put(label, new ArrayList<Vertex>());
	}
	
	

}
