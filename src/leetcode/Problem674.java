package leetcode;

public class Problem674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int sum = 1;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lastNum) {
                sum++;
                if (sum > result) {
                    result = sum;
                }
            } else {
                sum = 1;
            }
            lastNum = nums[i];
        }
        return result;
    }
}
