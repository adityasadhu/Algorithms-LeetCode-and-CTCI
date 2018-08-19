package leetcode.linkedlists;

public class ReverseLinkedLisrt extends LinkedList {


    public Node reverse(Node head) {

        Node temp = null;
        Node current = head;
        Node prev = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head = prev;

        return head;

    }

    public static void main(String[] args) {


        ReverseLinkedLisrt reverseLinkedLisrt = new ReverseLinkedLisrt();
        reverseLinkedLisrt.append(10);
        reverseLinkedLisrt.append(20);
        reverseLinkedLisrt.append(30);
        reverseLinkedLisrt.append(40);
        Node answer = reverseLinkedLisrt.reverse(head);
        reverseLinkedLisrt.show(answer);
    }
}
