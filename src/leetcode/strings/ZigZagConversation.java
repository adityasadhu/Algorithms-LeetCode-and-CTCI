//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        And then read line by line: "PAHNAPLSIIGYIR"
//
//        Write the code that will take a string and make this conversion given a number of rows:
//
//        string convert(string s, int numRows);
//        Example 1:
//
//        Input: s = "PAYPALISHIRING", numRows = 3
//        Output: "PAHNAPLSIIGYIR"
//        Example 2:
//
//        Input: s = "PAYPALISHIRING", numRows = 4
//        Output: "PINALSIGYAHRPI"
//        Explanation:
//
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I

package leetcode.strings;

public class ZigZagConversation {


    static public String answer(String str, int rows) {

        int length = str.length();
        char[] string = str.toCharArray();
        StringBuilder[] result = new StringBuilder[rows];
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }
        int i = 0;
        while (i < length) {
            for (int j = 0; j < rows && i < length; j++) {
                result[j].append(string[i++]);
            }
            for (int k = rows - 2; k >= 1 && i < length; k--) {
                result[k].append(string[i++]);
            }
        }

        for (int j = 1; j < result.length; j++) {
            result[0].append(result[j]);
        }

        return result[0].toString();

    }

    public static void main(String[] args) {

        String str = "PAYPALISHIRING";
        String result = answer(str, 3);
        System.out.println(result);

    }
}
