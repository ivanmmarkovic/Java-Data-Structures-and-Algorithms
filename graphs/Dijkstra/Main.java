
public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Vertex a = new Vertex("A", 0);
		a.addVertex(new Vertex("B", 6));
		a.addVertex(new Vertex("C", 3));
		
		Vertex b = new Vertex("B", 6);
		b.addVertex(new Vertex("D", 1));
		
		Vertex c = new Vertex("C", 3);
		c.addVertex(new Vertex("B", 2));
		c.addVertex(new Vertex("D", 4));
		
		Vertex d = new Vertex("D", 1);
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		
		graph.dijkstra("A", "D");
		

	}

}
