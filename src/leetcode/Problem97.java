package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 15:50
 **/
public class Problem97 {
    public static void main(String[] args) {
        System.out.println(new Problem97().isInterleave2("aabcc", "dbbca", "aadbbcbcac"));
    }

    // Runtime: 3 ms, faster than 65.40% of Java online submissions for Interleaving String.
    //Memory Usage: 37 MB, less than 5.81% of Java online submissions for Interleaving String.
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] isInterLeave = new boolean[s1.length() + 1][s2.length() + 1];
        isInterLeave[0][0] = true;
        for (int len = 1; len <= s3.length(); len++) {
            for (int i = 0; i <= s1.length() && i <= len; i++) {
                int j = len - i;
                if (j > s2.length())
                    continue;
                if (i == 0) {
                    isInterLeave[i][j] = isInterLeave[i][j - 1] && s2.charAt(j - 1) == s3.charAt(len - 1);
                } else if (j == 0) {
                    isInterLeave[i][j] = isInterLeave[i - 1][j] && s1.charAt(i - 1) == s3.charAt(len - 1);
                } else {
                    isInterLeave[i][j] = (isInterLeave[i][j - 1] && s2.charAt(j - 1) == s3.charAt(len - 1))
                            || (isInterLeave[i - 1][j] && s1.charAt(i - 1) == s3.charAt(len - 1));
                }
            }
        }
        return isInterLeave[s1.length()][s2.length()];
    }


    // Approach 4: Using 1D Dynamic Programming
    // https://leetcode.com/problems/interleaving-string/solution/
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}
