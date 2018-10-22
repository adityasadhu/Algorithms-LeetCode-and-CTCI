package leetcode.arrays;

public class maxDifference {


    static public int answer(int[] array) {
        int length = array.length;

        int maxDifference = array[1] - array[0];

        int minElement = array[0];

        for (int i = 1; i < length; i++) {
            if (array[i] - minElement > maxDifference) {
                maxDifference = array[i] - minElement;
            }
            if (array[i] < minElement) {
                minElement = array[i];
            }

        }
        System.out.println(maxDifference);
        return maxDifference;
    }

    static int bruteForce(int[] array) {
        int length = array.length;

        int maxDifference = -1;
        int difference = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                difference = array[j] - array[i];
                maxDifference = Math.max(difference, maxDifference);
            }


        }

        System.out.println(maxDifference);
        return maxDifference;
    }

    static int maxDifference(int[] a) {
        int minimum, diff = -1;
        if (a.length == 0) {
            return -1;
        }
        minimum = a[0];
        for (int i = 1; i < a.length; i++) {
            diff = Math.max(diff, a[i] - minimum);
            minimum = Math.min(minimum, a[i]);
        }
        System.out.println(diff);
        return diff;
    }


    public static void main(String[] args) {

        bruteForce(new int[]{2, 3, 10, 2, 4, 8, 1});

    }
}
