package leetcode;

public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int buyPrice = prices[0];
        int sum;
        for (int i = 1; i < prices.length; i++) {
            sum = prices[i] - buyPrice;
            if (sum > 0) {
                maxProfit += sum;
            }
            buyPrice = prices[i];
        }
        return maxProfit;
    }
}
