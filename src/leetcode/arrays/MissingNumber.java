package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {


    static public int answer(int[] array) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = {3, 0, 1};
        int answer = answer(array);
        System.out.println(answer);
    }
}
