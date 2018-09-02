package Ctci.LinkedLists;




public class LinkedList {


    ListNode head;

    int length = 0;

    //default constructor
    public LinkedList() {
        length = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public void insertAtBegin(ListNode node) {
        node.next = head;
        head = node;
    }

    public void insertAtEnd(ListNode node) {

        if (node == null) {
            node = head;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = null;
        }
    }

    public void append(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(data);
        }
    }

    public void show(ListNode head) {

        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        ListNode node = new ListNode(10);
        linkedList.insertAtEnd(node);
        ListNode head = linkedList.getHead();
        //linkedList.show(head);

        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.show(l2.getHead());
    }
}
