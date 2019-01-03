/*In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

        Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

        Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)



        Example 1:

        Input: [[0,1],[1,0]]
        Output: 1
        Example 2:

        Input: [[0,1,0],[0,0,0],[0,0,1]]
        Output: 2
        Example 3:

        Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
        Output: 1


        Note:

        1 <= A.length = A[0].length <= 100
        A[i][j] == 0 or A[i][j] == 1*/
package practice.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;


public class shortestBridge {

    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public int answer(int[][] grid) {

        Queue<Block> queue = new LinkedList<>();

        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean found = false;
        boolean[][] visited = new boolean[rowLength][colLength];
        for (int i = 0; i < grid.length; i++) {
            if (found)
                break;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    dfsToFindAnIsland(grid, visited, i, j, rowLength, colLength, queue);
                    found = true;
                    break;
                }
            }
        }

        return expandTheFoundIsland(grid, visited, queue, rowLength, colLength);

    }

    public int expandTheFoundIsland(int[][] grid, boolean[][] visited, Queue<Block> queue, int rowLength, int colLength) {
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Block block = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = block.i + xAxis[k];
                    int newY = block.j + yAxis[k];
                    if (newX >= 0 && newY >= 0 && newX < colLength && newY < rowLength && !visited[newX][newY]) {
                        if (grid[newX][newY] == 1) {
                            return answer;
                        }
                        queue.offer(new Block(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            answer++;
        }
        return -1;

    }

    public void dfsToFindAnIsland(int[][] grid, boolean[][] visited, int i, int j, int rowLength, int colLength, Queue<Block> queue) {
        if (i < 0 || j < 0 || i >= rowLength || j >= colLength || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new Block(i, j));

        dfsToFindAnIsland(grid, visited, i - 1, j, rowLength, colLength, queue);
        dfsToFindAnIsland(grid, visited, i + 1, j, rowLength, colLength, queue);
        dfsToFindAnIsland(grid, visited, i, j - 1, rowLength, colLength, queue);
        dfsToFindAnIsland(grid, visited, i, j + 1, rowLength, colLength, queue);
    }

    public class Block {
        int i;
        int j;

        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {

        shortestBridge shortestBridge = new shortestBridge();
        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(shortestBridge.answer(grid));

    }
}

