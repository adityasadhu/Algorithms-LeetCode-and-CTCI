package leetcode.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfMoves {


    public static int minimumMoves(List<Integer> a, List<Integer> b) {

        int[] number1 = a.stream().mapToInt(Integer::intValue).toArray();
        int[] number2 = b.stream().mapToInt(Integer::intValue).toArray();


        int size1 = number1.length;
        int size2 = number2.length;

        int answer = 0;

        if (size1 != size2)
            return 0;

        for (int i = 0; i < number2.length; i++) {

            String s1 = Integer.toString(number1[i]);
            String s2 = Integer.toString(number2[i]);

            for (int j = 0; j < s1.length(); j++) {
                answer += Math.abs(Character.getNumericValue(s1.charAt(j)) - Character.getNumericValue(s2.charAt(j)));
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(minimumMoves(Arrays.stream(new int[]{1234, 4321}).boxed().collect(Collectors.toList()), Arrays.stream(new int[]{2345, 3214}).boxed().collect(Collectors.toList())));

    }
}
