//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//        Note: You may not slant the container and n is at least 2.
//
//
//
//
//
//        The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//
//
//
//        Example:
//
//        Input: [1,8,6,2,5,4,8,3,7]
//        Output: 49


package leetcode.arrays;

public class ContainerWithMostWater {

    //brute force approach which is simply calculating every possibility
    static public int answer(int[] heights) {
        int answer = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                answer = Math.max(answer, Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return answer;
    }

    //two pointer technique one starts at the start and other at the end. we maximize the area considering length and height
    //we move the pointer with the least height of both pointers and update the maximum area
    static public int answer2(int[] heights) {

        int start = 0;
        int end = heights.length - 1;
        int maxArea = 0;

        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(heights[start], heights[end]) * (end - start));
            if (heights[start] <= heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int answer = answer2(heights);
        System.out.println(answer);


    }
}
