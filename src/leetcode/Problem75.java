package leetcode;

public class Problem75 {
    // 87 / 87 test cases passed.
    //Status: Accepted
    //Runtime: 0 ms
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int n : nums)
            if (n == 0)
                zero++;
            else if (n == 1)
                one++;
            else
                two++;

        int n = 0;
        for (int i = 0; i < zero; i++, n++)
            nums[n] = 0;
        for (int i = 0; i < one; i++, n++)
            nums[n] = 1;
        for (int i = 0; i < two; i++, n++)
            nums[n] = 2;
    }

    // 还可以只循环一次
    // sample 0 ms submission
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        for (int zeroPos = 0, twoPos = len - 1, i = 0; i <= twoPos; ) {
            if (nums[i] == 0) {
                swap(nums, zeroPos++, i++);
            } else if (nums[i] == 1) {
                i++;
            } else { // == 2
                swap(nums, i, twoPos--);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
