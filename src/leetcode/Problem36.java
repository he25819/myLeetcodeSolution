package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-13 11:35
 **/
public class Problem36 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
    //Memory Usage: 39.3 MB, less than 11.75% of Java online submissions for Valid Sudoku.
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVisited = new boolean[9][9];
        boolean[][] colVisited = new boolean[9][9];
        boolean[][] squareVisited = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int lessNum = board[i][j] - '1';
                if (rowVisited[i][lessNum])
                    return false;
                if (colVisited[j][lessNum])
                    return false;
                if (squareVisited[3*(i/3)+j/3][lessNum])
                    return false;
                rowVisited[i][lessNum] = true;
                colVisited[j][lessNum] = true;
                squareVisited[3*(i/3)+j/3][lessNum] = true;
            }
        }
        return true;
    }
}
