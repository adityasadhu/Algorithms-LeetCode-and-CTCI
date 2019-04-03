package Practice.DepthFirstSearch;


import java.util.*;

public class DepthFirstSearch<T> {

    public static void main(String[] args) {

        DepthFirstSearch<Integer> depthFirstSearch1 = new DepthFirstSearch<>();
        GraphDfs<Integer> graphDfs = new GraphDfs<>();
        graphDfs.addEdge(0, 1);
        graphDfs.addEdge(1, 2);
        graphDfs.addEdge(1, 3);
        graphDfs.addEdge(0, 4);

        DepthFirstSearch<Character> depthFirstSearch2 = new DepthFirstSearch<>();
        GraphDfs<Character> graph = new GraphDfs<>();
        graph.addEdge('a', 'b');
        graph.addEdge('b', 'c');
        graph.addEdge('b', 'd');
        graph.addEdge('a', 'e');
        System.out.println(depthFirstSearch1.dfsUndirected(graphDfs));
        System.out.println(depthFirstSearch2.dfsUndirected(graph));
    }

    public List<T> dfsUndirected(GraphDfs g) {
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
            if (g.adjacencyList.containsKey(pop)) {
                List<?> l = (List) g.adjacencyList.get(pop);
                l.stream().forEach(vertex -> {
                    if (!visited.contains(vertex)) {
                        stack.push((T) vertex);
                    }
                });
            }
        }
        return dfsOutput;
    }

    public static class GraphDfs<T> {

        Map<T, List<T>> adjacencyList;

        int vertices;

        public GraphDfs() {
            adjacencyList = new HashMap<>();
        }

        public void addEdge(T a, T b) {
            if (this.adjacencyList.containsKey(a)) {
                this.adjacencyList.get(a).add(b);
                vertices++;
            } else {
                List<T> list = new ArrayList<>();
                list.add(b);
                this.adjacencyList.put(a, list);
                vertices++;
            }
            if (this.adjacencyList.containsKey(b)) {
                this.adjacencyList.get(b).add(a);
            } else {
                List<T> list = new ArrayList<>();
                list.add(a);
                this.adjacencyList.put(b, list);
            }
        }

        public int getVertices() {
            return vertices;
        }

        public T getVertex() {
            for (Map.Entry<T, List<T>> iterator : adjacencyList.entrySet()) {
                return iterator.getKey();
            }
            return null;
        }
    }


}
