package Ctci.LinkedLists;

public class Intersection extends LinkedList {


    public ListNode answer(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null)
            return null;

        ListNode a = head1;
        ListNode b = head2;

        while (a != b) {
            a = a == null ? head1 : a.next;
            b = b == null ? head2 : b.next;
        }

        return a;

    }

    public static void main(String[] args) {

        Intersection intersection = new Intersection();

        intersection.append(10);
        intersection.append(20);
        intersection.append(30);
        ListNode temp1 = new ListNode(40);
        intersection.insertAtEnd(temp1);
        intersection.append(50);
        intersection.append(60);
//        intersection.show(intersection.getHead());

        Intersection intersection2 = new Intersection();
        intersection2.append(10);
        intersection2.append(20);
        ListNode temp2 = new ListNode(30);
        intersection2.insertAtEnd(temp2);
//        intersection2.show(intersection2.getHead());
        temp2.next = temp1;
//        intersection.show(intersection2.getHead());

        System.out.println((intersection.answer(intersection.getHead(), intersection2.getHead())).data);


    }
}
