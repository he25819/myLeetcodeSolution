package leetcode;

public class Problem5 {
    public static void main(String[] args) {
        new Problem5().longestPalindrome("abbab");
    }

    // Runtime: 82 ms, faster than 36.27% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 42.4 MB, less than 6.86% of Java online submissions for Longest Palindromic Substring.
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int l = 0, r = 0;
        char[] chars = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int d = 0; d < s.length(); d++) {
            for (int i = 0; i < s.length() - d; i++) {
                if (d == 0)
                    isPalindrome[i][i + d] = true;
                else if (d == 1)
                    isPalindrome[i][i + 1] = chars[i] == chars[i + 1];
                else
                    isPalindrome[i][i + d] = isPalindrome[i + 1][i + d - 1] && chars[i] == chars[i + d];
                if (isPalindrome[i][i + d] && r - l < d) {
                    l = i;
                    r = i + d;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
