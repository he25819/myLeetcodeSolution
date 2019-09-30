package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[] nums2 = new int[]{1, 2, 3, 4, 6, 8, 10, 12};
        int[] nums3 = new int[]{3,4,16,8};
        int[] nums4 = new int[]{4,8,10,240};

        System.out.println(new Problem368().largestDivisibleSubset(nums4));
    }

    //动态规划
    //Runtime: 15 ms, faster than 93.13% of Java online submissions for Largest Divisible Subset.
    //Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Largest Divisible Subset.
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int[] size = new int[nums.length];
        int[] preIndex = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            size[i] = 1;
            preIndex[i] = -1;
            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0 && size[i] < size[k] + 1) {
                    size[i] = size[k] + 1;
                    preIndex[i] = k;
                }
            }
        }

        int maxSize = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (size[i] > maxSize) {
                index = i;
                maxSize = size[i];
            }
        while (index >= 0) {
            result.add(nums[index]);
            index = preIndex[index];
        }
        return result;
    }
}
