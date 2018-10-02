package leetcode.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PerfectTeam {


    static int teams(String s) {

        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();


        for (Character c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        if (s.contains("p") && s.contains("c") && s.contains("m") && s.contains("b") && s.contains("z")) {
            answer = Collections.min(hashMap.values());
        }


        return answer;
    }


    public static void main(String[] args) {


        int answer = teams("pcmpbzp");
        System.out.println(answer);
    }
}
