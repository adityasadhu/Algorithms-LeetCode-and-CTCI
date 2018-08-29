//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//        Note:
//
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//        Example 1:
//
//        Input: [2,2,1]
//        Output: 1
//        Example 2:
//
//        Input: [4,1,2,1,2]
//        Output: 4


package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    //with extra memory
    static public int answer(int[] array) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.remove(array[i]);
            } else {
                hashMap.put(array[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> iterator : hashMap.entrySet()) {
            return iterator.getKey();
        }
        return -1;
    }
    //without extra memory


    static public int answer2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[0] ^= array[i];
        }

        return array[0];
    }


    public static void main(String[] args) {

        int[] array = {4, 1, 2, 1, 2};

        int answer = answer2(array);

        System.out.println(answer);
    }
}
