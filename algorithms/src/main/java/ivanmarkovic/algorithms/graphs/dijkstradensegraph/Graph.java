package ivanmarkovic.algorithms.graphs.dijkstradensegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class Graph {
	
	private int size;
	private int pointer;
	private Vertex vertices[];
	private HashMap<String, String> previous;
	private Integer adjacencyMatrix[][];
	private HashSet<String> visited;
	
	public Graph(int size) {
		this.size = size;
		this.pointer = 0;
		this.vertices = new Vertex[this.size];
		this.previous = new HashMap<String, String>();
		this.adjacencyMatrix = new Integer[this.size][this.size];
		this.visited = new HashSet<String>();
	}
	
	public void addVertex(String label) {
		if(this.pointer == this.size)
			return;
		Vertex vertex = new Vertex(label, Integer.MAX_VALUE, this.pointer);
		this.vertices[this.pointer++] = vertex;
		this.previous.put(label, null);
	}
	
	public void addEdge(String label1, String label2, int weight) {
		int index1 = this.getIndexByLabel(label1);
		int index2 = this.getIndexByLabel(label2);
		this.adjacencyMatrix[index1][index2] = weight;
	}
	
	public void dijkstra(String label) {
		int index = this.getIndexByLabel(label);
		this.vertices[index].setWeight(0);
		Vertex cheapest = this.vertices[index];
		//this.visited.add(cheapest.getLabel());

		while (cheapest != null) {
			for(int i = 0; i < this.adjacencyMatrix[cheapest.getIndex()].length; i++) {
				if(this.adjacencyMatrix[cheapest.getIndex()][i] != null) {
					if(cheapest.getWeight() + this.adjacencyMatrix[cheapest.getIndex()][i] < this.vertices[i].getWeight()) {
						this.previous.put(this.vertices[i].getLabel(), cheapest.getLabel());
						this.vertices[i].setWeight(cheapest.getWeight() + this.adjacencyMatrix[cheapest.getIndex()][i]);
					}
				}
			}
			this.visited.add(cheapest.getLabel());
			cheapest = this.findCheapestVertex();
		}
		
		
	}
	
	public String getPath(String label) {
		if(this.previous.get(label) == null)
			return label;
		else
			return this.getPath(this.previous.get(label)) + " -> " + label;
	}
	
	public Integer getIndexByLabel(String label) {
		boolean found = false;
		int count = 0;
		while(count < this.pointer && !found) {
			if(this.vertices[count].getLabel().equals(label))
				found = true;
			else
				count++;
		}
		if(found)
			return count;
		else
			throw new NoSuchElementException();
	}
	
	public Vertex findCheapestVertex() {
		Vertex cheapest = null;
		for(int i = 0; i < this.pointer; i++) {
			if(!this.visited.contains(this.vertices[i].getLabel())) {
				if(cheapest == null)
					cheapest = this.vertices[i];
				else {
					if(cheapest.getWeight() > this.vertices[i].getWeight())
						cheapest = this.vertices[i];
				}
			}
		}
		return cheapest;
	}
	

}
