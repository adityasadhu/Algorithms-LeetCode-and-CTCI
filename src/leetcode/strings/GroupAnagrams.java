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


    //by keeping track in a kashmap with the sorted string to list of strings
    //time complexity O(MNLogN) N= length of string and M is length of the list and LogN for sorting

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


    //better solution by keeping track of count instead of sorting and saving logN time

    static public List<List<String>> answer2(String[] str) {

        HashMap<String, List> hashMap = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < str.length; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < str[i].length(); j++) {
                count[str[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count.length; j++) {
                sb.append("$");
                sb.append(count[j]);
            }
            if (!hashMap.containsKey(sb.toString()))
                hashMap.put(sb.toString(), new ArrayList());
            hashMap.get(sb.toString()).add(str[i]);

        }
        return new ArrayList(hashMap.values());

    }

    public static void main(String[] args) {

        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> answer = answer2(str);

        for (List i : answer) {
            System.out.println(i);
        }

    }
}
