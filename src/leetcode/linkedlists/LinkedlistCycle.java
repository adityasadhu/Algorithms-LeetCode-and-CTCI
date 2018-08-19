package leetcode.linkedlists;

public class LinkedlistCycle extends LinkedList{

    public boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow ==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedlistCycle linkedlistCycle = new LinkedlistCycle();
        linkedlistCycle.append(10);
        linkedlistCycle.append(20);
        linkedlistCycle.append(30);
        linkedlistCycle.append(40);
       // head.next.next.next.next = head;
        boolean result = linkedlistCycle.hasCycle(head);
        System.out.println(result);



    }
}