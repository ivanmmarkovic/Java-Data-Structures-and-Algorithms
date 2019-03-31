import java.util.ArrayList;

public class Vertex {

	String label;
	boolean visited;
	int weight;
	ArrayList<Vertex> vertices;
	public Vertex(String label, int weight) {
		this.label = label;
		this.weight = weight;
		this.visited = false;
		this.vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex(Vertex v) {
		this.vertices.add(v);
	}
	
	public Vertex findCheapestVertex() {
		if(this.vertices.size() == 0)
			return null;
		else {
			Vertex start = null;
			for(int i = 0; i < this.vertices.size(); i++)
				if(this.vertices.get(i).visited == false)
					if(start == null)
						start = this.vertices.get(i);
					else
						if(start.weight > this.vertices.get(i).weight)
							start = this.vertices.get(i);
			return start;
		}
	}
	
}
