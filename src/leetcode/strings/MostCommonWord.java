//Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
//        Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

//Example:
//        Input:
//        paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//        banned = ["hit"]
//        Output: "ball"
//        Explanation:
//        "hit" occurs 3 times, but it is a banned word.
//        "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
//        Note that words in the paragraph are not case sensitive,
//        that punctuation is ignored (even if adjacent to words, such as "ball,"),
//        and that "hit" isn't the answer even though it occurs more because it is banned.
//
//
//        Note:
//
//        1 <= paragraph.length <= 1000.
//        1 <= banned.length <= 100.
//        1 <= banned[i].length <= 10.
//        The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
//        paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
//        Different words in paragraph are always separated by a space.
//        There are no hyphens or hyphenated words.
//        Words only consist of letters, never apostrophes or other punctuation symbols.
package leetcode.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord {

    static public String answer(String paragraph, String[] banned) {

        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (String s : banned) {
            if (!hashSet.contains(s))
                hashSet.add(s);
        }

        String[] para = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String s : para) {
            if (!hashSet.contains(s))
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        int answer = Collections.max(hashMap.values());

        for (Map.Entry<String, Integer> ite : hashMap.entrySet()) {
            if (ite.getValue() == answer) {
                result.append(ite.getKey());
            }
//            System.out.println(ite.getKey() + " " + ite.getValue());
        }

        return result.toString();

    }


    public static void main(String[] args) {

        String[] banned = {"hit"};
        String answer = answer("Bob hit a ball, the hit BALL flew far after it was hit.", banned);
        System.out.println(answer);


    }
}
