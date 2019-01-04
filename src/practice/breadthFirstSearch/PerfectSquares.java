/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

        Example 1:

        Input: n = 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.
        Example 2:

        Input: n = 13
        Output: 2
        Explanation: 13 = 4 + 9.*/


package practice.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    static int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            System.out.println(queue);
            int size = queue.size();
            while (size > 0) {
                int number = queue.poll();
                for (int i = 1; i * i <= number; ++i) {
                    if (number == i * i)
                        return ++depth;
                    if (number - i * i > 0)
                        queue.offer(number - i * i);
                }
                size--;
            }
            ++depth;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(40));
    }
}
