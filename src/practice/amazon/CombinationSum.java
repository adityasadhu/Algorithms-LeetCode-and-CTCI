package practice.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    static public List<List<Integer>> answer(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backTrack(answer, new ArrayList<>(), nums, target, 0);
        return answer;
    }

    private static void backTrack(List<List<Integer>> answer, ArrayList<Integer> tempList, int[] nums, int target, int i) {

        if (target < 0)
            return;
        else if (target == 0) {
            answer.add(new ArrayList<>(tempList));
        } else {
            for (int j = i; j < nums.length; j++) {
                tempList.add(nums[j]);
                backTrack(answer, tempList, nums, target - nums[j], j);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(answer(new int[]{2, 3, 6, 7}, 7));

    }
}
