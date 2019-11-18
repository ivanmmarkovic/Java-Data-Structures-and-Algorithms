package ivanmarkovic.algorithms.graphs.connectivity.undirectedgraphs;

public class Main {
	
	/*
	 * Undirected graph:
	 * ###########################
	 * Perform bfs or dfs.
	 * If number of explored vertices is equal to number of vertices in graph,
	 * graph is connected.
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(10);

		String myVertices[] = {"A","B","C","D","E","F","G","H","I"};

		for(String vertex: myVertices)
			graph.addVertex(vertex);

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("C", "D");
		graph.addEdge("C", "G");
		graph.addEdge("D", "G");
		graph.addEdge("D", "H");
		graph.addEdge("B", "E");
		graph.addEdge("B", "F");
		graph.addEdge("E", "I");

		System.out.println("Connected : " + graph.isConnected());

	}

}
