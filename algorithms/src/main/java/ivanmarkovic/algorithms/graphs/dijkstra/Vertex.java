package ivanmarkovic.algorithms.graphs.dijkstra;

public class Vertex {
	
	private String label;
	private int weight;
	private int index;
	private int key;
	
	public Vertex(String label) {
		this.label = label;
	}
	
	public Vertex(String label, int weight, int index) {
		this.label = label;
		this.weight = weight;
		this.index = index;
	}

}
