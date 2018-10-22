package leetcode.strings;

public class stringRotation {


    public String answer(String s, int leftShift, int rightShift) {


        int length = s.length();
        leftShift = leftShift % s.length();
        rightShift = rightShift % s.length();

        if (leftShift == rightShift) {
            return s;
        }
        char[] array = s.toCharArray();


        if (leftShift > rightShift) {
            leftShift = leftShift - rightShift;
            reverse(array, 0, length - 1);
            reverse(array, 0, length - leftShift - 1);
            reverse(array, length - leftShift, length - 1);


        } else if (rightShift > leftShift) {
            rightShift = rightShift - leftShift;

            reverse(array, 0, length - 1);
            reverse(array, 0, rightShift - 1);
            reverse(array, rightShift, length - 1);
        }


        System.out.println(new String(array));
        return new String(array);
    }

    public void reverse(char[] array, int start, int end) {

        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

    }


    public static void main(String[] args) {
        stringRotation stringRotation = new stringRotation();

        stringRotation.answer("abcd", 6, 5);


    }
}
