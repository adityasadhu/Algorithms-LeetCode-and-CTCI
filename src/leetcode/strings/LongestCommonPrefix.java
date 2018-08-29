//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//
//        Input: ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//        Note:
//
//        All given inputs are in lowercase letters a-z.

package leetcode.strings;

public class LongestCommonPrefix {


    static public String answer(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;
    }

    static public String commonPrefixUtil(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();

        for (int i = 0, j = 0; i < length1 && j < length2; i++, j++) {
            if(c1[i]!=c2[j]){
                break;
            }
            result = result.append(c1[i]);
        }
        return result.toString();
    }


    static public String commonPrefix(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefixUtil(prefix, strs[i]);
        }
        return prefix;
    }

    public static void main(String[] args) {

        String[] strs = {"fliower", "fliow", "flight", "fli"};
        String answer = commonPrefix(strs);
        System.out.println(answer);
    }
}
