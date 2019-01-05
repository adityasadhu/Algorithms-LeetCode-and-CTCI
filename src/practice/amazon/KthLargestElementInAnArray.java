package practice.amazon;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {


    public static int answer(int[] array, int k) {


        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i : array) {
            queue.offer(i);
        }

        int size = queue.size();
        System.out.println(queue);

        for (int i = 1; i < size; i++) {
            int answer = queue.poll();
            if (i == k)
                return answer;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(answer(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }
}
