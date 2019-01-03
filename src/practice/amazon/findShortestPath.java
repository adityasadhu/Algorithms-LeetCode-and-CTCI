package practice.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class findShortestPath {

    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> nestedList1 = new ArrayList<>();
        List<Integer> nestedList2 = new ArrayList<>();
        List<Integer> nestedList3 = new ArrayList<>();
        nestedList1.add(1);
        nestedList1.add(0);
        nestedList1.add(1);
        nestedList2.add(1);
        nestedList2.add(0);
        nestedList2.add(0);
        nestedList3.add(1);
        nestedList3.add(9);
        nestedList3.add(1);
        list.add(nestedList1);
        list.add(nestedList2);
        list.add(nestedList3);
        findShortestPath answer = new findShortestPath();
        System.out.println(answer.minimuimDistance(3, 3, list));
    }

    public int minimuimDistance(int numRows, int numCols, List<List<Integer>> area) {

        int answer = 0;

        boolean[][] visited = new boolean[numRows][numCols];
        int[][] grid = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = area.get(i).get(j);
            }
        }

        return bfs(0, 0, numRows, numCols, grid, visited, answer);
    }

    public int bfs(int i, int j, int numRows, int numCols, int[][] grid, boolean[][] visited, int answer) {
        visited[i][j] = true;
        Queue<Block> queue = new LinkedList<Block>();
        queue.offer(new Block(i, j));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Block b = queue.poll();
                if (grid[b.x][b.y] == 9)
                    return answer;
                for (int k = 0; k < 4; k++) {
                    int newX = b.x + xAxis[k];
                    int newY = b.y + yAxis[k];
                    if (shouldExplore(newX, newY, numRows, numCols, grid, visited)) {
                        visited[newX][newY] = true;
                        queue.offer(new Block(newX, newY));
                    }
                }
                size--;
            }
            answer++;
        }

        return -1;
    }

    private boolean shouldExplore(int i, int j, int numRows, int numCols, int[][] grid, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < numRows && j < numCols && visited[i][j] == false && (grid[i][j] == 1 || grid[i][j] == 9);
    }

    public class Block {
        private int x;
        private int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
