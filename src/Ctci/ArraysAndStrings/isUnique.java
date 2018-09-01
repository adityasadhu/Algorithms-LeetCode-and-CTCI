package Ctci.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class isUnique {

//    static final int MAX_CHARS = 256;
//    public boolean isStringUnique(String str){
//        boolean[] isVisited = new boolean[MAX_CHARS];
//        Arrays.fill(isVisited, false);
//        int length = str.length();
//
//        for (int i = 0; i < length; i++) {
//            if(isVisited[str.charAt(i)] == true){
//                return false;
//            }
//            isVisited[str.charAt(i)] = true;
//        }
//        return true;
//    }

    // using hashmap
    static public boolean answer(String str) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> check : hashMap.entrySet()) {
            if (check.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        isUnique isUnique = new isUnique();
        boolean result = isUnique.answer("abac");
        System.out.println(result);
    }
}
