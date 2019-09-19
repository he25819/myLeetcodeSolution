package leetcode;

public class Problem661 {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new Problem661().imageSmoother(M);
    }
    public int[][] imageSmoother(int[][] M) {
        int width = M[0].length;
        int height = M.length;
        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int sum = 0;
                int count = 0;
                boolean isTopSide = i == 0;
                boolean isBottomSide = i == height - 1;
                boolean isLeftest = j == 0;
                boolean isRightest = j == width - 1;
                for (int x = isTopSide ? i : i - 1; x <= (isBottomSide ? i : i + 1); x++) {
                    for (int y = isLeftest ? j : j - 1; y <= (isRightest ? j : j + 1); y++) {
                        sum += M[x][y];
                        count++;
                    }
                }
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
