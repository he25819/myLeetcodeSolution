package leetcode;

public class Problem867 {
    public int[][] transpose(int[][] A) {
        int newRow = A[0].length;
        int newCol = A.length;

        int[][] result = new int[newRow][newCol];

        for (int i = 0; i < newCol; i++) {
            for (int j = 0; j < newRow; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
