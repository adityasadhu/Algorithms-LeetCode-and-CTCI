//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
//        Example:
//
//        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//        Output: 6

package leetcode.arrays;

public class TrappingRainWater {

    //brute force
    //find the maximum number left and right to the current number and substract it with the current height
    //to determine the current water trapped if there is any.
    static public int answer(int[] heights) {

        int answer = 0;

        for (int i = 0; i < heights.length; i++) {
            int maxRight = 0;
            int maxLeft = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, heights[j]);
            }
            for (int k = i; k < heights.length; k++) {
                maxRight = Math.max(maxRight, heights[k]);
            }
            answer += Math.min(maxLeft, maxRight) - heights[i];

        }
        return answer;

    }


    //using dp storing all the max heights on left and right side of a element in an array

    static public int answerDp(int[] heights) {

        int length = heights.length;
        int[] maxHeightsLeft = new int[length];
        int[] maxHeightsRight = new int[length];
        int answer = 0;

        maxHeightsLeft[0] = heights[0];
        for (int i = 1; i < length; i++) {
            maxHeightsLeft[i] = Math.max(heights[i], maxHeightsLeft[i - 1]);
        }
        maxHeightsRight[length - 1] = heights[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            maxHeightsRight[i] = Math.max(heights[i], maxHeightsRight[i + 1]);
        }

        for (int i = 1; i < length - 1; i++) {
            answer += Math.min(maxHeightsLeft[i], maxHeightsRight[i]) - heights[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int answer = answerDp(height);
        System.out.println(answer);

    }
}
