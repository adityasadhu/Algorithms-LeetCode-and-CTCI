package leetcode.arrays;

public class RemoveElement {


    static public int answer(int[] array, int value) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        return array.length - count;
    }

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};

        int answer = answer(array, 2);

        System.out.println(answer);
    }
}
