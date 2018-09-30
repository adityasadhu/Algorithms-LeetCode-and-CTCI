//Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
//        Each letter in the magazine string can only be used once in your ransom note.
//
//        Note:
//        You may assume that both strings contain only lowercase letters.
//
//        canConstruct("a", "b") -> false
//        canConstruct("aa", "ab") -> false
//        canConstruct("aa", "aab") -> true

package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {


    static public boolean answer(String ransomNote, String magazine) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (Character c : magazine.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : ransomNote.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                return false;
            } else {
                hashMap.put(c, hashMap.get(c) - 1);
            }
        }

        for (Map.Entry<Character, Integer> iterator : hashMap.entrySet()) {
            if (iterator.getValue() < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        boolean answer = answer("aa", "ab");
        System.out.println(answer);

    }
}
