package leetcode;

public class Problem832 {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        new Problem832().flipAndInvertImage(A);
    }

    // 4ms
    public int[][] flipAndInvertImage(int[][] A) {
        int cols = A[0].length;
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < (cols + 1) / 2; c++) {
                swapAndInvert(A[r], c, cols - c - 1);
            }
        }
        return A;
    }

    private void swapAndInvert(int[] a, int i, int j) {
        if (i == j) {
            a[i] = a[i] ^ 1;
            return;
        }
        int tmp = a[i];
        a[i] = a[j] ^ 1;
        a[j] = tmp ^ 1;
    }
}
