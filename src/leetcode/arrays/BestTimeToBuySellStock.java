//Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Note that you cannot sell a stock before you buy one.

package leetcode.arrays;

public class BestTimeToBuySellStock {

//    static public int answer (int[] array){
//        int length = array.length;
//        int globalProfit = 0;
//
//        for (int i = 0; i < length -1; i++) {
//            for (int j = i+1; j < length; j++) {
//                int profit = array[j] - array[i];
//                if(profit > globalProfit){
//                    globalProfit = profit;
//                }
//            }
//        }
//
//        return globalProfit;
//    }


    static public int answer(int[] array) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minPrice) {
                minPrice = array[i];
            } else if (maxProfit < array[i] - minPrice) {
                maxProfit = array[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int answer = answer(array);
        System.out.println(answer);
    }
}
