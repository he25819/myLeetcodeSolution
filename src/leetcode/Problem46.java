package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem46 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println(new Problem46().permute2(nums));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    // 25 / 25 test cases passed.
    //Status: Accepted
    //Runtime: 105 ms
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        List<Integer> tempList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(result, new LinkedList<>(), tempList);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> A, List<Integer> B) {
        if (B.isEmpty())
            result.add(new ArrayList<>(A));
        else {
            for (int i = 0; i < B.size(); i++) {
                A.add(B.get(i));
                B.remove(i);
                backtrack(result, A, B);
                B.add(i, A.remove(A.size() - 1));
            }
        }
    }

    // 25 / 25 test cases passed.
    //Status: Accepted
    //Runtime: 2 ms
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        boolean[] isUsed = new boolean[nums.length];
        backtrack2(result, nums, new ArrayList<>(), isUsed);
        return result;
    }

    private void backtrack2(List<List<Integer>> result, int[] nums, List<Integer> tempList, boolean[] isUsed) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < isUsed.length; i++) {
                if (!isUsed[i]) {
                    tempList.add(nums[i]);
                    isUsed[i] = true;
                    backtrack2(result, nums, tempList, isUsed);
                    isUsed[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
