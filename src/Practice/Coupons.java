package Practice;

import java.util.HashMap;

public class Coupons {
    
    static public int answer(int[] coupons) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int begin = 0;
        int end = 0;
        int counter = 0;
        int minLength = Integer.MAX_VALUE;

        int size = coupons.length;
        while (end < size) {

            hashMap.put(coupons[end], hashMap.getOrDefault(coupons[end], 0) + 1);
            if (hashMap.get(coupons[end]) == 2) {
                counter++;
            }
            end++;

            while (counter > 0) {
                if (hashMap.get(coupons[begin]) != 2) {
                    hashMap.remove(coupons[begin]);
                    begin++;
                } else {
                    minLength = Math.min(minLength, end - begin);
                    counter--;
                }
            }
        }
        return minLength;
    }

    public static void main(String[] args) {

        System.out.println(answer(new int[]{5, 3, 4, 2, 3, 4, 5, 7}));

    }
}
