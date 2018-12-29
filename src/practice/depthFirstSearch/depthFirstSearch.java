package practice.depthFirstSearch;

import java.util.Iterator;
import java.util.LinkedList;

public class depthFirstSearch {

    public int v;

    public LinkedList<Integer>[] adjacencyList;

    public depthFirstSearch(int v) {
        this.v = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        adjacencyList[a].add(b);
    }

    public boolean dfs(int vertex, int toFind, int graphSize) {

        boolean[] visited = new boolean[graphSize];

        return dfsUtil(visited, vertex, toFind);
    }

    public boolean dfsUtil(boolean[] visited, int vertex, int toFind) {

        if (visited[vertex] == true)
            return false;

        visited[vertex] = true;

        if (vertex == toFind)
            return true;

        Iterator<Integer> iterator = adjacencyList[vertex].listIterator();

        while (iterator.hasNext()) {
            int next = iterator.next();
            if (dfsUtil(visited, next, toFind)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        depthFirstSearch g = new depthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(g.dfs(0, 3, 4));
    }
}
