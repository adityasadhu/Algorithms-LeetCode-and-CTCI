//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//        Example 1:
//
//        Input: num1 = "2", num2 = "3"
//        Output: "6"
//        Example 2:
//
//        Input: num1 = "123", num2 = "456"
//        Output: "56088"
//        Note:
//
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contain only digits 0-9.
//        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.


package leetcode.strings;

public class MultiplyStrings {

    static public String multiply(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] products = new int[n1 + n2];


        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = s1.charAt(i) - '0';
                int d2 = s2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }


        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int temp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < products.length; j++) {
            stringBuilder.append(products[j]);
        }

        if (stringBuilder.length() != 0 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }


    static public String answer2(String s1, String s2) {

        int length1 = s1.length();
        int length2 = s2.length();
        int[] pos = new int[length1 + length1];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (s1.charAt(i) - '0') * (s2.charAt(i) - '0');
                int sum = mul + pos[p2];
                pos[p1] = +sum / 10;
                pos[p2] = sum % 10;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            sb.append(pos[i]);
        }
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s1 = "11";
        String s2 = "11";
        String result = answer2(s1, s2);
        System.out.println(result);
    }
}
