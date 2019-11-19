package ivanmarkovic.algorithms.graphs.prim;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	
}
