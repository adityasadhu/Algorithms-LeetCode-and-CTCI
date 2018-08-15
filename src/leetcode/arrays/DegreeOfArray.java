package leetcode.arrays;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {


    static public void answer(int[] array) {

        int length = array.length;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (left.get(array[i]) == null) {
                left.put(array[i], i);
                count.put(array[i], 1);
            } else {
                right.put(array[i], i);
                count.put(array[i], count.get(array[i]) + 1);
            }
        }

        int answer = array.length;
        int degree = Collections.max(count.values());

        for (Map.Entry<Integer, Integer> iterator : right.entrySet()) {
            System.out.println(iterator.getKey() + " " + iterator.getValue());
        }

        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                answer = Math.min(answer, right.get(x) - left.get(x) + 1);
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1, 3, 4};
        answer(array);
    }
}
