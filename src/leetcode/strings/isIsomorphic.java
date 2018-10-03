//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//        Example 1:
//
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//
//        Input: s = "paper", t = "title"
//        Output: true
//        Note:
//        You may assume both s and t have the same length.

package leetcode.strings;

import java.util.HashMap;

public class isIsomorphic {

    static public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == s.charAt(i)) continue;
                else return false;
            } else if (map.containsValue(s.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;


    }


    public static void main(String[] args) {

        boolean result = isIsomorphic("foo", "bar");
        System.out.println(result);

    }

}
