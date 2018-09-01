package Ctci.LinkedLists;

public class ReturnKthToLast {

    ListNode head;

    int length = 0;

    //default constructor
    public ReturnKthToLast() {
        length = 0;
    }

    public ListNode getHead() {
        return head;
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

    public void returnkthToLast(ListNode head, int k) {
        ListNode temp = head;
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            current = current.next;
            temp = temp.next;
        }
        System.out.println(current.data);
    }


    public static void main(String[] args) {

        ReturnKthToLast linkedList = new ReturnKthToLast();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.append(40);
        linkedList.returnkthToLast(linkedList.getHead(), 3);

    }


}
