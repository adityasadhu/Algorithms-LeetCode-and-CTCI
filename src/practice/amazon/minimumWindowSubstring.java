/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

        Example:

        Input: S = "ADOBECODEBANC", T = "ABC"
        Output: "BANC"
        Note:

        If there is no such window in S that covers all characters in T, return the empty string "".
        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.*/


package practice.amazon;

import java.util.HashMap;

public class minimumWindowSubstring {

    public static String answer(String s, String t) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int length = Integer.MAX_VALUE;
        int begin = 0;
        int end = 0;
        String answer = "";

        for (char c : t.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        int counter = hashMap.size();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) - 1);
                if (hashMap.get(c) == 0)
                    counter--;
            }

            end++;

            while (counter == 0) {
                if (end - begin < length) {
                    length = end - begin;
                    answer = s.substring(begin, end);
                }

                char temp = s.charAt(begin);
                if (hashMap.containsKey(temp)) {
                    hashMap.put(temp, hashMap.get(temp) + 1);
                    if (hashMap.get(temp) > 0) {
                        counter++;
                    }
                }
                begin++;
            }

        }


        return answer;
    }

    public static void main(String[] args) {

        System.out.println(answer("ADOBECODEBANC", "ABC"));

    }
}
