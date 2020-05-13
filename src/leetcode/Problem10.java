package leetcode;

import java.util.regex.Pattern;

public class Problem10 {
    public static void main(String[] args) {
        System.out.println(new Problem10().isMatch("a", "ab*"));
    }


    /* 测试用例
"aa"
"a"
"adg"
".*"
""
""
"aaaaaaaabbbbbbb"
"aa*a*a*a*.b*b.b*"
"abab"
"ab*bab"
"a"
"ab*"
    */
    // Runtime: 471 ms, faster than 5.03% of Java online submissions for Regular Expression Matching.
    //Memory Usage: 37.9 MB, less than 47.47% of Java online submissions for Regular Expression Matching.
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] strs = s.toCharArray();
        char[] patterns = p.toCharArray();

        return backtrack(strs, patterns, 0, 0);
    }

    private boolean backtrack(char[] strs, char[] patterns, int i, int j) {
        if (j >= patterns.length)
            return i == strs.length;
        if (i == strs.length)
            if (j + 1 < patterns.length && patterns[j + 1] == '*')
                return backtrack(strs, patterns, i, j + 2);
            else
                return false;

        if (j + 1 < patterns.length && patterns[j + 1] == '*') {
            if (strs[i] == patterns[j] || patterns[j] == '.') {
                return backtrack(strs, patterns, i + 1, j)
                        || backtrack(strs, patterns, i, j + 2)
                        || backtrack(strs, patterns, i + 1, j + 2);
            } else {
                return backtrack(strs, patterns, i, j + 2);
            }
        }
        if (strs[i] == patterns[j] || patterns[j] == '.') {
            return backtrack(strs, patterns, i + 1, j + 1);
        }
        return false;
    }


    // 应该正确，但是leetcode屏蔽了java.util.regex.Pattern
    public boolean isMatch2(String s, String p) {
        return Pattern.compile("^" + p + "$").matcher(s).matches();
    }
}