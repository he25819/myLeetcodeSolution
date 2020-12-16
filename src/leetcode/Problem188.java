package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-12-01 14:16
 **/
public class Problem188 {
    /*
2
[2,4,1]
2
[3,2,6,5,0,3]
1
[3,2,6,5,0,3]
0
[3,2,6,5,0,3]
3
[3,2,6,5,0,3]
4
[3,2,6,5,0,3]
5
[3,2,6,5,0,3]
6
[3,2,6,5,0,3]
7
[3,2,6,5,0,3]
8
[3,2,6,5,0,3]
100000
[3,2,6,5,0,3]
2
[]
2
[1,2,4]
1
[1,2,4]
11
[48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94]
     */
    public static void main(String[] args) {
        System.out.println(new Problem188().maxProfit(2, new int[]{2,4,1}));
//        System.out.println(new Problem188().maxProfit(11, new int[]{48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94}));
    }



    // 思路 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-w-5/
    // Runtime: 7 ms, faster than 34.19% of Java online submissions for Best Time to Buy and Sell Stock IV.
    //Memory Usage: 41.8 MB, less than 5.18% of Java online submissions for Best Time to Buy and Sell Stock IV.
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][][] max = new int[n + 1][k + 1][2];

        for (int i = 0; i <= n; i++) {
            max[i][0][1] = Integer.MIN_VALUE;
        }
        for (int j = 0; j <= k; j++) {
            max[0][j][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                max[i][j][0] = Math.max(max[i - 1][j][0], max[i - 1][j][1] + prices[i - 1]);
                max[i][j][1] = Math.max(max[i - 1][j][1], max[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return max[n][k][0];
    }

    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/si-chong-jie-fa-tu-jie-188mai-mai-gu-piao-de-zui-j/
    // 超时
    // Time Limit Exceeded
    // 11
    //[48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94]
    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        return dfs(0, 0, 0, k, prices);
    }

    private int dfs(int index, int status, int count, int k, int[] prices) {
        if (index == prices.length || count == k)
            return 0;
        int a = 0, b = 0, c = 0;
        a = dfs(index + 1, status, count, k, prices);
        if (status == 1) {
            b = dfs(index + 1, 0, count + 1, k, prices) + prices[index];
        } else {
            c = dfs(index + 1, 1, count, k, prices) - prices[index];
        }
        return Math.max(a, Math.max(b, c));
    }
}
