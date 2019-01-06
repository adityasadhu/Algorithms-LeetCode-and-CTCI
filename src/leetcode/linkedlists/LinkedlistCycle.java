package leetcode.linkedlists;

import java.util.HashSet;

public class LinkedlistCycle extends LinkedList {

    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    //with HashSet

    public boolean hasCycleHashSet(Node head) {

        HashSet<Node> hashSet = new HashSet<>();

        Node current = head;
        Node hasCycleNode = null;

        while (current != null) {
            if (hashSet.contains(current)) {
                hasCycleNode = current;
                removeCycle(current);
                return true;
            } else {
                hashSet.add(current);
            }
            current = current.next;
        }
        return false;
    }


    public void removeCycle(Node node) {
        Node current = node;

        while (true) {
            if (current.next == node)
                break;
            current = current.next;
        }
        current.next = null;
    }

    public static void main(String[] args) {

        LinkedlistCycle linkedlistCycle = new LinkedlistCycle();
        linkedlistCycle.append(10);
        linkedlistCycle.append(20);
        linkedlistCycle.append(30);
        linkedlistCycle.append(40);
        head.next.next.next.next = head.next;
        boolean result = linkedlistCycle.hasCycleHashSet(head);
        System.out.println(result);
        linkedlistCycle.show(head);
        boolean result2 = linkedlistCycle.hasCycleHashSet(head);
        System.out.println(result2);
        linkedlistCycle.show(head);


    }
}