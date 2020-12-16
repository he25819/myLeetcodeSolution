package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-30 16:24
 **/
public class Problem198 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    //Memory Usage: 36.2 MB, less than 70.80% of Java online submissions for House Robber.
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max((i - 2 >= 0 ? dp[i - 2] : 0) + nums[i], (i - 1 >= 0 ? dp[i - 1] : 0));
        }
        return dp[nums.length - 1];
    }
}
