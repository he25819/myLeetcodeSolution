package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-22 17:53
 **/
public class Problem115 {
    public static void main(String[] args) {
        System.out.println(new Problem115().numDistinct("ababb", "ab"));
    }

    /* test cases
    "rabbbit"
"rabbit"
"ababb"
"ab"
""
""
"a"
"b"
"abababaabbbbbaabaccabab"
"ab"
"ababb"
"aba"
"ababb"
"abab"
"ababb"
"abb"
     */

    // Runtime: 7 ms, faster than 44.99% of Java online submissions for Distinct Subsequences.
    //Memory Usage: 39.4 MB, less than 5.65% of Java online submissions for Distinct Subsequences.
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return 0;
        int[][] nums = new int[s.length() + 1][t.length() + 1];
        nums[0][0] = 1;
        int firstTimes = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == t.charAt(0))
                firstTimes++;
            nums[i][1] = firstTimes;
        }
        for (int j = 2; j <= t.length(); j++) {
            for (int i = j; i <= s.length(); i++) {
                nums[i][j] = nums[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    nums[i][j] += nums[i - 1][j - 1];
            }
        }
        return nums[s.length()][t.length()];
    }
}
