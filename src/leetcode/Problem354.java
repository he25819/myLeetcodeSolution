package leetcode;

import java.util.*;

public class Problem354 {
    // Time Limit Exceeded
    // LIS可以用O(NlogN)优化
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(e -> e[0]));
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int len = 0;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    public static void main(String[] args) {
//        int[][] e = new int[][]{{2, 3}, {5, 5}, {6, 4}, {7, 5}};
        int[][] e = new int[][]{{2, 3}, {2, 4}};
        System.out.println(new Problem354().maxEnvelopes2(e));
    }

    // 先搞明白最长递增子序列（leetcode300）的O(NlogN)解法，见下方
    // Runtime
    //45 ms
    //Beats
    //100%
    //Memory
    //85.4 MB
    //Beats
    //24.36%
    public int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] - e2[0] == 0)
                return e2[1] - e1[1];
            else
                return e1[0] - e2[0];
        });

        int[] dp = new int[envelopes.length];
        int len = 0;
        dp[len] = envelopes[0][1];

        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > dp[len]) {
                dp[++len] = envelopes[i][1];
            } else {
                int idx = Arrays.binarySearch(dp, 0, len + 1, envelopes[i][1]);
                if (idx < 0)
                    dp[-idx - 1] = envelopes[i][1];
            }
        }
        return len + 1;
    }


    // leetcode 300. Longest Increasing Subsequence 贪心+二分解法
    // （未运行过）
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        dp[len] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int idx = Arrays.binarySearch(dp, 0, len + 1, nums[i]);
                if (idx < 0)
                    dp[-idx - 1] = nums[i];
            }
        }
        return len + 1;
    }
}
