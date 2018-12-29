package practice.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class twoSum {

    public static int[] answer(int[] array, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{i, hashMap.get(complement)};
            } else {
                hashMap.put(array[i], i);
            }
        }
        return null;
    }


    // if the input is sorted
    public static int[] sortedArrayAnswer(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            int j = Arrays.binarySearch(array, complement);
            if (j >= 0) {
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(sortedArrayAnswer(new int[]{2, 7, 11, 15}, 9)).boxed().collect(Collectors.toList()));
    }
}

