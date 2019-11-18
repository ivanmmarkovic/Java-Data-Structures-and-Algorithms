package ivanmarkovic.algorithms.graphs.topologicalsorting;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph(10);

		String vertices[] = {"a", "b", "c", "d", "e", "f", "g"};
		for(String vertex: vertices)
			graph.addVertex(vertex);


		graph.addEdge("a", "c");
		graph.addEdge("c", "d");
		graph.addEdge("c", "f");
		graph.addEdge("a", "b");
		graph.addEdge("d", "e");
		graph.addEdge("b", "c");
		graph.addEdge("b", "g");

		graph.topSort();	

	}

}
