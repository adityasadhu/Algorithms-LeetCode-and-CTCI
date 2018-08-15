package leetcode.arrays;

import java.util.HashMap;

public class Twosum {

    static public int[] answer (int[] array, int target){

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if(hashMap.containsKey(complement)){
                return new int[] {i, hashMap.get(complement)};
            }

        }
        return null;
    }
    public static void main(String[] args) {

        int []array = {2, 7, 11, 15};
        int target = 9;
        int[] answer = answer(array, target);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }
    }
}
