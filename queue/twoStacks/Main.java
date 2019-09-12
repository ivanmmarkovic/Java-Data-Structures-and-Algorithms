package queue.twoStacks;

public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty()); // true
        System.out.println(q.dequeue()); // null
        System.out.println(q.size()); // 0
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.size()); // 3

        System.out.println("------------------");
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }

    }
}
