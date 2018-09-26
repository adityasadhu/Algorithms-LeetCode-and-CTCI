//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//        Example:
//
//        Input: S = "ADOBECODEBANC", T = "ABC"
//        Output: "BANC"
//        Note:
//
//        If there is no such window in S that covers all characters in T, return the empty string "".
//        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


package leetcode.slidingwindowproblems;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    static public String answer(String s, String t) {

        //we return null string if the t's length is more than s's length because s should contain all the characters
        //that are there in t
        if (t.length() > s.length())
            return "";

        //hashmap to maintain count of characters in string t
        Map<Character, Integer> map = new HashMap<>();

        //populating hashmap
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //maintaining a counter to keep track of distinct elements in string t which when becomes zero
        //indicates that we have reached the answer state.
        int counter = map.size();

        int begin = 0, end = 0;
        int resultHead = 0;
        int len = Integer.MAX_VALUE;

        //sliding window concept start
        while (end < s.length()) {
            char c = s.charAt(end);

            //if we encounter a character in string s that is there in string t we reduce the count in the
            //map we have been using to keep track of the counts
            // we decrement counter after we have come across all the instances of characters present in string t
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }

            end++;

            // when counter is 0 we have reached the answer state and now we need to check if we can remove characters
            // beginning.
            // character at the beginning may or may not be in the map. if it is not there we can simply remove but
            // if it is there then we add it to the map and increment the counter.
            while (counter == 0) {

                if (end - begin < len) {
                    len = end - begin;
                    resultHead = begin;
                }

                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }

                begin++;
            }

        }
        if (len == Integer.MAX_VALUE) return "";
        return s.substring(resultHead, resultHead + len);
    }

    public static void main(String[] args) {

        String answer = answer("ADOBECODEBANC", "ABC");

        System.out.println(answer);
    }

}
