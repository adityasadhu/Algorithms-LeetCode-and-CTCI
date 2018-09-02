package leetcode.linkedlists;

public class Rotatelist {

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


    public Node rotateList(Node head, int k) {

        int length = 0;

        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        if (k > length) {
            k = k % length;
        }

        if (k == length) {
            return head;
        }

        current = new Node(0);
        current.next = head;
        for (int i = 0; i < length - k; i++) {
            current = current.next;
        }
        Node head2 = current.next;
        current.next = null;


        Node secondCurrent = head2;
        while (secondCurrent.next != null) {
            secondCurrent = secondCurrent.next;
        }

        secondCurrent.next = head;

        return head2;
    }

    public static void main(String[] args) {


        Rotatelist rotatelist = new Rotatelist();
        rotatelist.append(10);
        rotatelist.append(20);
        rotatelist.append(30);
        rotatelist.append(40);
        rotatelist.append(50);

        Node answerHead = rotatelist.rotateList(rotatelist.getHead(), 6);
        rotatelist.show(answerHead);

    }
}
