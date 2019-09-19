package leetcode;

public class Problem79 {
    // 87 / 87 test cases passed.
    //Status: Accepted
    //Runtime: 9 ms
    // Your runtime beats 84.38 % of java submissions.
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board == null || board.length < 1)
            return false;
        boolean[][] isUsed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (exist(board, isUsed, word, 0, i, j))
                    return true;

        return false;
    }

    private boolean exist(char[][] board, boolean[][] isUsed, String word, int index, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index) || isUsed[x][y])
            return false;
        if (word.length() == index + 1)
            return true;
        isUsed[x][y] = true;

        if (exist(board, isUsed, word, index + 1, x - 1, y))
            return true;
        if (exist(board, isUsed, word, index + 1, x, y - 1))
            return true;
        if (exist(board, isUsed, word, index + 1, x + 1, y))
            return true;
        if (exist(board, isUsed, word, index + 1, x, y + 1))
            return true;
        isUsed[x][y] = false;
        return false;
    }
}
