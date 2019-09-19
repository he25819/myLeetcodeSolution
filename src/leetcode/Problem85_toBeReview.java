package leetcode;

public class Problem85_toBeReview {

    //Runtime: 4 ms, faster than 96.86% of Java online submissions for Maximal Rectangle.
    //Memory Usage: 42.7 MB, less than 89.13% of Java online submissions for Maximal Rectangle.
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        // heights[r][c] 代表以r行为底，c列柱子的高度
        int[][] heights = new int[row][col];
        for (int j = 0; j < col; j++)
            heights[0][j] = matrix[0][j] == '1' ? 1 : 0;
        for (int i = 1; i < row; i++)
            for (int j = 0; j < col; j++)
                heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i - 1][j] + 1;

        for (int i = 0; i < row; i++)
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));
        return maxArea;
    }

    //copy from Problem84
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];

        lessFromLeft[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }

        lessFromRight[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }
}