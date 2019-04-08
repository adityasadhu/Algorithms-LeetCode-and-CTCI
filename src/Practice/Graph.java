package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private int vertices;
    private Map<T, List<T>> adjacencyList;

    public Graph() {
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
        return adjacencyList.entrySet().stream().findFirst().map(Map.Entry::getKey).orElse(null);
    }

    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }
}
