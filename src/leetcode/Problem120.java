package leetcode;

import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-23 14:52
 **/
public class Problem120 {
    // Runtime: 2 ms, faster than 76.85% of Java online submissions for Triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = 1; i <= triangle.size(); i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i - 1).get(j - 1);
                else if (j == 1)
                    dp[i][j] = dp[i - 1][j] + triangle.get(i - 1).get(0);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i - 1).get(j - 1);
            }
        }
        int rst = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++)
            rst = Math.min(rst, dp[dp.length - 1][i]);

        return rst;
    }

    // Runtime: 2 ms, faster than 76.85% of Java online submissions for Triangle.
    //Memory Usage: 39.3 MB, less than 16.65% of Java online submissions for Triangle.
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int[] dp = new int[triangle.size() + 1];
        for (int i = 1; i <= triangle.size(); i++) {
            for (int j = i; j >= 1; j--) {
                if (j == i)
                    dp[j] = dp[j - 1] + triangle.get(i - 1).get(j - 1);
                else if (j == 1)
                    dp[j] = dp[j] + triangle.get(i - 1).get(0);
                else
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i - 1).get(j - 1);
            }
        }
        int rst = dp[1];
        for (int i = 2; i < dp.length; i++)
            rst = Math.min(rst, dp[i]);
        return rst;
    }
}
