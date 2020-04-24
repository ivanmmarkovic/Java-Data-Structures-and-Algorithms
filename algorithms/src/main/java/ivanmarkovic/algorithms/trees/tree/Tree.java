package ivanmarkovic.algorithms.trees.tree;


import java.util.ArrayList;


public class Tree {

    Node root;
    public Tree(){

    }
    public Tree(int key){
        this.root = new Node(key);
    }

    public boolean contains(int key){
        Node result = this.getNode(key);
        if(result == null)
            return false;
        else
            return true;
    }

    public Node getNode(int key){
        if(this.root == null)
            return null;
        if(this.root.key == key)
            return this.root;
        else {
            Node result = null;
            for(Integer k: this.root.children.keySet()){
                result = this.getNode(this.root.children.get(k), key);
                if(result != null)
                    break;
            }
            return result;
        }
    }

    private Node getNode(Node node, int key){
        if(node.key == key){
            return node;
        }
        else {
            Node result = null;
            for(Integer k: node.children.keySet()){
                result = this.getNode(node.children.get(k), key);
                if(result != null)
                    break;
            }
            return  result;
        }
    }

    public int height(){
        if(this.root == null)
            return 0;
        else if(this.root.children.size() == 0)
            return 1;
        else {
            ArrayList<Integer> heights = new ArrayList<>();
            for(Integer k: this.root.children.keySet()){
                heights.add(0);
            }
            return heights.stream().max(Integer::compare).get() + 1;
        }
    }

    private int height(Node node){
        if(node.children.size() == 0)
            return  1;
        else {
            ArrayList<Integer> heights = new ArrayList<>();
            for(Integer k: node.children.keySet()){
                heights.add(this.height(node.children.get(k)));
            }
            return heights.stream().max(Integer::compare).get() + 1;
        }
    }

    public void add(int key1, int key2){
        Node parent = this.getNode(key1);
        if(parent == null)
            return;
        parent.children.put(key2, new Node(key2, parent));
    }
}
