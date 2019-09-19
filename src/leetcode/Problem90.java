package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {
    // 19 / 19 test cases passed.
    //Status: Accepted
    //Runtime: 2 ms
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, 0, isUsed);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start, boolean[] isUsed) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            backtrack(result, tempList, nums, start + 1, isUsed);
            if (start == 0 || nums[start] != nums[start - 1] || isUsed[start - 1]) {
                tempList.add(nums[start]);
                isUsed[start] = true;
                backtrack(result, tempList, nums, start + 1, isUsed);
                tempList.remove(tempList.size() - 1);
                isUsed[start] = false;
            }
        }
    }
}
