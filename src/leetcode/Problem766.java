package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem766 {
    // 21ms
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = Math.min(rows, cols);

        for (int y = 0; y < cols - 1; y++) {
            int tmp = matrix[0][y];
            for (int n = 1; n < min && y + n < cols; n++) {
                if (matrix[n][y + n] != tmp) {
                    return false;
                }
            }
        }
        for (int x = 1; x < rows - 1; x++) {
            int tmp = matrix[x][0];
            for (int n = 1; n < min && x + n < rows; n++) {
                if (matrix[x + n][n] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }


    // 16ms
    public boolean isToeplitzMatrix2(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    //18 ms
    public boolean isToeplitzMatrix3(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!groups.containsKey(r - c)) {
                    groups.put(r - c, matrix[r][c]);
                } else if (matrix[r][c] != groups.get(r - c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
