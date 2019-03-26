package Practice.Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElementInAnArray {


    public static int answer(int[] array, int k) {


        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i : array) {
            queue.offer(i);
        }

        int size = queue.size();

        for (int i = 1; i < size; i++) {
            int answer = queue.poll();
            if (i == k)
                return answer;
        }
        return -1;
    }

    public static int answerOptimized(int[] array, int k) {

        int start = 0;
        int end = array.length - 1;
        int kthSmallest = array.length - k;

        int answer = quickSelect(array, start, end, kthSmallest);


        return answer;
    }

    private static int quickSelect(int[] array, int start, int end, int kthSmallest) {

        if (start == end)
            return array[start];

        int pivot = partition(array, start, end);
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()) + " " + pivot);

        if (pivot == kthSmallest)
            return array[pivot];
        else if (pivot < kthSmallest) {
            return quickSelect(array, pivot + 1, end, kthSmallest);
        } else {
            return quickSelect(array, start, pivot - 1, kthSmallest);
        }

    }

    private static int partition(int[] array, int start, int end) {

        int i = start - 1;
        int pivot = array[end];
        for (int j = start; j < end; j++) {
            if (pivot >= array[j]) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(answerOptimized(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }
}
