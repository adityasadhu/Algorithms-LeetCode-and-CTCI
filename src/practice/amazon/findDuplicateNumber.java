package practice.amazon;

import java.util.Arrays;

public class findDuplicateNumber {

    public static int answer(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(answer(new int[]{1, 3, 4, 2, 2}));
    }
}
