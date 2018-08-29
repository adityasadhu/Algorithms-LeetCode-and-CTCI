//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//        Example 2:
//
//        Input: "race a car"
//        Output: false


package leetcode.strings;

public class ValidPallindrome {

    static public boolean answer(String s) {

        if (s.length() == 0) {
            return true;
        }
        char[] result = s.replaceAll("[^\\w]", "").toLowerCase().toCharArray();
        int length = s.length();

        int start = 0;
        int end = result.length - 1;

        while (start <= end) {
            if (result[start] != result[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        boolean result = answer(s);
        System.out.println(result);
    }
}
