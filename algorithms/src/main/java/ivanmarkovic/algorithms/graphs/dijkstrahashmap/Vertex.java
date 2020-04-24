package ivanmarkovic.algorithms.graphs.dijkstrahashmap;


import java.util.HashMap;

public class Vertex {

    String label;
    Integer key;
    int weight;
    HashMap<String, Vertex> adjacencyMap;

    Vertex(String label, int weight){
        this.label = label;
        this.weight = weight;
        this.adjacencyMap = new HashMap<>();
    }
}
