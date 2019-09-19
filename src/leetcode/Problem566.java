package leetcode;

public class Problem566 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}};
        new Problem566().matrixReshape(nums, 1, 6);
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldR = nums.length;
        int oldC = nums[0].length;
        if (oldR * oldC != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int index = r * c;
        for (int i = 0; i < index; i++) {
            result[i / c][i % c] = nums[i / oldC][i % oldC];
        }
        return result;
    }
}
