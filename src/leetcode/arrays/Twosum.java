//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
//

package leetcode.arrays;

import java.util.HashMap;

public class Twosum {

    static public int[] answer(int[] array, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{i, hashMap.get(complement)};
            }

        }
        return null;
    }

    public static void main(String[] args) {

        int[] array = {6, 12, 3, 9, 3, 5, 1};
        int target = 12;
        int[] answer = answer(array, target);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }
    }
}
