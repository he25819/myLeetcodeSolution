package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    // 22 / 22 test cases passed.
    //Status: Accepted
    //Runtime: 1 ms
    // Your runtime beats 100.00 % of java submissions.
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int m = matrix.length, n = matrix[0].length;
        int sum = m * n;
        int i = 0, j = 0;
        boolean[][] isVisited = new boolean[m][n];


        result.add(matrix[i][j]);
        isVisited[i][j] = true;
        while (result.size() < sum) {
            while ((j + 1) < n && !isVisited[i][j + 1]) {
                result.add(matrix[i][++j]);
                isVisited[i][j] = true;
            }
            while ((i + 1) < m && !isVisited[i + 1][j]) {
                result.add(matrix[++i][j]);
                isVisited[i][j] = true;
            }
            while ((j - 1) >= 0 && !isVisited[i][j - 1]) {
                result.add(matrix[i][--j]);
                isVisited[i][j] = true;
            }
            while ((i - 1) >= 0 && !isVisited[i - 1][j]) {
                result.add(matrix[--i][j]);
                isVisited[i][j] = true;
            }
        }
        return result;
    }
}
