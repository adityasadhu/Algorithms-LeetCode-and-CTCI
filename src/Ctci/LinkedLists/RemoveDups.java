package Ctci.LinkedLists;


import java.util.HashSet;

public class RemoveDups {

    ListNode head;

    int length = 0;

    //default constructor
    public RemoveDups() {
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

    public void removeDups(ListNode head) {

        HashSet<Integer> hashSet = new HashSet<>();
        ListNode previous = null;
        ListNode temp = head;
        while (temp != null) {
            if (hashSet.contains(temp.data)) {
                previous.next = temp.next;
            } else {
                hashSet.add(temp.data);
                previous = temp;
            }
            temp = temp.next;
        }

    }

    public void removeDups2(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {

        RemoveDups removeDups = new RemoveDups();
        removeDups.append(10);
        removeDups.append(10);
        removeDups.append(20);
        removeDups.append(30);
        removeDups.append(20);
        //removeDups.show(removeDups.getHead());
        removeDups.removeDups2(removeDups.getHead());
        removeDups.show(removeDups.getHead());

    }
}
