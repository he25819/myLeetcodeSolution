package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-23 18:06
 **/
public class Problem137 {
    // Runtime: 3 ms, faster than 55.37% of Java online submissions for Single Number II.
    //Memory Usage: 38.9 MB, less than 10.69% of Java online submissions for Single Number II.
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 3)
                return entry.getKey();
        }
        return 0;
    }

    // 看了其他答案
    // https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number II.
    //Memory Usage: 38.8 MB, less than 8.79% of Java online submissions for Single Number II.
    public int singleNumber2(int[] nums) {
        int seen_once = 0;
        int seen_twice = 0;

        for (int num : nums) {
            seen_once = ~seen_twice & (seen_once ^ num);
            seen_twice = ~seen_once & (seen_twice ^ num);
        }
        return seen_once;
    }


    // 还有网上的解法，时间复杂度O(N)，空间复杂度O(1)
    // https://segmentfault.com/a/1190000019660104
    // Runtime: 3 ms, faster than 54.84% of Java online submissions for Single Number II.
    //Memory Usage: 38.6 MB, less than 8.79% of Java online submissions for Single Number II.
    public int singleNumber3(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if ((num & 0x1) == 1)
                    counts[i]++;
                num >>= 1;
                if (num == 0)
                    break;
            }
        }
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            if (counts[i] % 3 != 0)
                rst |= 1 << (31 - i);
        }
        return rst;
    }
}
