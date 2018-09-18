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

    static public int answer2(int[] array, int value) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != value) {
                array[i] = array[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};

        int answer = answer2(array, 2);

        System.out.println(answer);
    }
}
