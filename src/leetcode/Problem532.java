package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Set<Integer> input = new HashSet<>();
        if (k == 0) {
            Set<Integer> duplicate = new HashSet<>();
            for (int num : nums) {
                if (input.contains(num)) {
                    duplicate.add(num);
                } else {
                    input.add(num);
                }
            }
            return duplicate.size();
        }
        int result = 0;
        for (int num : nums) {
            input.add(num);
        }
        for (Integer i : input) {
            if (input.contains(i + k)) {
                result++;
            }
        }
        return result;
    }
}
