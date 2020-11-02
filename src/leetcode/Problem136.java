package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-23 15:49
 **/
public class Problem136 {
    // Runtime: 1 ms, faster than 74.06% of Java online submissions for Single Number.
    //Memory Usage: 39.3 MB, less than 6.29% of Java online submissions for Single Number.
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int rst = nums[0];
        for (int i = 1; i < nums.length; i++)
            rst ^= nums[i];
        return rst;
    }
}
