package leetcode.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    static public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;


//        for(Map.Entry<Character, Integer> iterator : map.entrySet()){
//            System.out.println(iterator.getKey()+" " + iterator.getValue());
//        }
//        System.out.println();

        while (end < s.length()) {
            char c = s.charAt(end);
            System.out.println(c);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            System.out.println("outer while map");
            for (Map.Entry<Character, Integer> iterator : map.entrySet()) {

                System.out.println(iterator.getKey() + " " + iterator.getValue());
            }
            System.out.println("counter is" + counter);
            System.out.println();


            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    System.out.println("result found" + begin);
                    result.add(begin);
                }
                begin++;
                System.out.println("inner while map");
                for (Map.Entry<Character, Integer> iterator : map.entrySet()) {

                    System.out.println(iterator.getKey() + " " + iterator.getValue());
                }
                System.out.println("counter is" + counter);
                System.out.println();
            }

        }
        return result;
    }


    public static void main(String[] args) {


        String s1 = "abcbababc";
        String s2 = "abc";

        List<Integer> answer = findAnagrams(s1, s2);
        System.out.println(answer);

    }
}
