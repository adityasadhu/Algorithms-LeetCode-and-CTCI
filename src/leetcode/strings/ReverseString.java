package leetcode.strings;

public class ReverseString {


    static public String answer(String str) {

        char[] result = str.toCharArray();

        int length = result.length;

        int start = 0;
        int end = length - 1;

        char temp = '\0';
        while (start <= end) {
            temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;

        }
        String resultString = new String(result);
        return resultString;
    }

    public static void main(String[] args) {


        String result = answer("A man, a plan, a canal: Panama");
        System.out.println(result);

    }
}
