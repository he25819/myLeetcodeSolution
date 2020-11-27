package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-27 16:31
 **/
public class Problem134 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
    //Memory Usage: 40.5 MB, less than 5.07% of Java online submissions for Gas Station.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0)
            return -1;

        int rst = -1;
        int sum = 0;
        int minPositive = Integer.MAX_VALUE;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum <= minPositive) {
                minPositive = sum;
                rst = (i + 1) % gas.length;
            }
        }
        if (sum >= 0)
            return rst;
        else
            return -1;
    }
}
