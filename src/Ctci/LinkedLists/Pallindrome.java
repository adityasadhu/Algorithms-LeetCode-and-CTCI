//check if th linkedList us pallindrome or not

package Ctci.LinkedLists;

public class Pallindrome {

    public boolean answer(ListNode head) {

        ListNode reversedList = reverseList(head);
        return isEqual(head, reversedList);
    }

    private boolean isEqual(ListNode head, ListNode reversedList) {

        while (head != null && reversedList != null) {
            if (head.data != reversedList.data)
                return false;

            head = head.next;
            reversedList = reversedList.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {

        ListNode headReversedList = null;

        while (head != null) {
            ListNode temp = new ListNode(head.data);
            temp.next = headReversedList;
            headReversedList = temp;
            head = head.next;
        }
        return headReversedList;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        Pallindrome pallindrome = new Pallindrome();

        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        System.out.println(pallindrome.answer(linkedList.getHead()));
    }
}
