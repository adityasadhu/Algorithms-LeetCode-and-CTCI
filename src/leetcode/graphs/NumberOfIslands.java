//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//        Output: 1
//        Example 2:
//
//        Input:
//        11000
//        11000
//        00100
//        00011
//
//        Output: 3


package leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {


    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public class Block {
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //DFS
    static public int answerDFS(int[][] grid) {
        int numberOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numberOfIslands++;
                    makeAdjacentIslandsWater(grid, i, j);
                }

            }

        }

        return numberOfIslands;
    }

    static public void makeAdjacentIslandsWater(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        makeAdjacentIslandsWater(grid, i - 1, j);
        makeAdjacentIslandsWater(grid, i + 1, j);
        makeAdjacentIslandsWater(grid, i, j - 1);
        makeAdjacentIslandsWater(grid, i, j + 1);

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


    public static void main(String[] args) {


        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1}};
        //int answer = answerDFS(grid);

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int answer = numberOfIslands.answerBFS(grid);
        System.out.println(answer);


    }
}
