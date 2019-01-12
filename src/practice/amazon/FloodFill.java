/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

        Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

        To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

        At the end, return the modified image.

        Example 1:
        Input:
        image = [[1,1,1],[1,1,0],[1,0,1]]
        sr = 1, sc = 1, newColor = 2
        Output: [[2,2,2],[2,2,0],[2,0,1]]
        Explanation:
        From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
        by a path of the same color as the starting pixel are colored with the new color.
        Note the bottom corner is not colored 2, because it is not 4-directionally connected
        to the starting pixel.
        Note:

        The length of image and image[0] will be in the range [1, 50].
        The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
        The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
*/


package practice.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] xAxis = {1, 0, -1, 0};
    int[] yAxis = {0, -1, 0, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<Point> queue = new LinkedList<>();
        int rowLength = image.length;
        int colLength = image[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        queue.add(new Point(sr, sc));
        visited[sr][sc] = true;
        int[][] answer = image;
        int checkColor = image[sr][sc];

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Point check = queue.poll();
                answer[check.x][check.y] = newColor;
                for (int i = 0; i < 4; i++) {
                    int newX = check.x + xAxis[i];
                    int newY = check.y + yAxis[i];
                    if (shouldExplore(image, visited, rowLength, colLength, newX, newY, checkColor)) {
                        visited[newX][newY] = true;
                        queue.add(new Point(newX, newY));
                    }
                }
                size--;
            }
        }

        return answer;
    }

    private boolean shouldExplore(int[][] image, boolean[][] visted, int rowLength, int colLength, int newX, int newY, int checkColor) {
        return (newX >= 0) && (newX < rowLength) && (newY >= 0) && (newY < colLength) && !visted[newX][newY] && (image[newX][newY] == checkColor);
    }

    public static void main(String[] args) {

    }
}
