package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem87 {
    public static void main(String[] args) {
//        System.out.println(new Problem87().isScramble("abcde", "dbcae"));
//        System.out.println(new Problem87().isScramble("abcdefghijk", "kbcdajhiegf"));

//        String s1 = "abcdefghijklmnopqrstuvwxyz";
//        String s1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        String s1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
//        String s1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        List<Character> list = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            list.add(c);
        }
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        String s2 = sb.toString();
        // 此s2用第二个方法最快，方法2最稳定
//        String s2 = "zyxwvutsrqponmlkjihgfedcba";
//        String s2 = "zyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcba";
//        String s2 = "amzmoyjxscmqlodijqtibedpwlzkcvvrfsbjuhxzvnorulrbiiyhtbxwkvxrnrnutgwcfaoqftjhemushwltxgshdeqzwjfpgnknbcsyaiegodkpuqaveyplcgkpyzdmfa";
//        String s2 = "zyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcba";
//        String s2 = "zyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcba";
        System.out.println(s1);
        System.out.println(s2);
        long t1, t2;
        for (int i = 0; i < 3; i++) {
            t1 = System.currentTimeMillis();
            System.out.print(new Problem87().isScramble(s1, s2));
            t2 = System.currentTimeMillis();
            System.out.printf(" isScramble time: %dms\n", t2 - t1);
        }

        for (int i = 0; i < 3; i++) {
            t1 = System.currentTimeMillis();
            System.out.print(new Problem87().isScramble2(s1, s2));
            t2 = System.currentTimeMillis();
            System.out.printf(" isScramble2 time: %dms\n", t2 - t1);
        }

        for (int i = 0; i < 3; i++) {
            t1 = System.currentTimeMillis();
            System.out.print(new Problem87().isScramble3(s1, s2));
            t2 = System.currentTimeMillis();
            System.out.printf(" isScramble3 time: %dms\n", t2 - t1);
        }

        for (int i = 0; i < 3; i++) {
            t1 = System.currentTimeMillis();
            System.out.print(new Problem87().isScramble4(s1, s2));
            t2 = System.currentTimeMillis();
            System.out.printf(" isScramble4 time: %dms\n", t2 - t1);
        }
    }

    // Runtime: 13 ms, faster than 23.94% of Java online submissions for Scramble String.
    //Memory Usage: 40.6 MB, less than 6.52% of Java online submissions for Scramble String.
    // 速度慢因为循环次数多，所有应该优化，dp用Integer，递归计算，要什么算什么，而不是全部计算，==null说明第一次计算，否则已经算过了。
    // 据此优化写了isScramble3(s1,s2)
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0)
            return false;
        int[] chs = new int[26];
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            chs[s1.charAt(i) - 'a']++;
            chs[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != 0)
                return false;
        }

        // [index1][index2][length]
        boolean[][][] dp = new boolean[length][length][length + 1];
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                for (int j = 0; j <= length - len; j++) {
                    if (len == 1) {
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    boolean flag = false;
                    for (int k = 1; k < len; k++) {
                        flag = (dp[i][j][k] && dp[i + k][j + k][len - k])
                                || (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                        if (flag)
                            break;
                    }
                    dp[i][j][len] = flag;
                }
            }
        }

        return dp[0][0][length];
    }

    // sample 2 ms submission
    public boolean isScramble2(String s1, String s2) {
        if( s1.equals(s2) )
            return true;
        int s1Array[] = new int[26];
        int s2Array[] = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++)
            if( s1Array[i] != s2Array[i] )
                return false;
        for(int i = 1; i < s1.length(); i++) {
            if( isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)) )
                return true;
            if( isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s1.length() - i)))
                return true;
        }
        return false;
    }

    // Runtime: 4 ms, faster than 58.51% of Java online submissions for Scramble String.
    //Memory Usage: 39.4 MB, less than 47.83% of Java online submissions for Scramble String.
    // 最稳定健壮的解
    public boolean isScramble3(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0)
            return false;
        int[] chs = new int[26];
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            chs[s1.charAt(i) - 'a']++;
            chs[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != 0)
                return false;
        }

        // [index1][index2][length]
        Integer[][][] dp = new Integer[length][length][length + 1];
        helper(s1, s2, 0, 0, length, dp);
        return dp[0][0][length] == 1;
    }

    private boolean helper(String s1, String s2, int i1, int i2, int length, Integer[][][] dp) {
        int tmpCount = 0;
        if (dp[i1][i2][length] != null) {
//            tmpCount++;
//            System.out.print("1");
            return dp[i1][i2][length] == 1;
        }
        if (length == 1) {
            dp[i1][i2][length] = s1.charAt(i1) == s2.charAt(i2) ? 1 : 0;
            return dp[i1][i2][length] == 1;
        }
        boolean flag = false;
        for (int k = 1; k < length; k++) {
            flag = (helper(s1, s2, i1, i2, k, dp) && helper(s1, s2, i1 + k, i2 + k, length - k, dp))
                    || (helper(s1, s2, i1, i2 + length - k, k, dp) && helper(s1, s2, i1 + k, i2, length - k, dp));
            if (flag) {
                dp[i1][i2][length] = 1;
                return true;
            }
        }
        dp[i1][i2][length] = 0;
        return false;
    }





    // https://leetcode.com/problems/scramble-string/discuss/765385/Easy-understandable-3d-DP-Solution.
    // 数据大了很慢！
    public boolean isScramble4(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        Integer[][][] dp = new Integer[n + 1][n + 1][n + 1];
        return 1 == helper2(s1.toCharArray(), 0, s2.toCharArray(), 0, n, dp);
    }

    private int helper2(char[] s1, int lo1, char[] s2, int lo2, int len, Integer[][][] dp) {
        if (len == 1) {
            return s1[lo1] == s2[lo2] ? 1 : 0;
        }

        if (dp[lo1][lo2][len] != null) return dp[lo1][lo2][len];

        for (int i = 1; i < len; i++) {

            int lpart = helper2(s1, lo1, s2, lo2, i, dp);
            int rpart = helper2(s1, lo1 + i, s2, lo2 + i, len - i, dp);
            int swaplpart = helper2(s1, lo1, s2, lo2 + len - i, i, dp);
            int swaprpart = helper2(s1, lo1 + i, s2, lo2, len - i, dp);

            if (1 == lpart && 1 == rpart) {
                return dp[lo1][lo2][len] = 1;
            }
            if (1 == swaplpart && 1 == swaprpart) {
                return dp[lo1][lo2][len] = 1;
            }
        }

        return dp[lo1][lo2][len] = 0;
    }
}
