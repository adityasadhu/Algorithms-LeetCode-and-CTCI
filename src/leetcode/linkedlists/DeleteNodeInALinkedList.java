package leetcode.linkedlists;

public class DeleteNodeInALinkedList extends LinkedList {


    public void deleteNode(Node node) {

        if (node == null || node.next == null) {
            return;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }


    public static void main(String[] args) {

        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        deleteNodeInALinkedList.append(10);
        deleteNodeInALinkedList.append(20);
        deleteNodeInALinkedList.append(30);
        deleteNodeInALinkedList.show(head);
    }
}
