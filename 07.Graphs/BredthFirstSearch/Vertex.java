

public class Vertex {

	String label;
	int index;
	boolean visited;
	boolean included;
	
	public Vertex(String label) {
		this.label = label;
	}
	
	public Vertex(String label, int index) {
		this.label = label;
		this.index = index;
	}
	
}
