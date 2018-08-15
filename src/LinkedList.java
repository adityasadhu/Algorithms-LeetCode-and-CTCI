class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    node head;

    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.show();
    }

    public void append(int data) {

        if (head == null) {
            head = new node(data);

        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new node(data);

        }

    }

    public void show() {
        node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);

    }
}