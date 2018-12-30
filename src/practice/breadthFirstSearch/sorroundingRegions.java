//https://leetcode.com/problems/surrounded-regions/
package practice.breadthFirstSearch;


import java.util.LinkedList;
import java.util.Queue;

public class sorroundingRegions {

    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public void answer(char[][] board) {

        int rowLength = board.length;
        int colLength = board[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {

                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if ((i == 0 || i == rowLength - 1 || j == 0 || j == colLength - 1) && board[i][j] == 'O') {
                    bfs(board, i, j, rowLength, colLength);
                }
            }
        }

        for (int l = 0; l < rowLength; l++) {
            for (int k = 0; k < colLength; k++) {
                if (board[l][k] == 'A')
                    board[l][k] = 'O';
                else if (board[l][k] == 'O')
                    board[l][k] = 'X';
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(char[][] board, int i, int j, int rowLength, int colLength) {

        Queue<Point> queue = new LinkedList<>();
        board[i][j] = 'A';
        queue.offer(new Point(i, j));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = point.x + xAxis[k];
                int newY = point.y + yAxis[k];
                if (newX >= 0 && newX < rowLength && newY >= 0 && newY < colLength && board[newX][newY] == 'O') {
                    board[newX][newY] = 'A';
                    queue.offer(new Point(newX, newY));
                }
            }
        }

    }


    public class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {

        sorroundingRegions sorroundingRegions = new sorroundingRegions();
        /*char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};*/

        char[][] board = {{'X', 'O'},
                {'O', 'X'}};

        sorroundingRegions.answer(board);

    }
}
