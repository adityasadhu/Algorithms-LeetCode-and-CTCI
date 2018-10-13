//Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//        Example 1:
//
//        Input: [1,2,3,4,5,6,7] and k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]
//        Example 2:
//
//        Input: [-1,-100,3,99] and k = 2
//        Output: [3,99,-1,-100]
//        Explanation:
//        rotate 1 steps to the right: [99,-1,-100,3]
//        rotate 2 steps to the right: [3,99,-1,-100]
//        Note:
//
//        Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//        Could you do it in-place with O(1) extra space?


package leetcode.arrays;

public class RotateArray {


    static public int[] answer(int[] array, int value) {


        for (int j = 0; j < value; j++) {
            int temp = 0;
            temp = array[array.length - 1];
            for (int i = array.length - 1; i >= 1; i--) {
                array[i] = array[i - 1];
            }
            array[0] = temp;
        }
        return array;
    }

    static public int[] answerOptimized(int[] array, int k) {
        int length = array.length;

        k = k % length;

        reverse(array, 0, length - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, length - 1);

        return array;

    }

    static public void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        int[] array = {-1, -100, 3, 99};

        int[] answer = answerOptimized(array, 5);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }

    }
}
