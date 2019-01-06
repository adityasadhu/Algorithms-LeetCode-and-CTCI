/*You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

        0 represents the obstacle can't be reached.
        1 represents the ground can be walked through.
        The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
        You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

        You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

        You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

        Example 1:
        Input:
        [
        [1,2,3],
        [0,0,4],
        [7,6,5]
        ]
        Output: 6
        Example 2:
        Input:
        [
        [1,2,3],
        [0,0,0],
        [7,6,5]
        ]
        Output: -1
        Example 3:
        Input:
        [
        [2,3,4],
        [0,0,5],
        [8,7,6]
        ]
        Output: 6
        Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.*/

package practice.amazon;

import java.util.*;

public class CutOfTreesForGolfEvent {

    private int[] xAxis = {1, 0, -1, 0};
    private int[] yAxis = {0, -1, 0, 1};

    public class point {
        int i;
        int j;
        int value;

        point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        point(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    private int cutOffTree(List<List<Integer>> forest) {

        PriorityQueue<point> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        int rowLength = forest.size();
        int colLength = forest.get(0).size();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (forest.get(i).get(j) > 1) {
                    queue.add(new point(i, j, forest.get(i).get(j)));
                }
            }
        }

        int startX = 0;
        int startY = 0;
        int sum = 0;

        while (!queue.isEmpty()) {
            point check = queue.poll();
            int step = bfs(forest, startX, startY, check.i, check.j, rowLength, colLength);

            if (step < 0)
                return -1;

            sum += step;

            startX = check.i;
            startY = check.j;
        }
        return sum;
    }

    private int bfs(List<List<Integer>> forest, int startX, int startY, int destinationX, int destinationY, int rowLength, int colLength) {

        int step = 0;
        boolean[][] visited = new boolean[rowLength][colLength];
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                point check = queue.poll();
                if (check.i == destinationX && check.j == destinationY)
                    return step;
                for (int k = 0; k < 4; k++) {
                    int newX = check.i + xAxis[k];
                    int newY = check.j + yAxis[k];
                    if (newX < 0 || newX >= rowLength || newY < 0 || newY >= colLength
                            || forest.get(newX).get(newY) == 0 || visited[newX][newY]) continue;
                    queue.add(new point(newX, newY));
                    visited[newX][newY] = true;
                }
                size--;
            }
            step++;
        }
        return -1;
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> nestedList1 = new ArrayList<>();
        nestedList1.add(1);
        nestedList1.add(2);
        nestedList1.add(3);
        List<Integer> nestedList2 = new ArrayList<>();
        nestedList2.add(0);
        nestedList2.add(0);
        nestedList2.add(4);
        List<Integer> nestedList3 = new ArrayList<>();
        nestedList3.add(7);
        nestedList3.add(6);
        nestedList3.add(5);
        list.add(nestedList1);
        list.add(nestedList2);
        list.add(nestedList3);
        CutOfTreesForGolfEvent c = new CutOfTreesForGolfEvent();
        System.out.println(c.cutOffTree(list));
    }
}
