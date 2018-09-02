//Reverse a linked list from position m to n. Do it in one-pass.
//
//        Note: 1 ≤ m ≤ n ≤ length of list.
//
//        Example:
//
//        Input: 1->2->3->4->5->NULL, m = 2, n = 4
//        Output: 1->4->3->2->5->NULL


package leetcode.linkedlists;

public class ReverseLinkedList2 {


    public Node getHead() {
        return this.head;
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

    public Node reverse(int m, int n, Node head) {

        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        Node start = pre.next;
        Node then = start.next;


        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;

    }


    public static void main(String[] args) {


        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        reverseLinkedList2.append(10);
        reverseLinkedList2.append(20);
        reverseLinkedList2.append(30);
        reverseLinkedList2.append(40);
        reverseLinkedList2.append(50);
        reverseLinkedList2.append(60);
        reverseLinkedList2.append(70);
        Node answerHead = reverseLinkedList2.reverse(2, 5, reverseLinkedList2.getHead());
        reverseLinkedList2.show(answerHead);


    }
}
