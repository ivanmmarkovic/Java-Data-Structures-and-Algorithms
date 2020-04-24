package ivanmarkovic.algorithms.trees.tree;


import java.util.HashMap;

public class Node {

    int key;
    Node parent;
    HashMap<Integer, Node> children;

    public Node(int key){
        this.key = key;
        this.children = new HashMap<>();
    }

    public Node(int key, Node parent){
        this(key);
        this.parent = parent;
    }
}

