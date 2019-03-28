//There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
//
//        Example 1:
//
//        Input:
//        [
//        "wrt",
//        "wrf",
//        "er",
//        "ett",
//        "rftt"
//        ]
//
//        Output: "wertf"
//        Example 2:
//
//        Input:
//        [
//        "z",
//        "x"
//        ]
//
//        Output: "zx"
//        Example 3:
//
//        Input:
//        [
//        "z",
//        "x",
//        "z"
//        ]
//
//        Output: ""
//
//        Explanation: The order is invalid, so return "".
//        Note:
//
//        You may assume all letters are in lowercase.
//        You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
//        If the order is invalid, return an empty string.
//        There may be multiple valid order of letters, return any one of them is fine.

package Leetcode.TopologicalSort;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {

        System.out.println(alienOrder(new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));

    }

    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> adjacecncyList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String next = words[i + 1];

            int length = Math.min(first.length(), next.length());

            for (int j = 0; j < length; j++) {

                char c1 = first.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (adjacecncyList.containsKey(c1))
                        set = adjacecncyList.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        adjacecncyList.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        indegree.keySet().stream().filter(c -> indegree.get(c) == 0).forEach(c -> queue.offer(c));


        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            if (adjacecncyList.containsKey(c)) {
                adjacecncyList.get(c).forEach(v -> {
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        queue.offer(v);
                    }
                });
            }
        }
        if (result.length() != indegree.size())
            return "";

        return result.toString();
    }
}
