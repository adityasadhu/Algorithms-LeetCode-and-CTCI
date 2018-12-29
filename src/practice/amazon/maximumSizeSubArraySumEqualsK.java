/*Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

        Note:
        The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

        Example 1:

        Input: nums = [1, -1, 5, -2, 3], k = 3
        Output: 4
        Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
        Example 2:

        Input: nums = [-2, -1, 2, 1], k = 1
        Output: 2
        Explanation: The subarray [-1, 2] sums to 1 and is the longest.
        Follow Up:
        Can you do it in O(n) time?
 */

package practice.amazon;

import java.util.HashMap;

/*We keep track of sum till that number while iterating. to find the maximum subarray which has sum equals to k
we need to find sum[j) which satisfies sum(j) - sum(i) = k
instead of finding that sum every time we use a hash map to keep track of (sum till that point) ---> index
*/
public class maximumSizeSubArraySumEqualsK {


    public static int answer(int[] nums, int k) {

        int length = nums.length;
        int maxLengthOfSubArray = 0;
        int sum = 0;

        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum == k)
                maxLengthOfSubArray = i + 1;
            else if (hashMap.containsKey(sum - k))
                maxLengthOfSubArray = Math.max(maxLengthOfSubArray, i - hashMap.get(sum - k));
            if (!hashMap.containsKey(sum))
                hashMap.put(sum, i);
        }

        return maxLengthOfSubArray;

    }

    public static void main(String[] args) {

        System.out.println(answer(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
