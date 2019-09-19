package leetcode;

public class Problem33 {
    private static final int MIN_LEN = 4;

    /**
     * 196 / 196 test cases passed.
     * Status: Accepted
     * Runtime: 8 ms(cost 11ms when MIN_LEN = 8)
     * 很简单，直接二分法，判断一下在左半边还是右半边
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi)
            return -1;
        if (hi - lo < MIN_LEN) {
            while (lo <= hi) {
                if (nums[lo] == target) {
                    return lo;
                }
                lo++;
            }
            return -1;
        }

        int mid = (lo + hi) >>> 1;
        if (nums[lo] < nums[mid]) {
            if (target < nums[mid] && target >= nums[lo])
                return search(nums, lo, mid - 1, target);
            else if (target == nums[mid])
                return mid;
            else
                return search(nums, mid + 1, hi, target);
        } else {
            if (target <= nums[hi] && target > nums[mid])
                return search(nums, mid + 1, hi, target);
            else if (target == nums[mid])
                return mid;
            else
                return search(nums, lo, mid - 1, target);
        }
    }


    /**
     * copy from Discuss:https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple
     * 196 / 196 test cases passed.
     * Status: Accepted
     * Runtime: 16 ms
     */
    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            double num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target)
                lo = mid + 1;
            else if (num > target)
                hi = mid;
            else
                return mid;
        }
        return -1;
    }
}
