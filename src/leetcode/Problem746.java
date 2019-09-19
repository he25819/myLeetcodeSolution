package leetcode;

public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        int lastCost = 0, beforeLastCost = 0;
        int costSum = 0;
        for (int i = 2; i < cost.length; i++) {
            int tmp = Math.min(beforeLastCost + cost[i - 2], lastCost + cost[i - 1]);
            beforeLastCost = lastCost;
            lastCost = tmp;
        }
        return Math.min(beforeLastCost + cost[cost.length - 2], lastCost + cost[cost.length - 1]);
    }
}
