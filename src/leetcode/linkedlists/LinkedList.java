package leetcode.linkedlists;

public class LinkedList {
    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        LinkedList.head = head;
    }

    static Node head;

    public void append(int data) {

        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }

    }

    public void append2(Node head1, int data){
        if (head1 == null) {
            head1 = new Node(data);
        } else {
            Node temp = head1;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public void show(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(6);
        linkedList.show(head);
    }
}
