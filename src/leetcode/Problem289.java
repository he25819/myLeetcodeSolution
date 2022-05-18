package leetcode;

public class Problem289 {

    // Runtime: 1 ms, faster than 44.57% of Java online submissions for Game of Life.
    //Memory Usage: 42.5 MB, less than 28.52% of Java online submissions for Game of Life.
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int n = count(copy, i, j);
                if (n < 2)
                    board[i][j] = 0;
                else if (n == 3)
                    board[i][j] = 1;
                else if (n > 3)
                    board[i][j] = 0;
            }
        }
    }

    private int count(int[][] copy, int i, int j) {
        int count = -copy[i][j];
        for (int m = i - 1; m <= i + 1; m++) {
            for (int n = j - 1; n <= j + 1; n++) {
                if (m >= 0 && m < copy.length && n >= 0 && n < copy[0].length)
                    count += copy[m][n];
            }
        }
        return count;
    }
}
