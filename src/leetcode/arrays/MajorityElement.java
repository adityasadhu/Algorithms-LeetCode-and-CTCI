package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    static public int answer(int[] array) {


        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }
        }

        int globalMax = Integer.MIN_VALUE;
        int check = array.length / 2;
        int number = 0;
        for (Map.Entry<Integer, Integer> iterator : hashMap.entrySet()) {
            System.out.println(iterator.getKey() + " " + iterator.getValue());
            if (iterator.getValue() >= check) {
                if (iterator.getValue() > globalMax) {
                    globalMax = iterator.getValue();
                    number = iterator.getKey();
                }

            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 1, 2, 2, 1, 1};

        int answer = answer(array);
        System.out.println(answer);

    }
}
