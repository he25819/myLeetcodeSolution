package leetcode;

public class Problem724 {
    // 20ms
    // Time Complexity: O(N), where NN is the length of nums.
    //
    //Space Complexity: O(N), the space used by leftsum[] and S.
    public int pivotIndex(int[] nums) {
        int sum = 0;

        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = sum;
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] * 2 + nums[i] == sum) {
                return i;
            }
        }
        return -1;
    }

    // 26ms
    // Time Complexity: O(N), where NN is the length of nums.
    //Space Complexity: O(1), the space used by leftsum and S.
    public int pivotIndex2(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
