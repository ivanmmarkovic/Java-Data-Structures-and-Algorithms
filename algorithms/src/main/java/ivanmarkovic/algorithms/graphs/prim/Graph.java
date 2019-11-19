package ivanmarkovic.algorithms.graphs.prim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class Graph {
	
	private int size;
	private int pointer;
	private Vertex vertices[];
	private HashMap<String, String> previous;
	private HashMap<String, List<Vertex>> adjacencyList;
	private String result;
	
	public Graph(int size) {
		this.size = size;
		this.pointer = 0;
		this.vertices = new Vertex[this.size];
		this.previous = new HashMap<String, String>();
		this.adjacencyList = new HashMap<String, List<Vertex>>();
		this.result = "";
	}
	
	public void addVertex(String label) {
		if(this.pointer == this.size)
			return;
		Vertex vertex = new Vertex(label, Integer.MAX_VALUE, this.pointer);
		this.vertices[this.pointer++] = vertex;
		this.previous.put(label, null);
		this.adjacencyList.put(label, new ArrayList<Vertex>());
	}
	
	public void addEdge(String label1, String label2, int weight) {
		int index = this.getIndexByLabel(label2);
		Vertex vertex = new Vertex(label2, weight, index);
		this.adjacencyList.get(label1).add(vertex);
	}
	
	public void prim(String label) {
		int index = this.getIndexByLabel(label);
		this.vertices[index].setWeight(0);
		BinaryHeap pq = new BinaryHeap(this.size);
		for(int i = 0; i < this.pointer; i++)
			pq.insert(this.vertices[i]);
		Vertex current;
		while(!pq.isEmpty()) {
			current = pq.deleteMin();
			if(this.previous.get(current.getLabel()) != null)
				this.result +=  this.previous.get(current.getLabel()) + " -> " + current.getLabel() + ", ";
				
			for(Vertex vertex: this.adjacencyList.get(current.getLabel())) {
				if(vertex.getWeight() < this.vertices[vertex.getIndex()].getWeight()) {
					this.vertices[vertex.getIndex()].setWeight(vertex.getWeight());
					this.previous.put(this.vertices[vertex.getIndex()].getLabel(), current.getLabel());
					pq.decreaseKey(this.vertices[vertex.getIndex()].getKey());
				}
			}
		}
		System.out.println(this.result);
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
	

}
