package leetcode.linkedlists;

public class RemoveNthNodeFromEndOfList extends LinkedList {


    public void remove(Node head, int n) {

        Node first = head;
        Node temp = head;


        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            temp = temp.next;
            first = first.next;
        }

        temp.next = temp.next.next;
    }

    public static void main(String[] args) {

        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        removeNthNodeFromEndOfList.append(10);
        removeNthNodeFromEndOfList.append(20);
        removeNthNodeFromEndOfList.append(30);
        removeNthNodeFromEndOfList.append(40);
        removeNthNodeFromEndOfList.append(50);
        removeNthNodeFromEndOfList.remove(head, 2);
        removeNthNodeFromEndOfList.show(head);


    }
}
