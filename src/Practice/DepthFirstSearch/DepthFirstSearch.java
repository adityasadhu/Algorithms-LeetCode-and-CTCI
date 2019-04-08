package Practice.DepthFirstSearch;


import Practice.Graph;

import java.util.*;

public class DepthFirstSearch<T> {

    public static void main(String[] args) {

        DepthFirstSearch<Integer> depthFirstSearch1 = new DepthFirstSearch<>();
        Graph<Integer> graphDfs = new Graph<>();
        graphDfs.addEdge(0, 1);
        graphDfs.addEdge(1, 2);
        graphDfs.addEdge(1, 3);
        graphDfs.addEdge(0, 4);

        DepthFirstSearch<Character> depthFirstSearch2 = new DepthFirstSearch<>();
        Graph<Character> graph = new Graph<>();
        graph.addEdge('a', 'b');
        graph.addEdge('b', 'c');
        graph.addEdge('b', 'd');
        graph.addEdge('a', 'e');
        System.out.println(depthFirstSearch1.dfsUndirected(graphDfs));
        System.out.println(depthFirstSearch2.dfsUndirected(graph));
    }

    public List<T> dfsUndirected(Graph g) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        List<T> dfsOutput = new ArrayList<>();
        T start = (T) g.getVertex();
        stack.add(start);

        while (!stack.isEmpty()) {
            T pop = stack.pop();
            if (!visited.contains(pop)) {
                visited.add(pop);
                dfsOutput.add(pop);
            }
            if (g.getAdjacencyList().containsKey(pop)) {
                List<?> l = (List) g.getAdjacencyList().get(pop);
                l.forEach(vertex -> {
                    if (!visited.contains(vertex)) {
                        stack.push((T) vertex);
                    }
                });
            }
        }
        return dfsOutput;
    }
}
