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
