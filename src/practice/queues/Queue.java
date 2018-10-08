package practice.queues;

import java.util.ArrayList;
import java.util.List;

public class Queue {


    //store elements
    public List<Integer> array = new ArrayList<>();

    int start = 0;


    public Queue() {
        array = new ArrayList<>();
        start = 0;
    }

    public boolean enqueue(int data) {
        array.add(data);
        return true;
    }


    public boolean dequeue() {
        if (isEmpty())
            return false;

        array.remove(start);
        start++;
        return true;
    }

    public int front() {
        return array.get(start);
    }

    public boolean isEmpty() {
        return start >= array.size();
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.array);
        queue.dequeue();
        System.out.println(queue.array);
    }


}
