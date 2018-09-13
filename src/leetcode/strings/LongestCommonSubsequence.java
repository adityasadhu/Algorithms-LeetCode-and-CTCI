package leetcode.strings;

public class LongestCommonSubsequence {


    static public int answer(char[] str1, char[] str2) {
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {

        char[] s1 = "ABCD".toCharArray();
        char[] s2 = "AVBJCOD".toCharArray();
        int answer = answer(s1, s2);

        System.out.println(answer);


    }
}
