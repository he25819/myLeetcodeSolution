package leetcode;

import java.util.TreeSet;

public class Problem414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (set.size() < 3 && !set.contains(num)) {
                set.add(num);
            } else if (!set.contains(num) && num > set.first()) {
                set.remove(set.first());
                set.add(num);
            }
        }
        return set.size() < 3 ? set.last() : set.first();
    }
}
