package leetcode;

public class Problem59 {
    // 用和Problem54的方法一样。
    // 20 / 20 test cases passed.
    //Status: Accepted
    //Runtime: 2 ms
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];
        int k = 1;
        int i = 0, j = 0;

        isVisited[i][j] = true;
        result[i][j] = k++;
        while (k <= n * n) {
            while ((j + 1) < n && !isVisited[i][j + 1]) {
                result[i][++j] = k++;
                isVisited[i][j] = true;
            }
            while ((i + 1) < n && !isVisited[i + 1][j]) {
                result[++i][j] = k++;
                isVisited[i][j] = true;
            }
            while ((j - 1) >= 0 && !isVisited[i][j - 1]) {
                result[i][--j] = k++;
                isVisited[i][j] = true;
            }
            while ((i - 1) >= 0 && !isVisited[i - 1][j]) {
                result[--i][j] = k++;
                isVisited[i][j] = true;
            }
        }
        return result;
    }
}
