package leetcode;

public class Problem268 {

    // Accepted
    // Time complexity : O(n)
    // Space complexity : O(1)
    public int missingNumber3(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i] ^ i;
        }
        return result;
    }

    // Accepted
    // Time complexity : O(n)
    // Space complexity : O(1)
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (nums.length - 1) * nums.length / 2 - sum;
    }
    // Accepted
    // Time complexity : O(n)
    // Space complexity : O(n)
    public int missingNumber1(int[] nums) {
        boolean[] flags = new boolean[nums.length + 1];
        for (int num : nums) {
            flags[num] = true;
        }
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                return i;
            }
        }
        return -1;
    }
}
