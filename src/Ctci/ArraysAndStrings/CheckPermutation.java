package Ctci.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {


    static public boolean answer(String str1, String str2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (hashMap.containsKey(str1.charAt(i))) {
                hashMap.put(str1.charAt(i), hashMap.get(str1.charAt(i)) + 1);
            } else {
                hashMap.put(str1.charAt(i), 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (hashMap.containsKey(str2.charAt(i)) && hashMap.get(str2.charAt(i)) > 1) {
                hashMap.put((str2.charAt(i)), hashMap.get(str2.charAt(i)) - 1);
            } else if (hashMap.containsKey(str2.charAt(i)) && hashMap.get(str2.charAt(i)) == 1) {
                hashMap.remove(str2.charAt(i));
            } else {
                hashMap.put(str2.charAt(i), 1);
            }
        }

//        for (Map.Entry<Character, Integer> iterator : hashMap.entrySet()) {
//            System.out.println(iterator.getKey() + " " + iterator.getValue());
//        }
        if (hashMap.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String str1 = "abca";
        String str2 = "baca";
        boolean answer = answer(str1, str2);
        System.out.println(answer);


    }
}
