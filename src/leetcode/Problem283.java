package leetcode;

public class Problem283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int writeIn = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIn++] = nums[i];
            }
        }
        for (; writeIn < nums.length; writeIn++) {
            nums[writeIn] = 0;
        }
    }
}
