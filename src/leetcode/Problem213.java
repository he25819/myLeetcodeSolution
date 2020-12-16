package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-30 16:33
 **/
public class Problem213 {
    public static void main(String[] args) {
        new Problem213().rob(new int[]{1});
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
    //Memory Usage: 36.3 MB, less than 50.53% of Java online submissions for House Robber II.
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            dp1[i] = Math.max((i - 2 >= 0 ? dp1[i - 2] : 0) + nums[i], (i - 1 >= 0 ? dp1[i - 1] : 0));
            dp2[i + 1] = Math.max((i - 1 >= 0 ? dp2[i - 1] : 0) + nums[i + 1], dp2[i]);
        }
        return Math.max(Math.max(nums.length > 1 ? dp1[nums.length - 2] : 0, dp2[nums.length - 1]), nums[0]);
    }
}
