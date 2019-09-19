package leetcode;

public class Problem34 {

    /**
     * 88 / 88 test cases passed.
     * Status: Accepted
     * Runtime: 9 ms
     * time complexity: O(log n)
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        return binarySearchRange(nums, 0, nums.length - 1, target);
    }

    private int[] binarySearchRange(int[] nums, int lo, int hi, int target) {
        if(lo > hi)
            return new int[]{-1, -1};

        int mid = (lo + hi) >>> 1;
        if (nums[mid] == target) {
            int first = binarySearchRange(nums, lo, mid - 1, target)[0];
            int last = binarySearchRange(nums, mid + 1, hi, target)[1];
            if (first == -1) first = mid;
            if (last == -1) last = mid;
            return new int[]{first, last};
        } else if (nums[mid] < target)
            return binarySearchRange(nums, lo + 1, hi, target);
        else
            return binarySearchRange(nums, lo, hi - 1, target);
    }


    /**
     * copy from Solution: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/
     * 88 / 88 test cases passed.
     * Status: Accepted
     * Runtime: 6 ms
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }
}
