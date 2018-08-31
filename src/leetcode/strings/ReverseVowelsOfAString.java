package leetcode.strings;

public class ReverseVowelsOfAString {


    static public String answer(String string) {

        char[] str = string.toCharArray();

        StringBuilder vowels = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
                vowels.append(str[i]);
            }
        }
        int z = vowels.length() - 1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
                str[i] = vowels.charAt(z);
                z--;
            }
        }
        String result = new String(str);
        return result;
    }

    public static void main(String[] args) {

        String str = "hello";
        String answer = answer(str);
        System.out.println(answer);

    }
}
