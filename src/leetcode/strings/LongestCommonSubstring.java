//Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
//        Examples :
//
//        Input : X = "GeeksforGeeks", y = "GeeksQuiz"
//        Output : 5
//        The longest common substring is "Geeks" and is of
//        length 5.
//
//        Input : X = "abcdxyz", y = "xyzabcd"
//        Output : 4
//        The longest common substring is "abcd" and is of
//        length 4.
//
//        Input : X = "zxabcdezy", y = "yzabcdezx"
//        Output : 6
//        The longest common substring is "abcdez" and is of
//        length 6.


package leetcode.strings;

public class LongestCommonSubstring {


    static public int answer(String str1, String str2) {

        StringBuilder result = new StringBuilder();

        int indexS1 = 0;
        int indexS2 = 0;

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 2];

        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == maxLength) {
                    indexS1 = i;
                    indexS2 = j;
                    break;
                }
            }
        }

        while (dp[indexS1][indexS2] != 0) {
            result.append(s1[indexS1 - 1]);
            indexS1--;
            indexS2--;
        }

        result.reverse();
        //System.out.println(result);

        return maxLength;
    }


    static public int answerArray(int[] array1, int array2[]) {

        int[][] dp = new int[array1.length + 1][array2.length + 1];
        int maxLength = Integer.MIN_VALUE;

        for (int i = 1; i <= array1.length; i++) {
            for (int j = 1; j <= array1.length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {


        String s1 = "dude";
        String s2 = "wassupdude";

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 1, 2};

        int answer1 = answerArray(array1, array2);

        //int answer = answer(s1, s2);
        System.out.println(answer1);

    }


}
