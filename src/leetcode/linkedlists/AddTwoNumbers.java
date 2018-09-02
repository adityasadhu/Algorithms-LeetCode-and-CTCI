//add two numbers represented in reverse in linkedlists

package leetcode.linkedlists;

public class AddTwoNumbers {


    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        LinkedList.head = head;
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

    public void append2(Node head1, int data) {
        if (head1 == null) {
            head1 = new Node(data);
        } else {
            Node temp = head1;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public void show(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }


    public Node addTwoNumbers(Node l1, Node l2) {

        Node head1 = l1, head2 = l2;

        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;
        while (head1 != null || head2 != null) {
            int x = (head1 != null) ? head1.data : 0;
            int y = (head2 != null) ? head2.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        if (carry > 0) {
            current.next = new Node(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {


        AddTwoNumbers l1 = new AddTwoNumbers();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        Node head1 = l1.getHead();


        AddTwoNumbers l2 = new AddTwoNumbers();
        l2.append(1);
        l2.append(8);
        l2.append(1);
        Node head2 = l2.getHead();


        Node resultHead = l2.addTwoNumbers(head1, head2);
        l2.show(resultHead);

    }
}
