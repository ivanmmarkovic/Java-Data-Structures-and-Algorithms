
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
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("A", "E");
		
		graph.addEdge("B", "F");
		graph.addEdge("F", "G");
		
		graph.addEdge("C", "H");
		graph.addEdge("C", "D");
		
		graph.addEdge("D", "I");

		graph.depthFirstSearch();
		System.out.println("###############");
		graph.depthFirstSearch("A", "I");
		System.out.println("###############");
		graph.depthFirstSearch("A", "P");
		
	}

}
