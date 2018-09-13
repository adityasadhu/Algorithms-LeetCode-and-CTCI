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

import java.util.HashMap;
import java.util.Map;

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


    static public boolean answerHashMap(int[] array, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i]) && hashMap.get(array[i]) + i >= k) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> ite : hashMap.entrySet()){

            System.out.println(ite.getKey()+ " " + ite.getValue());
        }

        for(Map.Entry<Integer, Integer> ite : hashMap.entrySet()){

            if(ite.getValue() > 1){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        int[] array = {1,2,3,1};
        boolean answer = answerHashMap(array, 3);
        System.out.println(answer);
    }
}
