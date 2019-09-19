package leetcode;

public class Problem31 {
    // 15ms Accepted 265 / 265 test cases passed.
    // Time complexity : O(n)
    // Space complexity : O(1)
    public void nextPermutation(int[] nums) {
        int lastIndex = nums.length - 1;
        if (nums == null || lastIndex < 1)
            return;
        int idx = lastIndex;

        while (idx > 0 && nums[idx] <= nums[idx - 1])
            idx--;


        if (idx == 0) {
            reverse(nums, 0, lastIndex);
        } else {
            int changeIdx = DescBinarySearch(nums, idx, nums.length, nums[idx - 1]);
            if (changeIdx < 0)
                changeIdx = -changeIdx - 2;
            else
                while (nums[changeIdx] == nums[--changeIdx])
                    ;

            swap(nums, idx - 1, changeIdx);
            reverse(nums, idx, lastIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private int DescBinarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                high = mid - 1;
            else if (midVal > key)
                low = mid + 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    // Time complexity : O(n)
    // Space complexity : O(1)
    // 16ms 265 / 265 test cases passed.
    public void nextPermutation2(int[] nums) {
        int lastIndex = nums.length - 1;
        if (nums == null || lastIndex < 1)
            return;
        int idx = lastIndex - 1;

        while (idx >= 0 && nums[idx + 1] <= nums[idx])
            idx--;


        if (idx >= 0) {
            int changeIdx = lastIndex;
            while (changeIdx > idx && nums[changeIdx] <= nums[idx])
                changeIdx--;
            swap(nums, idx, changeIdx);
        }
        reverse(nums, idx + 1, lastIndex);
    }
}
