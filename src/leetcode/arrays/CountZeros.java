//move zeros to the end of the array

package leetcode.arrays;

public class CountZeros {

    static public int[] answer(int[] array) {
        int length = array.length;
        int count = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != 0) {
                array[start] = array[i];
                start++;
            }
        }
        while (start < length) {
            array[start] = 0;
            start++;
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = {1, 0, 2, 0, 7, 0, 0};
        int[] answer = answer(array);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }
    }
}
