package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    static public List<List<Integer>> answer(int[] array) {

        ArrayList<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            if (i != 0 && array[i] == array[i - 1]) continue;
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {

                int sum = array[i] + array[j] + array[k];

                if (sum == 0) {

                    List<Integer> innerAnswer = new ArrayList<>();
                    innerAnswer.add(array[i]);
                    innerAnswer.add(array[j]);
                    innerAnswer.add(array[k]);
                    if (!answer.contains(innerAnswer)) {
                        answer.add(innerAnswer);
                    }
                    j++;
                    while (j < k && array[j] == array[j - 1]) j++;
                    while (j < k && array[k] == array[k - 1]) k--;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        int[] array = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> answer;
        answer = answer(array);
        System.out.println(answer);
    }
}
