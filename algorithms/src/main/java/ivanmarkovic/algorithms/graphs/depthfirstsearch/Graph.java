package ivanmarkovic.algorithms.graphs.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	private String vertices[];
	private int size;
	private int pointer;
	private int time;
	private HashMap<String, String> previous;
	private HashMap<String, Integer> distance;
	private HashMap<String, List<String>> adjacencyList;
	private HashMap<String, String> colors;
	private HashMap<String, Integer> entry;
	private HashMap<String, Integer> exit;
	
	public Graph(int size) {
		this.size = size;
		this.vertices = new String[this.size];
		this.pointer = 0;
		this.previous = new HashMap<String, String>();
		this.distance = new HashMap<String, Integer>();
		this.adjacencyList = new HashMap<String, List<String>>();
		this.colors = new HashMap<String, String>();
		this.entry = new HashMap<String, Integer>();
		this.exit = new HashMap<String, Integer>();
		this.time = 0;
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
	
	public void dfs(String start) {
		Stack<String> stack = new Stack<String>();
		stack.push(start);
		this.colors.put(start, "gray");
		this.entry.put(start, ++this.time);
		String tmp;
		String neighbour;
		while (!stack.isEmpty()) {
			tmp = stack.peek();
			neighbour = this.findUnvisitedNeighbour(tmp);
			if(neighbour != null) {
				this.previous.put(neighbour, tmp);
				this.colors.put(neighbour, "gray");
				this.entry.put(neighbour, ++this.time);
				this.distance.put(neighbour, this.distance.get(tmp) + 1);
				stack.push(neighbour);
			}
			else {
				stack.pop();
				this.colors.put(tmp, "black");
				this.exit.put(tmp, ++this.time);
			}
		}
	}
	
	private String findUnvisitedNeighbour(String label) {
		boolean found = false;
		int count = 0;
		String neighbour = null;
		while (count < this.adjacencyList.get(label).size() && !found) {
			neighbour = this.adjacencyList.get(label).get(count);
			if(this.colors.get(neighbour).equals("white"))
				found = true;
			else
				count++;
		}
		if(found)
			return neighbour;
		else
			return null;
	}
	
	public String getPath(String end) {
		if(this.previous.get(end) == null)
			return end;
		else
			return this.getPath(this.previous.get(end)) + " -> " + end;
	}

}
