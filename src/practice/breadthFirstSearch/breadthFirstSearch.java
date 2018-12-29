/*
Graphs
Graph = G = { E, V }

One of the problems is how we represent graphs
adjacency lists is a good way to represent them

adjacency lists
    array Adj of |v| - > linked lists

    for each vertex u belongs v
    adj[u] stores neighbors


Graph search applications:
    -web crawling
    -social networking (example friends of friends)
    -network broadcast
    -garbage collection


Breadth -first search
    -visit all the nodes reachable from given vertex
    -in O(V + E)
    -Careful to avoid duplicates




*/
package practice.breadthFirstSearch;

import practice.Node;

import java.util.LinkedList;
import java.util.Queue;

public class breadthFirstSearch {

    public static String toyImplementationbfs(Node root, int toFind) {

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print("-> " + temp.data);
            if (temp.data == toFind) {
                return "nice nice found using BFS";
            }

            if (temp.left != null)
                queue.offer(temp.left);

            if (temp.right != null)
                queue.offer(temp.right);

        }
        return "the item you are searching is not there in the graph";
    }


    public static void main(String[] args) {
/*                             1
                ------------------------------
                2                             5
         ----------------               ---------------
        3                 4             6              7
                                                   ---------
                                                   8        null
 */
        Node root = new Node(1,
                new Node(2, new Node(3), new Node(4)),
                new Node(5, new Node(6), new Node(7, new Node(8), null)));

        System.out.println("\n" + toyImplementationbfs(root, 8));

    }
}
