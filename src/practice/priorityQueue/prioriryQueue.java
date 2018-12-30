/*
Binary Heap
        -Search - O(LogN)
        -insertion and deletion O(1)

heap should always be a complete binary tree

in heap every node should be smaller or greater than its children


*/


// implementation of max heap
package practice.priorityQueue;

import java.util.Vector;

public class prioriryQueue {

    private Vector<Integer> vector;

    public prioriryQueue(int capacity) {
        vector = new Vector<>(capacity);
    }

    public prioriryQueue() {
        vector = new Vector<>();
    }

    public int parent(int i) {
        if (i == 0)
            return 0;

        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        int left = 2 * i + 1;
        return left;
    }

    public int rightChild(int i) {
        int right = 2 * i + 2;
        return right;
    }

    private void swap(int x, int y) {
        Integer temp = vector.get(x);
        vector.setElementAt(vector.get(y), x);
        vector.setElementAt(temp, y);
    }

    public void heapifyDown(int i) {

        int leftChild, rightChild, max, temp;

        leftChild = leftChild(i);
        rightChild = rightChild(i);

        max = i;

        if (leftChild < size() && vector.get(leftChild) > vector.get(i))
            max = leftChild;

        if (rightChild < size() && vector.get(rightChild) > vector.get(max))
            max = rightChild;

        if (max != i) {
            swap(i, max);
            heapifyDown(max);
        }
    }

    public void heapifyUp(int i) {

        if (i > 0 && vector.get(parent(i)) < vector.get(i)) {
            swap(i, parent(i));
            heapifyUp(parent(i));
        }
    }

    public int size() {
        return vector.size();
    }

    public void insert(int data) {

        vector.add(data);
        int index = size() - 1;
        heapifyUp(index);
    }

    public Integer poll() {

        if (size() == 0)
            System.out.println("Index out of range(Heap underflow)");
        int root = vector.firstElement();

        vector.setElementAt(vector.lastElement(), 0);
        vector.remove(size() - 1);

        heapifyDown(0);
        return root;

    }

    public Integer peek() {

        if (size() == 0)
            System.out.println("Index out of range(Heap underflow)");

        return vector.firstElement();

    }

    public static void main(String[] args) {

        prioriryQueue prioriryQueue = new prioriryQueue();
        prioriryQueue.insert(10);
        prioriryQueue.insert(30);
        prioriryQueue.insert(40);
        prioriryQueue.insert(20);

        System.out.println(prioriryQueue.peek());
        prioriryQueue.poll();
        System.out.println(prioriryQueue.peek());

    }
}
