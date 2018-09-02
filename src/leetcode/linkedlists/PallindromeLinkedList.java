package leetcode.linkedlists;

import java.util.Stack;

public class PallindromeLinkedList extends LinkedList {

    public boolean isPallindrome(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //handling odd case moving slow pointer
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PallindromeLinkedList pallindromeLinkedList = new PallindromeLinkedList();
        pallindromeLinkedList.append(10);
        pallindromeLinkedList.append(20);
//        pallindromeLinkedList.append(30);
        pallindromeLinkedList.append(30);
        pallindromeLinkedList.append(20);
        pallindromeLinkedList.append(10);
        boolean result = pallindromeLinkedList.isPallindrome(head);
        System.out.println(result);

    }
}
