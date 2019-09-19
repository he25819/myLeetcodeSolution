package leetcode;

import java.util.Arrays;

public class Problem581 {
//    Time complexity : O(nlogn). Sorting takes nlogn time.
//    Space complexity : O(n). We are making copy of original array.
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == copy[i]) {
                result--;
            } else {
                break;
            }
        }
        if (result <= 2) {
            return result;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == copy[i]) {
                result--;
            } else {
                break;
            }
        }
        return result;
    }
}
