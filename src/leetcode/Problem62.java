package leetcode;

public class Problem62 {
    // 62 / 62 test cases passed.
    //Status: Accepted
    //Runtime: 0 ms
    // Your runtime beats 100.00 % of java submissions.
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[n - 1][m - 1];
    }

    // https://leetcode.com/problems/unique-paths/discuss/22981/My-AC-solution-using-formula
    // 没试，很棒
    public int uniquePaths2(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;
    }
}
