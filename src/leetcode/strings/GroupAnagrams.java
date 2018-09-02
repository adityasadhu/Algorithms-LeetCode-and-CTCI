//Given an array of strings, group anagrams together.
//
//        Example:
//
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//
//        All inputs will be in lowercase.
//        The order of your output does not matter.


package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    static public List<List<String>> answer(String[] str) {


        if (str.length == 0 || str == null) {
            return null;
        }

        HashMap<String, List> hashMap = new HashMap<>();

        for (String s : str) {

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList());
            }
            hashMap.get(key).add(s);
        }

        return new ArrayList(hashMap.values());

    }

    public static void main(String[] args) {

        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> answer = answer(str);

        for (List i : answer) {
            System.out.println(i);
        }

    }
}
