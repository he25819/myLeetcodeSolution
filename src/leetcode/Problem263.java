package leetcode;

public class Problem263 {
    // Runtime: 2 ms, faster than 49.36% of Java online submissions for Ugly Number.
    //Memory Usage: 40.9 MB, less than 64.57% of Java online submissions for Ugly Number.
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1;
    }
}
