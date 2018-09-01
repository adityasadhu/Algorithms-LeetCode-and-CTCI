package Ctci.ArraysAndStrings;

public class oneAway {


    static public boolean answer(String s1, String s2) {
        boolean result = false;
        if (s1.length() == s2.length()) {
            result = checkReplacememt(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            result = checkInsert(s1, s2);
        } else if (s1.length() == s2.length() + 1) {
            result = checkInsert(s2, s1);
        } else {
            return false;
        }

        return result;
    }

    private static boolean checkReplacememt(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }

    public static boolean checkInsert(String first, String second) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (index1 != index2) {
                    return false;

                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "pale";
        String s2 = "bale";
        boolean answer = answer(s1, s2);
        System.out.println(answer);

    }
}
