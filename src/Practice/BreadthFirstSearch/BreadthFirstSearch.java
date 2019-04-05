package Practice.BreadthFirstSearch;

import Practice.Graph;

import java.util.*;

public class BreadthFirstSearch<T> {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(0, 4);

        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
        System.out.println(bfs.bfs(graph));
    }

    public List<T> bfs(Graph g) {
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        List<T> bfsOutput = new ArrayList<>();

        T start = (T) g.getVertex();
        queue.offer(start);

        while (!queue.isEmpty()) {
            T t = queue.poll();
            if (!visited.contains(t)) {
                bfsOutput.add(t);
                visited.add(t);
            }
            if (g.getAdjacencyList().containsKey(t)) {
                List<T> list = (List<T>) g.getAdjacencyList().get(t);
                list.stream().forEach(vertex -> {
                    if (!visited.contains(vertex)){
                        queue.offer(vertex);
                    }
                });
            }
        }

        return bfsOutput;
    }
}
