package ivanmarkovic.algorithms.graphs.breadthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	
	private String vertices[];
	private int size;
	private int pointer;
	private HashMap<String, String> previous;
	private HashMap<String, Integer> distance;
	private HashMap<String, List<String>> adjacencyList;
	private HashMap<String, String> colors;
	
	public Graph(int size) {
		this.size = size;
		this.vertices = new String[this.size];
		this.pointer = 0;
		this.previous = new HashMap<String, String>();
		this.distance = new HashMap<String, Integer>();
		this.adjacencyList = new HashMap<String, List<String>>();
		this.colors = new HashMap<String, String>();
	}
	
	public void addVertex(String label) {
		if(this.pointer == this.size)
			return;
		this.vertices[this.pointer++] = label;
		this.previous.put(label, null);
		this.distance.put(label, 0);
		this.adjacencyList.put(label, new ArrayList<String>());
		this.colors.put(label, "white");
	}
	
	public void addEdge(String label1, String label2) {
		this.adjacencyList.get(label1).add(label2);
		this.adjacencyList.get(label2).add(label1);
	}
	
	public void bfs(String start) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		this.colors.put(start, "gray");
		String tmp;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			for(String neighbour: this.adjacencyList.get(tmp)) {
				if(this.colors.get(neighbour).equals("white")) {
					this.colors.put(neighbour, "gray");
					this.previous.put(neighbour, tmp);
					this.distance.put(neighbour, this.distance.get(tmp) + 1);
					queue.add(neighbour);
				}
			}
			this.colors.put(tmp, "black");
		}
	}
	
	public String getPath(String end) {
		if(this.previous.get(end) == null)
			return end;
		else
			return this.getPath(this.previous.get(end)) + " -> " + end;
	}

}
