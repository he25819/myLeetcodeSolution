package leetcode;

public class Problem41 {
    /**
     * 157 / 157 test cases passed.
     * Status: Accepted
     * Runtime: 7 ms
     * run in O(n) time and uses constant extra space.
     * 如果用extra int[]很容易想到。O(1) space complexity方法见下面的例子及代码。
     * [3,2,4,8,6,5]
     * [3,2,3,8,6,5]    4
     * [3,2,3,4,6,5]    8
     * [3,2,3,4,6,6]    5
     * [3,2,3,4,5,6]    6
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i], k;
            while (tmp > 0 && tmp <= nums.length && nums[tmp - 1] != tmp) {
                k = tmp;
                tmp = nums[k - 1];
                nums[k - 1] = k;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }
}
