package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-30 11:46
 **/
public class Problem174 {
    /*
[[-2,-3,3],[-5,-10,1],[10,30,-5]]
[[1,1,1,-2],[1,1,1,-2],[1,1,1,-20]]
[[1]]
[[-5]]
     */

    public static void main(String[] args) {
        new Problem174().calculateMinimumHP(new int[][]{{1, 1, 1, -2}, {1, 1, 1, -2}, {1, 1, 1, -20}});
    }


    // Runtime: 1 ms, faster than 90.25% of Java online submissions for Dungeon Game.
    //Memory Usage: 39.1 MB, less than 10.62% of Java online submissions for Dungeon Game.
    // 题目少给一个条件，答案是在骑士只能往右、下前进的前提下做出的。
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 1;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m - 1; i++)
            dp[i][n] = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++)
            dp[m][i] = Integer.MAX_VALUE;
        dp[m - 1][n] = 1;
        dp[m][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max((Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]), 1);
            }
        }
        return dp[0][0];
    }
}
