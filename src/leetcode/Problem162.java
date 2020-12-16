package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-30 17:38
 **/
public class Problem162 {

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Peak Element.
    //Memory Usage: 38.7 MB, less than 38.41% of Java online submissions for Find Peak Element.
    public int findPeakElement(int[] nums) {
        boolean[] up = new boolean[nums.length];
        boolean[] down = new boolean[nums.length];
        up[0] = true;
        down[nums.length - 1] = true;

        for (int i = 1; i < nums.length; i++)
            up[i] = nums[i] > nums[i - 1];
        for (int i = nums.length - 2; i >= 0; i--)
            down[i] = nums[i] > nums[i + 1];

        for (int i = 0; i < nums.length; i++) {
            if (up[i] && down[i])
                return i;
        }
        return -1;
    }
}
