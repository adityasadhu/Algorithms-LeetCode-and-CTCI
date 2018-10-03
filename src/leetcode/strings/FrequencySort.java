//Given a string, sort it in decreasing order based on the frequency of characters.
//
//        Example 1:
//
//        Input:
//        "tree"
//
//        Output:
//        "eert"
//
//        Explanation:
//        'e' appears twice while 'r' and 't' both appear once.
//        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//        Example 2:
//
//        Input:
//        "cccaaa"
//
//        Output:
//        "cccaaa"
//
//        Explanation:
//        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//        Note that "cacaca" is incorrect, as the same characters must be together.
//        Example 3:
//
//        Input:
//        "Aabb"
//
//        Output:
//        "bbAa"
//
//        Explanation:
//        "bbaA" is also a valid answer, but "Aabb" is incorrect.
//        Note that 'A' and 'a' are treated as two different characters.

package leetcode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    static public String frequencySort(String s) {

        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            queue.add(entry);
        }


        while (queue.size() != 0) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int size = entry.getValue();

            for (int i = 0; i < size; i++) {
                result.append(entry.getKey());
            }

        }

        System.out.println(result);

        return result.toString();

    }


    public static void main(String[] args) {

        frequencySort("abbc");

    }
}
