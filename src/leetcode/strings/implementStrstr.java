//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


package leetcode.strings;

public class implementStrstr {


    static public int answer(String needle, String haystack) {
        int neddleLength = needle.length();
        int haystackLength = haystack.length();


        char[] a = needle.toCharArray();
        char[] b = haystack.toCharArray();

        boolean check = true;

        if (neddleLength == 0) {
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                if ((i + haystackLength <= neddleLength) && needle.substring(i, i + haystackLength).equals(haystack)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String needle = "hellolll";
        String haystack = "lll";
        int answer = answer(needle, haystack);
        System.out.println(answer);

    }
}
