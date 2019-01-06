/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.
        Example 1:

        Input: s = "leetcode", wordDict = ["leet", "code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
        Example 2:

        Input: s = "applepenapple", wordDict = ["apple", "pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        Output: false
*/


package practice.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    public static boolean answer(String s, List<String> wordDict) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            String check = queue.poll();

            if (wordDict.contains(check))
                return true;

            int length = check.length();
            for (int i = 0; i < length; i++) {
                String first = check.substring(0, i);
                String last = check.substring(i);
                if (!visited.contains(last) && wordDict.contains(first)) {
                    queue.add(last);
                    visited.add(last);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(answer("applepenapple", Arrays.stream(new String[]{"apple", "pen"}).collect(Collectors.toList())));
    }
}
