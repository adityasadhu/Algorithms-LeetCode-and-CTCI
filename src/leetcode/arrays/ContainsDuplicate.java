//Given an array of integers, find if the array contains any duplicates.
//
//        Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
//
//        Example 1:
//
//        Input: [1,2,3,1]
//        Output: true
//        Example 2:
//
//        Input: [1,2,3,4]
//        Output: false
//        Example 3:
//
//        Input: [1,1,1,3,3,4,3,2,4,2]
//        Output: true


package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {


    static public boolean answer(int[] array) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }


            for (Map.Entry<Integer, Integer> iterator : hashMap.entrySet()) {
                if (iterator.getValue() > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3};
        boolean result = answer(array);
        System.out.println(result);
    }
}
