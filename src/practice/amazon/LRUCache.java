/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

        Follow up:
        Could you do both operations in O(1) time complexity?

        Example:

        LRUCache cache = new LRUCache( 2 *//* capacity *//* );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4*/
package practice.amazon;

import java.util.HashMap;

public class LRUCache {

    private class DDLNode {
        int key;
        int value;
        DDLNode prev;
        DDLNode next;
    }

    private HashMap<Integer, DDLNode> hashMap = new HashMap<>();
    private DDLNode head, tail;
    private int maximumCapacity;
    private int totalItemsInCache;


    public LRUCache(int capacity) {

        totalItemsInCache = 0;
        maximumCapacity = capacity;


        head = new DDLNode();
        head.prev = null;

        tail = new DDLNode();
        tail.next = null;


        head.next = tail;
        tail.prev = head;
    }

    private void addNode(DDLNode node) {
        // 0 <-> 2


        // 0 <- 1 -> 2
        // wire the node that is inserted
        node.prev = head;
        node.next = head.next;

        //0 <- 1 <-> 2
        // rewire prev to point to node
        head.next.prev = node;

        //0 <-> 1 <-> 2
        //rewire
        head.next = node;
    }

    private void removeNode(DDLNode node) {

        DDLNode prevNode = node.prev;
        DDLNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    private void moveToHead(DDLNode node) {
        removeNode(node);
        addNode(node);
    }


    private DDLNode removeTail() {
        DDLNode toBeRemoved = tail.prev;
        removeNode(toBeRemoved);
        return toBeRemoved;
    }

    private void removeLRUEntryFromStructure() {
        DDLNode tail = removeTail();
        hashMap.remove(tail.key);
        --totalItemsInCache;
    }

    public int get(int key) {

        DDLNode node = hashMap.get(key);

        if (node == null)
            return -1;

        moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {

        DDLNode node = hashMap.get(key);

        if (node == null) {

            DDLNode newNode = new DDLNode();
            newNode.key = key;
            newNode.value = value;

            hashMap.put(key, newNode);
            addNode(newNode);

            totalItemsInCache++;

            if (totalItemsInCache > maximumCapacity)
                removeLRUEntryFromStructure();

        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));      // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
