package leetcode;

public class Problem132 {
    // 28 / 29 test cases passed.
    //Status: Time Limit Exceeded
    // O(N^3) 结果是正确的，但是效率不行，下面的方法都是O(N^2)
    public int minCut0(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int k = 1; k <= len; k++) {
            for (int left = 0; left < len - k; left++) {
                int right = left + k;
                if (isPalindrome(s, left, right))
                    continue;
                dp[left][right] = Integer.MAX_VALUE;
                for (int i = left; i < right; i++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][i] + dp[i + 1][right] + 1);
                }
            }
        }
        return dp[0][len - 1];
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
}

    // 29 / 29 test cases passed.
    //Status: Accepted
    //Runtime: 14 ms
    // Your runtime beats 63.10 % of java submissions.
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int len = s.length();
        boolean isPal[][] = new boolean[len][len];
        int[] minCut = new int[len];

        for (int i = 0; i < len; i++) {
            isPal[i][i] = true;
            if (i + 1 < len)
                isPal[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int k = 2; k < len; k++) {
            for (int left = 0; left < len - k; left++) {
                int right = left + k;
                isPal[left][right] = isPal[left + 1][right - 1] && s.charAt(left) == s.charAt(right);
            }
        }

        for (int i = 0; i < len; i++) {
            minCut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (isPal[j][i])
                    minCut[i] = Math.min(minCut[i], j == 0 ? 0 : minCut[j - 1] + 1);
            }
        }
        return minCut[len - 1];
    }

    //learn and copy from https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42213/Easiest-Java-DP-Solution-(97.36)
    // 29 / 29 test cases passed.
    //Status: Accepted
    //Runtime: 6 ms
    // Your runtime beats 96.90 % of java submissions.
    public int minCut2(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    // copy from https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space.
    // "My solution does not need a table for palindrome, is it right ? It uses only O(n) space."
    // 29 / 29 test cases passed.
    //Status: Accepted
    //Runtime: 11 ms
    // Your runtime beats 76.98 % of java submissions.
    public int minCut3(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n + 1];  // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) cut[i] = i-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >= 0 && i+j < n && c[i-j]==c[i+j] ; j++) // odd length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j]);

            for (int j = 1; i-j+1 >= 0 && i+j < n && c[i-j+1] == c[i+j]; j++) // even length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);
        }
        return cut[n];
    }
}
