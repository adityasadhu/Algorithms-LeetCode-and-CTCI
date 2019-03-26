package Leetcode.Arrays;

public class ConsecutiveSum {


    static int countConsecutive(int num) {

        int count = 0;
        for (int i = 1; i * (i + 1) < 2 * num; i++) {
            float a = (float) ((1.0 * num - (i * (i + 1)) / 2) / (i + 1));
            if (a - (int) a == 0.0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {


        int answer = countConsecutive(15);
        System.out.println(answer);

    }
}
