package ivanmarkovic.algorithms.graphs.dijkstrahashmap;


import java.util.HashMap;

public class Graph {

    HashMap<String, Vertex> vertices;
    HashMap<String, String> previous;
    public Graph(){
        this.vertices = new HashMap<>();
        this.previous = new HashMap<>();
    }

    public void addVertex(String label){
        Vertex vertex = new Vertex(label, Integer.MAX_VALUE);
        this.previous.put(label, null);
        this.vertices.put(label, vertex);
    }

    public void addEdge(String label1, String label2, int weight){
        Vertex neighbour = new Vertex(label2, weight);
        this.vertices.get(label1).adjacencyMap.put(label2, neighbour);
    }

    public void dijkstra(String label){
        Vertex current = this.vertices.get(label);
        current.weight = 0;
        PriorityQueue pq = new PriorityQueue(this.vertices.size());
        for(String key: this.vertices.keySet()){
            pq.insert(this.vertices.get(key));
        }
        Vertex neighbour;
        while (!pq.isEmpty()){
            current = pq.deleteMin();
            for(String key: current.adjacencyMap.keySet()){
                neighbour = current.adjacencyMap.get(key);
                if(current.weight + neighbour.weight < this.vertices.get(key).weight){
                    this.vertices.get(key).weight = current.weight + neighbour.weight;
                    this.previous.put(key, current.label);
                    pq.decreaseKey(this.vertices.get(key).key);
                }
            }
        }
    }

    public String getPath(String label){
        if(this.previous.get(label) == null){
            return label;
        }
        else
            return this.getPath(this.previous.get(label)) + " -> " + label;
    }
}
