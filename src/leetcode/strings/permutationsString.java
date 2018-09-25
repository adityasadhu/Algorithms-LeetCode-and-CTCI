package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class permutationsString {


    static List<String> anagrams(String prefix, String word, List<String> returnVal) {
        if (word.length() == 2) {
            returnVal.add(prefix + word.charAt(1) + word.charAt(0));
            returnVal.add(prefix + word.charAt(0) + word.charAt(1));
            return returnVal;
        }
        for (int i = 0; i < word.length(); i++) {
            anagrams(prefix + word.substring(i, i + 1), new StringBuilder(word).deleteCharAt(i).toString(), returnVal);

        }
        return returnVal;
    }


    public static void main(String[] args) {
        System.out.println(anagrams("", "ten", new ArrayList<>()));
    }
}
