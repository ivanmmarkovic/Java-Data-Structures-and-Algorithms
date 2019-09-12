package queue.twoStacks;

public class Queue {

    Stack input;
    Stack output;

    public Queue() {
        input = new Stack();
        output = new Stack();
    }

    public boolean isEmpty(){
        return this.input.isEmpty();
    }

    public int size(){
        return this.input.size();
    }

    public void enqueue(int payload){
        input.push(payload);
    }

    public Integer dequeue(){
        if(this.isEmpty())
            return null;
        else {
            while(!this.input.isEmpty()){
                this.output.push(this.input.pop());
            }
            Integer retValue = this.output.pop();
            while(!this.output.isEmpty()){
                this.input.push(this.output.pop());
            }
            return retValue;
        }
    }
}
