package practice.breadthFirstSearch;


import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public int[][] updateMatrix(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] answer = new int[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] != 0) {
                    boolean[][] visited = new boolean[rowLength][colLength];
                    int distance = bfs(matrix, visited, rowLength, colLength, i, j);
                    answer[i][j] = distance;
                }
            }

        }

        return answer;

    }

    private int bfs(int[][] matrix, boolean[][] visited, int rowLength, int colLength, int i, int j) {
        int distance = 0;
        Queue<Block> queue = new LinkedList<>();
        boolean flag = false;
        visited[i][j] = true;
        queue.offer(new Block(i, j));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Block b = queue.poll();
                if (flag) {
                    if (matrix[b.x][b.y] == 0)
                        return distance;
                }
                flag = true;
                for (int k = 0; k < 4; k++) {
                    int newX = b.x + xAxis[k];
                    int newY = b.y + yAxis[k];
                    if (shouldExplore(newX, newY, rowLength, colLength, matrix, visited)) {
                        visited[newX][newY] = true;
                        queue.offer(new Block(newX, newY));
                    }
                }
                size--;
            }
            distance++;
        }

        return -1;
    }

    private boolean shouldExplore(int i, int j, int numRows, int numCols, int[][] grid, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < numRows && j < numCols && !visited[i][j];
    }

    public class Block {
        private int x;
        private int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Matrix01 matrix01 = new Matrix01();

        int[][] answer = matrix01.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }

    }
}
