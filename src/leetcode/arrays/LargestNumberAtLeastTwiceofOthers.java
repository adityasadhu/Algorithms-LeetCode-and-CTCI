//In a given integer array nums, there is always exactly one largest element.
//
//        Find whether the largest element in the array is at least twice as much as every other number in the array.
//
//        If it is, return the index of the largest element, otherwise return -1.
//
//        Example 1:
//
//        Input: nums = [3, 6, 1, 0]
//        Output: 1
//        Explanation: 6 is the largest integer, and for every other number in the array x,
//        6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
//
//
//        Example 2:
//
//        Input: nums = [1, 2, 3, 4]
//        Output: -1
//        Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


package leetcode.arrays;

public class LargestNumberAtLeastTwiceofOthers {


    static public int answer(int[] array) {

        int max = -1, index = -1, secondMax = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
                index = i;
            } else if (array[i] > secondMax) {
                secondMax = array[i];
            }

        }

        return secondMax * 2 <= max ? index : -1;

    }


    public static void main(String[] args) {

        int[] array = {3, 6, 1, 0};

        int answer = answer(array);
        System.out.println(answer);

    }
}
