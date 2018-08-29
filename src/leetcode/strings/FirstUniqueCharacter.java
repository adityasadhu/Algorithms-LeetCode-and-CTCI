//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//        Examples:
//
//        s = "leetcode"
//        return 0.
//
//        s = "loveleetcode",
//        return 2.
//        Note: You may assume the string contain only lowercase letters.

package leetcode.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    static public int answer(String str) {
        int length = str.length();
        int index = -1;

//with using hashmap


        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        for (int i = 0; i < length; i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                int count = hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i), count + 1);
            } else {
                hashMap.put((str.charAt(i)), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                char a = entry.getKey();
                index = str.indexOf(a);
                return index;
            }
        }

//  without using hashmap

//        int[] visited = new int [26];
//
//        for (int i = 0; i < length; i++) {
//            visited[str.charAt(i) -'a']++;
//        }
//        String a = null;
//        for (int i = 0; i < visited.length; i++) {
//            if(visited[i] == 1){
//                 a = Character.toString((char) (i +'a'));
//                 break;
//            }
//        }
//        char[] s= a.toCharArray();
//        return str.indexOf(s[0]);

        return index;
    }

    public static void main(String[] args) {
        int answer = answer("aabbc");
        System.out.println(answer);

    }
}
