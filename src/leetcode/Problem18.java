package leetcode;

import java.util.*;

// 4Sum     leetcode.Problem454: 4Sum II
public class Problem18 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 1, 3};
        System.out.println(new Problem18().fourSum2(nums, 5));
    }

    // 4个指针
    // 72ms Accepted
    // time complexity: O(N^3)
    // 可以优化，但没优化
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int threeSum = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int twoSum = threeSum - nums[j];

                int lo = j + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int cur = nums[lo] + nums[hi];
                    if (cur == twoSum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[++lo])
                            ;
                        while (lo < hi && nums[hi] == nums[--hi])
                            ;
                    } else if (cur < twoSum)
                        while (lo < hi && nums[lo] == nums[++lo])
                            ;
                    else
                        while (lo < hi && nums[hi] == nums[--hi])
                            ;
                }
            }
        }
        return res;
    }


    // time complexity: O(N^2)
    // Accepted  Runtime:70ms
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        Map<Integer, List<Integer>> twoSumMap = new HashMap<>();
        int sum;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (twoSumMap.containsKey(sum)) {
                    List<Integer> indexs = twoSumMap.get(sum);
                    indexs.add(i);
                    indexs.add(j);
                } else {
                    List<Integer> indexs = new ArrayList<>();
                    indexs.add(i);
                    indexs.add(j);
                    twoSumMap.put(sum, indexs);
                }
            }
        }

        Set<Integer> twoSums = twoSumMap.keySet();
        Set<Integer> scaned = new HashSet<>();
        for (Integer twoSum : twoSums) {
            if (scaned.contains(twoSum)) {
                continue;
            }
            int delta = target - twoSum;
            if (twoSums.contains(delta)) {
                addDiffIndexNum(res, twoSumMap.get(twoSum), twoSumMap.get(delta), nums);
                scaned.add(twoSum);
                scaned.add(delta);
            } else
                scaned.add(twoSum);
        }
        return res;
    }

    private void addDiffIndexNum(List<List<Integer>> res, List<Integer> idx1, List<Integer> idx2, int[] nums) {
        for (int i = 0; i < idx1.size() - 1; i += 2) {
            for (int j = 0; j < idx2.size() - 1; j += 2) {
                if (idx1.get(i) != idx2.get(j) && idx1.get(i) != idx2.get(j + 1) && idx1.get(i + 1) != idx2.get(j) && idx1.get(i + 1) != idx2.get(j + 1)) {
                    Integer[] tmp = new Integer[]{nums[idx1.get(i)], nums[idx1.get(i + 1)], nums[idx2.get(j)], nums[idx2.get(j + 1)]};
                    Arrays.sort(tmp);
                    List<Integer> tmplist = Arrays.asList(tmp);
                    if (!res.contains(tmplist))
                        res.add(tmplist);
                }
            }
        }
    }
}
