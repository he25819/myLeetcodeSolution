package leetcode;

import java.util.Arrays;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-21 11:31
 **/
public class Problem287 {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
    //Memory Usage: 38.7 MB, less than 13.96% of Java online submissions for Find the Duplicate Number.
    public int findDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int num : nums) {
            if (visited[num])
                return num;
            visited[num] = true;
        }
        return 0;
    }


    // Runtime: 2 ms, faster than 49.95% of Java online submissions for Find the Duplicate Number.
    //Memory Usage: 38.7 MB, less than 13.96% of Java online submissions for Find the Duplicate Number.
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return nums[i];
        }
        return 0;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
    //Memory Usage: 38.7 MB, less than 13.96% of Java online submissions for Find the Duplicate Number.
    public int findDuplicate3(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                int rst = 0;
                while (rst != slow) {
                    rst = nums[rst];
                    slow = nums[slow];
                }
                return rst;
            }
        }
    }
}
