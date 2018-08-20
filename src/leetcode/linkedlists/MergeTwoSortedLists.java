package leetcode.linkedlists;

import sun.awt.image.ImageWatched;

public class MergeTwoSortedLists extends LinkedList {

    public Node merge(Node l1, Node l2) {

        Node prehead = new Node(-1);
        Node prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        Node head1 = new Node(0);
        Node head2 = new Node(20);
        mergeTwoSortedLists.append2(head1,10);
        mergeTwoSortedLists.append2(head1, 30);


        MergeTwoSortedLists mergeTwoSortedLists1 = new MergeTwoSortedLists();
        mergeTwoSortedLists1.append2(head2, 40);
        mergeTwoSortedLists.append2(head2,50);


        Node resultHead = mergeTwoSortedLists.merge(head1, head2);
        mergeTwoSortedLists.show(resultHead);


    }
}
