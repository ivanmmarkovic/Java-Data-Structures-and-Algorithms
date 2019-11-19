package ivanmarkovic.algorithms.graphs.dijkstra;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph(10);

		graph.addVertex("START");
		graph.addVertex("A");
		graph.addVertex("C");
		graph.addVertex("B");
		graph.addVertex("D");
		graph.addVertex("END");

		graph.addEdge("START", "A", 0);
		graph.addEdge("START", "C", 2);
		graph.addEdge("A", "B", 18);
		graph.addEdge("A", "D", 15);
		graph.addEdge("C", "B", 3);
		graph.addEdge("C", "D", 10);
		graph.addEdge("B", "END", 150);
		graph.addEdge("D", "END", 15);
		graph.dijkstra("START");
		
		System.out.println(graph.getPath("END"));

	}

}
