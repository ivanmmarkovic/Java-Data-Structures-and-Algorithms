
public class Vertex {
	
	String label;
	String previous;
	int weight;
	public Vertex(String label) {
		this.label = label;
		this.previous = null;
		this.weight = Integer.MAX_VALUE;
	}
	
	public Vertex(String label, int weight) {
		this.label = label;
		this.previous = null;
		this.weight = weight;
	}

}
