/*
delete the middle node of a linkedlist given  access to only that node
*/

package Ctci.LinkedLists;

public class DeleteMiddleNode {

    public boolean deleteMiddleNode(ListNode node) {

        if (node == null || node.next == null)
            return false;

        ListNode after = node.next;
        node.data = after.data;
        node.next = after.next;

        return true;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.insertAtBegin(new ListNode(0));
        ListNode temp = linkedList.getHead();

        for (int i = 0; i < 1; i++) {
            temp = temp.next;
        }

        deleteMiddleNode.deleteMiddleNode(temp);
        linkedList.show(linkedList.getHead());
    }
}
