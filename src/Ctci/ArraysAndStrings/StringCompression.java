package Ctci.ArraysAndStrings;

public class StringCompression {


    static public String answer(String str) {

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }

    public static void main(String[] args) {

        String s = "aabccaaaa";
        String answer = answer(s);
        System.out.println(answer);
    }
}
