//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        The same repeated number may be chosen from candidates unlimited number of times.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7,
//        A solution set is:
//        [
//        [7],
//        [2,2,3]
//        ]
//        Example 2:
//
//        Input: candidates = [2,3,5], target = 8,
//        A solution set is:
//        [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//        ]

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> innerList = new ArrayList<>();
        backtrack(innerList, new ArrayList<>(), nums, target, 0);
        return innerList;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remainingSum, int start) {
        if (remainingSum < 0) return;
        else if (remainingSum == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remainingSum - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
        int[] array = {2, 3, 5};
        List<List<Integer>> result = new ArrayList<>();
        result = combinationSum.combinationSum(array, 8);
        System.out.println(result);

    }
}
