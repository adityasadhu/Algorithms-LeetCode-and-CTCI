
//Given an array of integers nums, write a method that returns the "pivot" index of this array.
//
//We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
//
//If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

package leetcode.arrays;

public class PivotOfIndex {

    static public int answer(int[] array) {
        int length = array.length;
        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < length; i++) {
            sum += array[i];
        }

        for (int i = 0; i < length; i++) {
            if (leftSum == sum - leftSum - array[i]) {
                return i;
            }
            leftSum += array[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 7, 3, 6, 5, 6};
        int answer = answer(array);
        System.out.println(answer);
    }


}
