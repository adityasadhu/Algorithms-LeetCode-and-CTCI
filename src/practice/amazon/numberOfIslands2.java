/*
A 2d grid map of m rows and n columns is initially filled with water.
We may perform an addLand operation which turns the water at position (row, col) into a land.
Given a list of positions to operate, count the number of islands after each addLand operation.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]


*/

package practice.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class numberOfIslands2 {

    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> result = new ArrayList<>();
        List<Block> positionsList = new ArrayList<>();
        int numOfPositions = positions.length;

        for (int i = 0; i < numOfPositions; i++) {
            positionsList.add(new Block(positions[i][0], positions[i][1]));
        }

        int[][] grid = new int[m][n];

        for (Block b : positionsList) {
            grid[b.x][b.y] = 1;
            result.add(answerBFS(grid));
        }

        return result;
    }

    public int answerBFS(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                explore(i, j, grid, row, col, visited);
                count++;
            }
        }
        return count;
    }

    public void explore(int i, int j, int[][] grid, int row, int col, boolean[][] visited) {
        if (!shouldExplore(i, j, grid, row, col, visited)) {
            return;
        }
        visited[i][j] = true;

        Queue<Block> queue = new LinkedList<Block>();
        queue.offer(new Block(i, j));
        while (!queue.isEmpty()) {
            Block b = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = b.x + xAxis[k];
                int newY = b.y + yAxis[k];
                if (shouldExplore(newX, newY, grid, row, col, visited)) {
                    visited[newX][newY] = true;
                    queue.offer(new Block(newX, newY));

                }
            }

        }
    }

    public boolean shouldExplore(int i, int j, int[][] grid, int row, int col, boolean[][] visited) {
        if (i >= 0 && j >= 0 && i < row && j < col && visited[i][j] == false && grid[i][j] == 1) {
            return true;
        }
        return false;
    }

    public class Block {
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {

        numberOfIslands2 numberOfIslands2 = new numberOfIslands2();
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        System.out.println(numberOfIslands2.numIslands2(3, 3, positions));

    }
}
