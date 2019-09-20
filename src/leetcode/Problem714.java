package leetcode;

public class Problem714 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
//        new Problem714().maxProfit2(prices, 2);
    }

    //Time Limit Exceeded
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0)
            return 0;

        int result = 0;
        int[][] benefit = new int[prices.length][prices.length];
        for (int k = 1; k < prices.length; k++) {
            for (int i = 0; i < prices.length - k; i++) {
                benefit[i][i + k] = Math.max(0, prices[i + k] - prices[i] - fee);
                for (int x = i + 1; x < i + k; x++)
                    benefit[i][i + k] = Math.max(benefit[i][i + k], benefit[i][x] + benefit[x][i + k]);
            }
        }
        return benefit[0][prices.length - 1];
    }

    // 看这个！
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
    // 以后再看
}
