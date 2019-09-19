package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem448 {

    // 48 ms
    // Time complexity : O(n)
    // Space complexity : O(n)
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    // 9ms
    // Time complexity : O(n)
    // Space complexity : O(1)!!!!!!!!!!!!!!!
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    // 7 ms
    // Time complexity : O(n)
    // Space complexity : O(n)
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] flags = new boolean[nums.length + 1];

        for (int num : nums) {
            flags[num] = true;
        }
        for (int i = 1; i < flags.length; i++) {
            if (!flags[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
