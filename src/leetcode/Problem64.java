package leetcode;

public class Problem64 {
    // 61 / 61 test cases passed.
    //Status: Accepted
    //Runtime: 10 ms
    // Your runtime beats 12.43 % of java submissions.
    public int minPathSum(int[][] grid) {
        int preMin;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                preMin = i == 0 && j == 0 ? 0 : Math.min((i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE), (j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE));
                grid[i][j] += preMin;
            }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    // https://leetcode.com/problems/minimum-path-sum/discuss/23471/My-java-solution-using-DP-and-no-extra-space
    // 61 / 61 test cases passed.
    //Status: Accepted
    //Runtime: 5 ms
    // Your runtime beats 94.69 % of java submissions.
    public int minPathSum2(int[][] grid) {
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
