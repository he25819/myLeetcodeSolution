package leetcode;

public class Problem53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Problem53().maxSubArray1(nums));
    }

    //    53. Maximum Subarray
    //O(N)
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    //O(logN)
    public int maxSubArray2(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int l, int r) {
        if (l >= r) {
            return nums[l];
        }

        int m = (l + r) / 2;
        int leftMax = maxSubArray(nums, l, m);
        int rightMax = maxSubArray(nums, m + 1, r);

        int lSum = nums[m], rSum = 0;
        int lMax = lSum, rMax = rSum;
        for (int i = m - 1; i >= l; i--) {
            lSum += nums[i];
            if (lMax < lSum) {
                lMax = lSum;
            }
        }
        for (int i = m + 1; i <= r; i++) {
            rSum += nums[i];
            if (rMax < rSum) {
                rMax = rSum;
            }
        }
        int midMax = lMax + rMax;
        return Math.max(Math.max(leftMax, rightMax), midMax);
    }
}
