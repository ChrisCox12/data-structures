import java.util.ArrayList;
import java.util.Objects;

class Queue {
    private int head; // keeps track of the index of the head; in this case, it's always zero
    private int tail; // keeps track of the index of the tail
    private ArrayList<Integer> q; // the body of the queue

    Queue() {
        head = -1;
        tail = -1;
        q = new ArrayList<>();
    }

    void enqueue(int value) {
        if(head == -1) {
            head = 0; // both the tail can equal 0, meaning that there's only one element in the queue
            tail = 0; // and both point to it
        }
        else{
            tail++;
        }

        q.add(value);
    }

    void dequeue() {
        q.remove(head);
        tail--;

        if(tail < 0) head = -1;
    }

    void isEmpty() {
        if(head == -1 && tail == -1) System.out.println("Queue is empty");
        else System.out.println("Queue is not empty");
    }

    void print() {
        System.out.print("Head: ");
        for (Integer integer : q) { // for each Integer in q
            System.out.printf("%s", integer);
            if(!Objects.equals(integer, q.get(tail))) System.out.print(" | ");
        }
        System.out.print(" :Tail\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.print();
        queue.isEmpty();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.isEmpty();
        queue.dequeue();
        queue.print();
        queue.isEmpty();
    }
}