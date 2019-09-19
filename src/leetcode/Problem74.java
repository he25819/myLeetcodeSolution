package leetcode;

public class Problem74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        new Problem74().searchMatrix(matrix, 50);
    }

    // 136 / 136 test cases passed.
    //Status: Accepted
    //Runtime: 6 ms
    // Your runtime beats 97.71 % of java submissions.
    // binarySearch
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int R = matrix.length;
        int C = matrix[0].length;
        int sum = R * C;

        int left = 0, right = sum - 1, mid;
        int i, j;
        while (left <= right) {
            mid = (left + right) / 2;
            i = mid / C;
            j = mid - i * C;
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
