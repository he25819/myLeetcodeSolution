package leetcode;

public class Problem63 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        new Problem63().uniquePathsWithObstacles(grid);
    }

    // 43 / 43 test cases passed.
    //Status: Accepted
    //Runtime: 0 ms
    // Your runtime beats 100.00 % of java submissions.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[0].length; j++) {
                if (i == 0 && j == 0)
                    paths[i][j] = 1;
                else if (obstacleGrid[i][j] == 1)
                    paths[i][j] = 0;
                else
                    paths[i][j] = (i > 0 ? paths[i - 1][j] : 0) + (j > 0 ? paths[i][j - 1] : 0);
            }
        }
        return paths[paths.length - 1][paths[0].length - 1];
    }

    // from Solution
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }
}
