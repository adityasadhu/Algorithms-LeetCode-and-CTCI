//Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", which the length is 3.
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


package leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {


    //brute force
    //iterate over all the substrings and check if that substring is unique and update global maximum length of substring everytime.
    static public int answer(String str) {
        int length = str.length();
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isUnique(str, i, j)) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }

    static public boolean isUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int k = start; k <= end; k++) {
            char temp = s.charAt(k);
            if (set.contains(temp)) {
                return false;
            } else {
                set.add(temp);
            }
        }
        return true;
    }


    static public int answerOptimized(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }


    public static void main(String[] args) {

        String s = "acbbbbb";
        int answer = answerOptimized(s);
        System.out.println(answer);

    }
}
