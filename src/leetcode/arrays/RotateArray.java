package leetcode.arrays;

public class RotateArray {


    static public int[] answer(int[] array, int value) {


        for (int j = 0; j < value; j++) {
            int temp = 0;
            temp = array[array.length - 1];
            for (int i = array.length - 1; i >= 1; i--) {
                array[i] = array[i - 1];
            }
            array[0] = temp;
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = {-1,-100,3,99};

        int[] answer = answer(array, 2);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }

    }
}
