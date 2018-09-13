package leetcode.arrays;

public class ProductOfArrayExceptSelf {


    static public int[] answer(int[] array) {


        int result[] = new int[array.length];
        for (int i = 0, temp = 1; i < array.length; i++) {
            result[i] = temp;
            temp *= array[i];
        }
        for (int i = array.length - 1, temp = 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= array[i];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4};
        int[] answer = answer(array);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }
    }
}
