package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem47 {
    // 30 / 30 test cases passed.
    //Status: Accepted
    //Runtime: 6 ms
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        backtrack(result, nums, new LinkedList<>(), isUsed);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempList, boolean[] isUsed) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < isUsed.length; i++) {
                if (!isUsed[i]) {
                    if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1])
                        continue;
                    tempList.add(nums[i]);
                    isUsed[i] = true;
                    backtrack(result, nums, tempList, isUsed);
                    isUsed[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
