package practice.amazon;

import java.util.HashMap;

public class minimumWindowSubstring {


    static public String answer(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int counter = 0;

        for (char a : t.toCharArray()) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }

        counter = hashMap.size();
        int begin = 0;
        int end = 0;
        int length = s.length();
        int resultHead = 0;
        int answer = Integer.MAX_VALUE;

        while (end < length) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) - 1);
                if(hashMap.get(c) == 0)
                    counter--;
            }
            end++;
            while (counter == 0) {
                if (end - begin < answer) {
                    answer = end - begin;
                    resultHead = begin;
                }
                char k = s.charAt(begin);
                if (hashMap.containsKey(k)) {
                    hashMap.put(k, hashMap.get(k) + 1);
                    if (hashMap.get(k) > 0) {
                        counter++;
                    }
                }
                begin++;
            }
        }

        return s.substring(resultHead, resultHead + answer);
    }

    public static void main(String[] args) {

        System.out.println(answer("ADOBECODEBANC", "ABC"));


    }
}
