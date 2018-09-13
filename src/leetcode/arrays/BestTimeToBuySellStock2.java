//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//
//        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//        Example 1:
//
//        Input: [7,1,5,3,6,4]
//        Output: 7
//        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//        Example 2:
//
//        Input: [1,2,3,4,5]
//        Output: 4
//        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//        Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//        engaging multiple transactions at the same time. You must sell before buying again.
//        Example 3:
//
//        Input: [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transaction is done, i.e. max profit = 0.

package leetcode.arrays;

public class BestTimeToBuySellStock2 {


    // we can solve this by using peak valley approach where the concept is that we get the maximum profit if
    // we sell the stock if we find a immediate rise in the value(peak) followed by a less value(valley)
    static public int peakValleyApproach(int[] heights) {

        int i = 0;
        int valley = 0;
        int peak = 0;
        int maxProfit = 0;
        while (i < heights.length - 1) {
            while (i < heights.length - 1 && heights[i] >= heights[i + 1]) {
                i++;
            }
            valley = heights[i];
            while (i < heights.length - 1 && heights[i] < heights[i + 1]) {
                i++;
            }
            peak = heights[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }


    static public int peakValleyApproachOptimized(int[] heights) {
        int maxprofit = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1])
                maxprofit += heights[i] - heights[i - 1];
        }
        return maxprofit;
    }


    public static void main(String[] args) {

        int[] heights = {1, 2, 3, 2, 5};
        int answer = peakValleyApproachOptimized(heights);
        System.out.println(answer);

    }


}
