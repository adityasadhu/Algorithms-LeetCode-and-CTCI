package leetcode.linkedlists;

public class ReorderList {

    public Node getHead() {
        return this.head;
    }

    Node head;

    public void append(int data) {

        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }

    }

    public void show(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node reOrderList(Node head) {


        Node slow = head;
        Node fast = head;
        Node firstHead = head;
        Node prev = null;


        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        Node secondHead = reverse(slow);
//        show(firstHead);
//        show(secondHead);


        Node nextHead1 = firstHead.next;
        Node nextHead2 = secondHead.next;
        while (firstHead != null) {
            firstHead.next = secondHead;
            if (nextHead1 == null) {
                break;
            }
            secondHead.next = nextHead1;
            firstHead = nextHead1;
            secondHead = nextHead2;
            nextHead1 = firstHead.next;
            nextHead2 = secondHead.next;
        }

        return head;


    }

    public Node reverse(Node head) {

        Node prev = null;
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;

    }

    public static void main(String[] args) {

        ReorderList reorderList = new ReorderList();
        reorderList.append(10);
        reorderList.append(20);
        reorderList.append(30);
        reorderList.append(40);
        //reorderList.append(50);
        Node answer = reorderList.reOrderList(reorderList.getHead());
        reorderList.show(answer);


    }

}
