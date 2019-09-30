package leetcode;

public class Problem1143 {
    public static void main(String[] args) {
        new Problem1143().longestCommonSubsequence("abcde", "ace");
    }

    // 看了一下DP的思路 https://blog.csdn.net/xhj_enen/article/details/88395081
    //Runtime: 6 ms, faster than 98.05% of Java online submissions for Longest Common Subsequence.
    //Memory Usage: 36 MB, less than 100.00% of Java online submissions for Longest Common Subsequence.
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0)
            return 0;
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int m = text1.length(), n = text2.length();
        int[][] C = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1])
                    C[i][j] = C[i - 1][j - 1] + 1;
                else
                    C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
            }
        }
        return C[m][n];
    }
}
