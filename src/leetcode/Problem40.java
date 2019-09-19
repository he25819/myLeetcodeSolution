package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {
    // 172 / 172 test cases passed.
    //Status: Accepted
    //Runtime: 14 ms
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return result;
        Arrays.sort(candidates);
        backtrack(result, candidates, new ArrayList<>(), 0, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates, List<Integer> tempList, int start, int remain) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            int lastCandidate = -1;
            for (int i = start; i < candidates.length; i++) {
                if (remain < candidates[i])
                    break;
                if (lastCandidate == candidates[i])
                    continue;
                lastCandidate = candidates[i];
                tempList.add(candidates[i]);
                backtrack(result, candidates, tempList, i + 1, remain - candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 172 / 172 test cases passed.
    //Status: Accepted
    //Runtime: 10 ms
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return result;
        Arrays.sort(candidates);
        backtrack2(result, candidates, new ArrayList<>(), 0, target);
        return result;
    }

    private void backtrack2(List<List<Integer>> result, int[] candidates, List<Integer> tempList, int start, int remain) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (remain < candidates[i])
                    break;
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                tempList.add(candidates[i]);
                backtrack(result, candidates, tempList, i + 1, remain - candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
