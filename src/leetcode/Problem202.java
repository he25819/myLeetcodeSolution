package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-12-01 11:18
 **/
public class Problem202 {

    // Runtime: 6 ms, faster than 7.72% of Java online submissions for Happy Number.
    //Memory Usage: 36.1 MB, less than 37.04% of Java online submissions for Happy Number.
    public boolean isHappy(int n) {
        int tmp;
        for (int i = 0; i < 1000; i++) {
            if (n == 1)
                return true;
            tmp = 0;
            while (n > 0) {
                int a = n % 10;
                tmp += a * a;
                n /= 10;
            }
            n = tmp;
        }
        return false;
    }
}
