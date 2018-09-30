package leetcode.slidingwindowproblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {


    static public int answer(String s) {

        int start = 0;
        int end = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int i : map.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }


    public static void main(String[] args) {


        int answer = answer("eceba");

        System.out.println(answer);

    }
}
