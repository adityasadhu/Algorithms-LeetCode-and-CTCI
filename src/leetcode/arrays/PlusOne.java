package leetcode.arrays;

public class PlusOne {

    static public int[] answer(int[] array) {

        int carry = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 9) {
                array[i] = 0;
                carry = 1;
            } else {
                array[i] += 1;
                carry = 0;
                return array;
            }
        }

        if (carry != 0) {
            int[] temp = new int[array.length + 1];
            temp[0] = 1;
            for (int j = 1; j < temp.length; j++) {
                temp[j] = array[j - 1];
            }
            return temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, 9, 9};
        int[] answer = answer(array);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }


    }
}
