package ivanmarkovic.algorithms.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Graph {
	
	private String vertices[];
	private int size;
	private int pointer;
	private HashMap<String, List<String>> adjacencyList;
	private HashMap<String, String> colors;
	private ArrayList<String> explored;
	
	public Graph(int size) {
		this.size = size;
		this.vertices = new String[this.size];
		this.pointer = 0;
		this.adjacencyList = new HashMap<String, List<String>>();
		this.colors = new HashMap<String, String>();
		explored = new ArrayList<String>();
	}
	
	public void addVertex(String label) {
		if(this.pointer == this.size)
			return;
		this.vertices[this.pointer++] = label;
		this.adjacencyList.put(label, new ArrayList<String>());
		this.colors.put(label, "white");
	}
	
	public void addEdge(String label1, String label2) {
		this.adjacencyList.get(label1).add(label2);
		this.adjacencyList.get(label2).add(label1);
	}
	
	public void topSort() {
		for(int i = 0; i < this.pointer; i++) {
			this.dfs(this.vertices[i]);
		}
		Collections.reverse(explored);
		System.out.println(explored);
	}
	
	private void dfs(String start) {
		if(!this.colors.get(start).equals("white"))
			return;
		Stack<String> stack = new Stack<String>();
		stack.push(start);
		this.colors.put(start, "gray");
		String tmp;
		String neighbour;
		while (!stack.isEmpty()) {
			tmp = stack.peek();
			neighbour = this.findUnvisitedNeighbour(tmp);
			if(neighbour != null) {
				this.colors.put(neighbour, "gray");
				stack.push(neighbour);
			}
			else {
				this.explored.add(stack.pop());
				this.colors.put(tmp, "black");
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
	


}
