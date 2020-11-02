package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-26 18:00
 **/
public class Problem260 {

    // Runtime: 4 ms, faster than 27.42% of Java online submissions for Single Number III.
    //Memory Usage: 39.5 MB, less than 5.26% of Java online submissions for Single Number III.
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] rst = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 2)
                rst[i++] = entry.getKey();
        }
        return rst;
    }



    // 官方解法： https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/
    // Runtime: 1 ms, faster than 98.88% of Java online submissions for Single Number III.
    //Memory Usage: 39.1 MB, less than 5.26% of Java online submissions for Single Number III.
    public int[] singleNumber2(int[] nums) {
        int bitMask = 0;
        for (int num : nums)
            bitMask ^= num;
        int diff = bitMask & -bitMask;
        int x = 0;
        for (int num : nums)
            if ((diff & num) != 0)
                x ^= num;
        return new int[]{x, bitMask ^ x};
    }
}
