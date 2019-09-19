package leetcode;

import java.util.Arrays;

public class Problem628 {
    // [-2,5,-10,3,1]   result:100
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
