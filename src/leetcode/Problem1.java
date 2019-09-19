package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
    //1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> inputs = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            inputs.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (inputs.containsKey(b) && inputs.get(b) != i) {
                result[0] = i;
                result[1] = inputs.get(b);
                return result;
            }
        }

        return null;
    }
}
