//Given a binary array, find the maximum number of consecutive 1s in this array.
//
//        Example 1:
//        Input: [1,1,0,1,1,1]
//        Output: 3
//        Explanation: The first two digits or the last three digits are consecutive 1s.
//        The maximum number of consecutive 1s is 3.
//        Note:
//
//        The input array will only contain 0 and 1.
//        The length of input array is a positive integer and will not exceed 10,000
package leetcode.arrays;

public class MaxConcecutiveOnes {


    static public int answer(int[] array) {

        int result = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] array = {1, 1, 0, 1, 1, 1};
        int answer = answer(array);
        System.out.println(answer);

    }
}

