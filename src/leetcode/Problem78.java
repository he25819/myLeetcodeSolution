package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    // 10 / 10 test cases passed.
    //Status: Accepted
    //Runtime: 1 ms
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            backtrack(result, tempList, nums, start + 1);
            tempList.add(nums[start]);
            backtrack(result, tempList, nums, start + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
