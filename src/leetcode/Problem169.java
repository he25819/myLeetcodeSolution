package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    //Time complexity : O(n)
    //Space complexity : O(1)
    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    //Time complexity : O(n)
    //Space complexity : O(n)
    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> inputs = new HashMap<>();
        int times;
        for (int num : nums) {
            if (inputs.containsKey(num)) {
                times = inputs.get(num);
                if (++times > nums.length / 2) {
                    return num;
                }
                inputs.put(num, times);
            } else {
                inputs.put(num, 1);
            }
        }
        return -1;
    }
}
