//package practice;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class MinCost {
//
//    public static void main(String[] args) {
//
//
//        List<List<Integer>> networkRoutesAvailable = new ArrayList<>();
//        networkRoutesAvailable.add(Arrays.stream(new int[]{1, 4}).boxed().collect(Collectors.toList()));
//        networkRoutesAvailable.add(Arrays.stream(new int[]{4, 5}).boxed().collect(Collectors.toList()));
//        networkRoutesAvailable.add(Arrays.stream(new int[]{2, 3}).boxed().collect(Collectors.toList()));
//
//        List<List<Integer>> costNewNetworkRoutesConsruct = new ArrayList<>();
//        costNewNetworkRoutesConsruct.add(Arrays.stream(new int[]{1, 2, 5}).boxed().collect(Collectors.toList()));
//        costNewNetworkRoutesConsruct.add(Arrays.stream(new int[]{1, 3, 10}).boxed().collect(Collectors.toList()));
//        costNewNetworkRoutesConsruct.add(Arrays.stream(new int[]{1, 6, 2}).boxed().collect(Collectors.toList()));
//        costNewNetworkRoutesConsruct.add(Arrays.stream(new int[]{5, 6, 5}).boxed().collect(Collectors.toList()));
//
//
//        minCost(6, 3, networkRoutesAvailable, 4, costNewNetworkRoutesConsruct);
//
//    }
//
//    public static int minCost(int numTotalEdgeNodes, int numTotalAvailableNetworksRoutes, List<List<Integer>> networkRoutesAvailable, int numNewNetworkRoutesConstruct,
//                              List<List<Integer>> costNewNetworkRoutesConsruct) {
//
//
//        List<List<Integer>> totalNetworks = new ArrayList<>();
//
//        List<Integer> inner = new ArrayList<>();
//
//
//        LinkedList<Integer>[] adjacencyList;
//        adjacencyList = new LinkedList[numTotalEdgeNodes];
//
//        for (int i = 0; i < numTotalEdgeNodes; i++) {
//            adjacencyList[i] = new LinkedList<>();
//        }
//
//        for (List l : networkRoutesAvailable) {
//            int start = (int) l.get(0);
//            int end = (int) l.get(1);
//
//            adjacencyList[start].add(end);
//        }
//
//        boolean[] visited = new boolean[numTotalEdgeNodes + 1];
//
//        for (int i = 1; i< adjacencyList.length; i++){
//            visited[i] = true;
//            inner = makeNetwork(visited, adjacencyList, i);
//        }
//
//        System.out.println(Arrays.asList(adjacencyList));
//
//
//        return 0;
//
//    }
//
//    private static List<Integer> makeNetwork(boolean[] visited, LinkedList<Integer>[] adjacencyList, int i) {
//
//
//        Iterator<Integer> iterator = null;
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        while (!queue.isEmpty()) {
//
//            int temp = queue.poll();
//
//            if (visited[temp] == true)
//                continue;
//
//            visited[temp] = true;
//
//            iterator = adjacencyList[temp].listIterator();
//
//            while (iterator.hasNext()) {
//                int next = iterator.next();
//                if (visited[next] != true)
//                    queue.offer(next);
//            }
//        }
//    }
//
//
//}
