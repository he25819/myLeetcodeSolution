package leetcode;

public class Problem121 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        new Problem121().maxProfit(nums);
    }
    //    121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int sum;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = prices[i] - minPrice;
            if (sum > maxProfit) {
                maxProfit = sum;
            } else if (sum < 0) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
