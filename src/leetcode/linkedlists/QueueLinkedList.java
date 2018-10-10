package leetcode.linkedlists;

public class QueueLinkedList {

    Node front;
    Node rear;


    public QueueLinkedList(){
        front = null;
        rear = null;
    }
    public void enqueue(int data){
        Node newNode = new Node(data);

        if(front == null){
            newNode.next = null;
            front = newNode;
            rear = newNode;
            return;
        }else{
            rear.next = newNode;
            rear = newNode;
        }

    }

    public void dequeue(){
        if(front == null && rear == null){
            System.out.println("queue is empty nothing there to dequeue");
            return;
        }else if(front == rear){
            front = null;
            rear = null;
        }else{
            front = front.next;
        }

    }

    public void printqueue(){
        Node current = front;

        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }


    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.enqueue(10);
        queueLinkedList.enqueue(20);
        queueLinkedList.enqueue(30);
        //queueLinkedList.printqueue();
        queueLinkedList.dequeue();
        //queueLinkedList.dequeue();
        //queueLinkedList.enqueue(10);
        queueLinkedList.printqueue();
        //queueLinkedList.dequeue();

    }
}
