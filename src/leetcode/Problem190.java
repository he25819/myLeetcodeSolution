package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-03 14:18
 **/
public class Problem190 {
    // Runtime: 1 ms, faster than 98.59% of Java online submissions for Reverse Bits.
    //Memory Usage: 38.7 MB, less than 11.49% of Java online submissions for Reverse Bits.
    public int reverseBits(int n) {
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            rst = (rst << 1) | (0b1 & n);
            n >>>= 1;
        }
        return rst;
    }
}
