package leetcode;

public class Problem240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(new Problem240().searchMatrix(matrix, 19));;
    }
    // 任意矩形，左上角的一定是最小值，右下角的一定是最大值
    // 129 / 129 test cases passed.
    //Status: Accepted
    //Runtime: 8 ms
    // Your runtime beats 71.78 % of java submissions.
    // I used Binary Search & Divide and Conquer
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int R = matrix.length;
        int C = matrix[0].length;

        return searchMatrix(matrix, target, 0, 0, R - 1, C - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int i0, int j0, int i1, int j1) {
        if (i1 - i0 <= 3 && j1 - j0 <= 3) {
            for (int i = i0; i <= i1; i++)
                for (int j = j0; j <= j1; j++)
                    if (matrix[i][j] == target)
                        return true;
            return false;
        } else {
            int left = j0, right = j1, mid;
            while (left <= right) {
                mid = (left + right + 1) >> 1;
                if (matrix[i0][mid] < target)
                    left = mid + 1;
                else if (matrix[i0][mid] > target)
                    right = mid - 1;
                else
                    return true;
            }
            if (right < j0)
                return false;
            j1 = right;

            left = i0; // left = top, right = bottom.
            right = i1;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (matrix[mid][j1] < target)
                    left = mid + 1;
                else if (matrix[mid][j1] > target)
                    right = mid - 1;
                else
                    return true;
            }
            if (left > i1)
                return false;
            i0 = left;
            return searchMatrix(matrix, target, i0, j0, i1, j1);
        }
    }

    // 这个方法更巧妙，无需用二分法和分治法
    // https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66247/Java-short-code-O(m+n)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length, i=0, j=n-1;
        while (i<m && j>=0) {
            if (matrix[i][j]==target) return true;
            else if (matrix[i][j]<target) i++;
            else j--;
        }
        return false;
    }
}
