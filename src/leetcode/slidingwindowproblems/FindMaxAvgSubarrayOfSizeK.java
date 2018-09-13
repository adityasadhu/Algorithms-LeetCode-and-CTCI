//Given an array consisting of n integers, find the contiguous subarray of given length k
//that has the maximum average value. And you need to output the maximum average value.


package leetcode.slidingwindowproblems;

public class FindMaxAvgSubarrayOfSizeK {


    static public int answer(int[] array, int k) {

        int length = array.length;

        int sum = 0;

        int maxSum = Integer.MIN_VALUE;


        for (int i = 0; i < k; i++) {
            sum += array[i];
        }

        for (int i = k; i <= array.length; i++) {
            maxSum = Math.max(maxSum, sum);

            if (i == length)
                break;

            sum -= array[i - k];
            sum += array[i];

        }

        return maxSum / k;

    }

    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int answer = answer(array, 2);
        System.out.println(answer);

    }
}
