package practice.amazon;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class firstUniqueCharacterInAString {


    public static int answer(String s) {

        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                List<Character> result = s.chars()
                        .mapToObj(e -> (char) e).collect(Collectors.toList());
                return result.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(answer("loveleetcode"));

    }
}
