package leetcode;

public class Problem48 {
    // 21 / 21 test cases passed.
    //Status: Accepted
    //Runtime: 3 ms
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1)
            return;

        int sum = matrix.length - 1;
        for (int i = 0; i < sum; i++) {
            int remainI = sum - i;
            for (int j = i; j < remainI; j++) {
                int temp = matrix[i][j];
                int remainJ = sum - j;
                matrix[i][j] = matrix[remainJ][i];
                matrix[remainJ][i] = matrix[remainI][remainJ];
                matrix[remainI][remainJ] = matrix[j][remainI];
                matrix[j][remainI] = temp;
            }
        }
    }
}
