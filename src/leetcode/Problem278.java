package leetcode;

public class Problem278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    private boolean isBadVersion(int version) {
        return false;
    }

    /**
     * 22 / 22 test cases passed.
     * Status: Accepted
     * Runtime: 12 ms
     */
    public int firstBadVersion(int n) {
        int lo = 1;

        while (lo <= n) {
            int mid = (lo + n) >>> 1;
            if (isBadVersion(mid))
                n = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

}
