
public class Vertex {
	
	String label;
	boolean visited;
	int index;
	
	public Vertex(String label) {
		this.label = label;
		this.visited = false;
	}
	
	public Vertex(String label, int index) {
		this.label = label;
		this.visited = false;
		this.index = index;
	}

}
