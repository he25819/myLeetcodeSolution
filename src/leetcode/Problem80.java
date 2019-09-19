package leetcode;

public class Problem80 {
    // 165 / 165 test cases passed.
    //Status: Accepted
    //Runtime: 8 ms
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int num = nums[0];
        int left = 1;
        boolean isTwice = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                if (!isTwice) {
                    nums[left++] = nums[i];
                    isTwice = true;
                }
            } else {
                nums[left++] = nums[i];
                num = nums[i];
                isTwice = false;
            }
        }
        return left;
    }

    // sample 1 ms submission
    // 165 / 165 test cases passed.
    //Status: Accepted
    //Runtime: 8 ms
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i = i + 1;
            }
        }
        return i;
    }
}
