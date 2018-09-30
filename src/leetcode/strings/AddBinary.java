package leetcode.strings;

public class AddBinary {


    static public String answer(String a, String b) {

        int c = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || c == 1) {
            c += i >= 0 ? a.charAt(i--) - '0' : 0;
            c += j >= 0 ? b.charAt(j--) - '0' : 0;
            result.append(c % 2);
            c /= 2;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {

        String a = "11";
        String b = "11";
        String answer = answer(a, b);
        System.out.println(answer);

    }
}
