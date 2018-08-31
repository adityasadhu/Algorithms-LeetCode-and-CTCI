//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//
//        Example 1:
//
//        Input: nums = [1,2,3,1], k = 3
//        Output: true
//        Example 2:
//
//        Input: nums = [1,0,1,1], k = 1
//        Output: true
//        Example 3:
//
//        Input: nums = [1,2,3,1,2,3], k = 2
//        Output: false

package leetcode.arrays;

public class ContainsDuplicate2 {


    static public boolean answer(int[] array, int k) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] array = {1, 0, 1, 1};
        boolean answer = answer(array, 1);
        System.out.println(answer);
    }
}
