package practice.amazon;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {

    public static int answer(String s) {
        int length = s.length();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        int begin = 0;
        int end = 0;
        int counter = 0;
        int answer = 0;

        while (end < length) {
            char c = s.charAt(end);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            if (hashMap.get(c) > 1) {
                counter++;
            }
            end++;

            while (counter > 0) {
                char startToRemoveFromBeggining = s.charAt(begin);
                if (hashMap.get(startToRemoveFromBeggining) > 1) counter--;
                hashMap.put(startToRemoveFromBeggining, hashMap.get(startToRemoveFromBeggining) - 1);
                begin++;
            }
            answer = Math.max(answer, end - begin);
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(answer("pwwkew"));
    }
}
