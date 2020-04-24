package ivanmarkovic.algorithms.graphs.dijkstrahashmap;


public class PriorityQueue {

    Vertex priorityQueue[];
    int pointer, size;
    public PriorityQueue(int size){
        this.size = size + 1; // null is first element
        this.pointer = 0;
        this.priorityQueue = new Vertex[this.size];
    }

    public boolean isEmpty(){
        return this.pointer == 0;
    }

    public void insert(Vertex vertex){
        this.pointer += 1;
        vertex.key = this.pointer;
        this.priorityQueue[this.pointer] = vertex;
        this.percUp(this.pointer);
    }

    public void decreaseKey(int key){
        this.percUp(key);
    }

    private void percUp(int index){
        Vertex tmp;
        while(index / 2 > 0){
            if(this.priorityQueue[index/2].weight > this.priorityQueue[index].weight){
                tmp = this.priorityQueue[index/2];
                this.priorityQueue[index/2] = this.priorityQueue[index];
                this.priorityQueue[index] = tmp;
                this.priorityQueue[index/2].key = index / 2;
                this.priorityQueue[index].key = index;
            }
            index = index / 2;
        }
    }

    public Vertex getMin(){
        try {
            return this.priorityQueue[1];
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("No such element");
            return null;
        }
    }

    public Vertex deleteMin(){
        if(this.isEmpty())
            return null;
        Vertex retVertex = this.priorityQueue[1];
        this.priorityQueue[1] = this.priorityQueue[this.pointer];
        this.pointer--;
        this.percDown(1);
        return retVertex;
    }

    private void percDown(int index){
        Vertex tmp;
        while(index * 2 <= this.pointer){
            int minIndex = this.getMinIndex(index);
            if(this.priorityQueue[index].weight > this.priorityQueue[minIndex].weight){
                tmp = this.priorityQueue[index];
                this.priorityQueue[index] = this.priorityQueue[minIndex];
                this.priorityQueue[minIndex] = tmp;
                this.priorityQueue[index].key = index;
                this.priorityQueue[minIndex].key = minIndex;
            }
            index = minIndex;
        }
    }

    private int getMinIndex(int index){
        if(index * 2 + 1 > this.pointer)
            return index * 2;
        else {
            if(this.priorityQueue[index * 2].weight <= this.priorityQueue[index * 2 + 1].weight){
                return  index * 2;
            }
            else
                return index * 2 + 1;
        }
    }
}

