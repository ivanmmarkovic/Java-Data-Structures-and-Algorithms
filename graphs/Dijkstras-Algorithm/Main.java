
public class Main {

	public static void main(String[] args) {
		
		
		Graph g = new Graph(10);
		g.addVertex("START");
		g.addVertex("A");
		g.addVertex("C");
		g.addVertex("B");
		g.addVertex("D");
		g.addVertex("END");
		
		g.addEdge("START", "A", 0);
		g.addEdge("START", "C", 2);
		g.addEdge("A", "B", 18);
		g.addEdge("A", "D", 15);
		g.addEdge("C", "B", 3);
		g.addEdge("C", "D", 10);
		g.addEdge("B", "END", 150);
		g.addEdge("D", "END", 15);
		g.dijkstra("START", "END");
		
	}

}
