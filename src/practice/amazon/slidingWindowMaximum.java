package practice.amazon;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class slidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int length = nums.length;

        int[] result = new int[length - k + 1];

        for (int i = 0; i < length; i++) {

            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }

        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.stream(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).boxed().collect(Collectors.toList()));

    }
}
