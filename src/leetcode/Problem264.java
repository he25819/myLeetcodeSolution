package leetcode;

import java.util.PriorityQueue;

public class Problem264 {

    // Runtime: 522 ms, faster than 5.04% of Java online submissions for Ugly Number II.
    //Memory Usage: 54.1 MB, less than 18.21% of Java online submissions for Ugly Number II.
    public int nthUglyNumber(int n) {
        int[] factors = new int[]{2, 3, 5};
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        while (--n > 0) {
            Integer num = heap.poll();
            for (int factor : factors) {
                int tmp = num * factor;
                if (tmp < 0)
                    break;
                if (!heap.contains(tmp)) {
                    heap.add(tmp);
                }
            }
        }
        return heap.poll();
    }


    // Runtime: 3 ms, faster than 85.46% of Java online submissions for Ugly Number II.
    //Memory Usage: 41.9 MB, less than 69.66% of Java online submissions for Ugly Number II.
    //Next challenges:
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        int i = 1;

        while (++i <= n) {
            dp[i] = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 5));
            if (dp[i] == dp[a] * 2)
                a++;
            if (dp[i] == dp[b] * 3)
                b++;
            if (dp[i] == dp[c] * 5)
                c++;
        }
        return dp[n];
    }
}
