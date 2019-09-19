package leetcode;

public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        int modifyTimes = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (++modifyTimes > 1) {
                    return false;
                }
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    continue;
                }
                if (i == nums.length - 1 || nums[i + 1] >= nums[i - 1]) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
