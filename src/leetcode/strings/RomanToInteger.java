package leetcode.strings;

import java.util.HashMap;

public class RomanToInteger {

    static public int answer(String s){


        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int len = s.length(), result = hashMap.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (hashMap.get(s.charAt(i)) >= hashMap.get(s.charAt(i + 1)))
                result += hashMap.get(s.charAt(i));
            else
                result -= hashMap.get(s.charAt(i));
        }
        return result;

    }
    public static void main(String[] args) {


        String result = "VI";
        int answer = answer(result);
        System.out.println(answer);
    }
}
