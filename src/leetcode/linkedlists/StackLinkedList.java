package leetcode.linkedlists;


public class StackLinkedList {

    Node top;

    public StackLinkedList() {
        top = null;
    }


    public void push(int data) {
        Node newNode = new Node(data);

        if (top == null) {
            newNode.next = null;
        } else {
            newNode.next = top;
        }
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            System.out.println("stack is empty nothing there to pop");
            return;
        }
        top = top.next;
    }

    public void peek() {
        if (top == null) {
            return;
        }
        System.out.println(top.data);
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(10);
        stackLinkedList.push(20);
        stackLinkedList.printStack();
//        stackLinkedList.peek();
        stackLinkedList.pop();
        stackLinkedList.pop();
        stackLinkedList.printStack();
        stackLinkedList.pop();
    }
}
