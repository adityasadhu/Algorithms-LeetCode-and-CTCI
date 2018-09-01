//Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Note that you cannot sell a stock before you buy one.

package leetcode.arrays;

import java.util.Map;

public class BestTimeToBuySellStock {

    static public int answer (int[] array){
        int length = array.length;
        int globalProfit = 0;
        for (int i = 0; i < length -1; i++) {
            for (int j = i+1; j < length; j++) {
                globalProfit = Math.max(globalProfit, array[j] - array[i]);
            }
        }
        return globalProfit;
    }

    // instead of checking all the possibilities if we can keep track of the minPrice (as our
    // goal is to find the max profit which is always most biggest price minus the most smallest price)
    // with this approach we can easily find the maxprofit in one pass
    static public int answer2(int[] array) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            minPrice = Math.min(minPrice, array[i]);
            maxProfit = Math.max(maxProfit, array[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int answer = answer2(array);
        System.out.println(answer);
    }
}
