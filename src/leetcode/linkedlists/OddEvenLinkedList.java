package leetcode.linkedlists;

public class OddEvenLinkedList {


    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        LinkedList.head = head;
    }

    Node head;

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

    public void show(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    public Node oddEven(Node head) {


        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {


        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        oddEvenLinkedList.append(10);
        oddEvenLinkedList.append(20);
        oddEvenLinkedList.append(30);
        oddEvenLinkedList.append(40);
        oddEvenLinkedList.append(50);
        oddEvenLinkedList.append(60);
        //oddEvenLinkedList.show(oddEvenLinkedList.getHead());
        Node answerHead = oddEvenLinkedList.oddEven(oddEvenLinkedList.getHead());
        oddEvenLinkedList.show(answerHead);


    }
}
