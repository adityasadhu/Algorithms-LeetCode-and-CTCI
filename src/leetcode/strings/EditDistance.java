/*Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

        You have the following 3 operations permitted on a word:

        Insert a character
        Delete a character
        Replace a character
        Example 1:

        Input: word1 = "horse", word2 = "ros"
        Output: 3
        Explanation:
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')
        Example 2:

        Input: word1 = "intention", word2 = "execution"
        Output: 5
        Explanation:
        intention -> inention (remove 't')
        inention -> enention (replace 'i' with 'e')
        enention -> exention (replace 'n' with 'x')
        exention -> exection (replace 'n' with 'c')
        exection -> execution (insert 'u')*/

package leetcode.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EditDistance {


    public static int answer(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = minimum(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[length1][length2];
    }

    public static int minimum(int a, int b, int c) {

        List<Integer> list = Arrays.asList(a, b, c);
        Collections.sort(list);

        return list.get(0);

    }

    public static void main(String[] args) {

        System.out.println(answer("horse", "ros"));
    }
}
