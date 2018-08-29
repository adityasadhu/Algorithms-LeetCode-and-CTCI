package leetcode.strings;

public class ValidAnagram {


    static public boolean answer(String s, String r) {


        if (s.length() != r.length())
            return false;
        int[] visitedS = new int[26];
        int[] visitedR = new int[26];

        for (int i = 0; i < s.length(); i++) {
            visitedR[r.charAt(i) - 'a']++;
            visitedS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < visitedR.length; i++) {
            if (visitedR[i] != visitedS[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean answer = answer("rat", "car");
        System.out.println(answer);
    }
}
