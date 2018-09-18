//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//        Example:
//
//        Input: [-2,1,-3,4,-1,2,1,-5,4],
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
//        Follow up:
//
//        If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


package leetcode.arrays;

public class MaximumSubArray {


    //brute force ie calculating sum of all subarrays and returning the maximum sum
    static public int calculateSum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

    static public int answer(int[] array) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                maxSum = Math.max(calculateSum(array, i, j), maxSum);
            }
        }
        return maxSum;
    }

    // kadanes algorithm
    static public int optimizedAnswer(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {


        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int answer = optimizedAnswer(array);
        System.out.println(answer);

    }
}
