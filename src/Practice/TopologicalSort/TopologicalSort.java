package Practice.TopologicalSort;

import java.util.*;

public class TopologicalSort {


    public static List<Integer> topSort(Graph graph) {
        Stack<Integer> result = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer>[] adjacencyList = graph.adjacencyList;

        List<Integer> vertices = new ArrayList<>();

        for (int i = 0; i < graph.adjacencyList.length; i++) {
            if (graph.adjacencyList[i] != null)
                vertices.add(i);
        }


        vertices.forEach(vertex -> {
            if (visited.contains(vertex))
                return;
            topSortUtil(visited, result, vertex, graph);

        });

        return result;
    }

    private static void topSortUtil(Set<Integer> visited, Stack<Integer> result, Integer vertex, Graph graph) {

        visited.add(vertex);
        if (graph.adjacencyList[vertex] != null){
            graph.adjacencyList[vertex].forEach(v -> {
                if(visited.contains(v))
                    return;
                topSortUtil(visited, result, v, graph);
            });
        }

        result.add(vertex);
    }

    public static class Graph {

        int vertices;
        List<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new List[vertices];
            for (int i = 0; i < vertices; i++) {
                 adjacencyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int a, int b) {
            adjacencyList[a].add(b);
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(7);

        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,6);

        List<Integer> answer = topSort(graph);
        Collections.reverse(answer);
        System.out.println(answer);
    }


}

