package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-03 14:13
 **/
public class Problem191 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of 1 Bits.
    //Memory Usage: 35.7 MB, less than 5.67% of Java online submissions for Number of 1 Bits.
    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += n & 0x1;
            n >>>= 1;
        }
        return sum;
    }
}
