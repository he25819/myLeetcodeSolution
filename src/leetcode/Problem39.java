package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int[] candidates2 = new int[]{5,6,3,7,8,9,10};
        System.out.println(new Problem39().combinationSum(candidates2, 20));
    }

    private static List<Integer> combination = new ArrayList<>();

    // 168 / 168 test cases passed.
    //Status: Accepted
    //Runtime: 15 ms
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;

        List<Integer> oneComb = backtrack(result, candidates, 0, n - 1, 0, target);
        if (oneComb != null)
            result.add(oneComb);
        return result;
    }

    private List<Integer> backtrack(List<List<Integer>> result, int[] candidates, int lt, int rt, int sum, int target) {
        for (int i = lt; i <= rt; i++) {
            sum += candidates[i];
            if (sum > target)
                return null;

            List<Integer> oneComb;
            if (sum == target) {
                oneComb = new ArrayList<>(combination);
                oneComb.add(candidates[i]);
                return oneComb;
            } else {
                combination.add(candidates[i]);
                oneComb = backtrack(result, candidates, i, rt, sum, target);
                if (oneComb != null) {
                    result.add(oneComb);
                }
                sum -= candidates[i];   // backtrack
                combination.remove(combination.size() - 1);
            }
        }
        return null;
    }

    // https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    // 168 / 168 test cases passed.
    //Status: Accepted
    //Runtime: 11 ms
    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack2(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 168 / 168 test cases passed.
    //Status: Accepted
    //Runtime: 10 ms
    public List<List<Integer>> combinationSum3(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0 || target <= 0)    // 去掉这个if语句，运行时间变为18ms！？
            return list;
        Arrays.sort(nums);
        backtrack3(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack3(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] > remain)
                    break;
                tempList.add(nums[i]);
                backtrack3(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
