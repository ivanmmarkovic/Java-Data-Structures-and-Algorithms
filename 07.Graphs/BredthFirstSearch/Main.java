

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph(10);
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		Vertex i = new Vertex("I");
		Vertex j = new Vertex("J");
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);
		graph.addVertex(j);
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		
		graph.addEdge("C", "F");
		graph.addEdge("C", "H");
		
		graph.addEdge("F", "G");
		
		graph.addEdge("B", "F");
		
		graph.bredthFirstSearch();

	}

}
