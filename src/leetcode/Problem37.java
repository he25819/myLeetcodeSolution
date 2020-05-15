package leetcode;

import java.util.*;

public class Problem37 {
    public static void main(String[] args) {
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Problem37().solveSudoku2(chars);
    }

    // Runtime: 58 ms, faster than 6.09% of Java online submissions for Sudoku Solver.
    //Memory Usage: 39.5 MB, less than 10.53% of Java online submissions for Sudoku Solver.
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        Set<Character>[][] possibleNums = new HashSet[board.length][board[0].length];
        List<GridInfo> gridInfos = new ArrayList<>();
        int remain = 81;

        List<Character> tempList = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    possibleNums[i][j] = new HashSet<>(tempList);
                } else {
                    possibleNums[i][j] = new HashSet<>();
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    refreshPossibleNumsByFillANum(possibleNums, i, j, board[i][j]);
                    remain--;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (possibleNums[i][j].size() != 0)
                    gridInfos.add(new GridInfo(i, j, possibleNums[i][j]));
            }
        }

        gridInfos.sort((o1, o2) -> o2.nums.size() - o1.nums.size());
        backtrack(board, gridInfos, possibleNums, remain);
    }

    private boolean backtrack(char[][] board, List<GridInfo> gridInfos, Set<Character>[][] possibleNums, int remaining) {
        if (remaining == 0)
            return true;
        GridInfo grid = gridInfos.remove(gridInfos.size() - 1);
        List<Character> candidates = new ArrayList<>(possibleNums[grid.i][grid.j]);
        for (Character c : candidates) {
            List<GridInfo> removedNums = testRemovePossibleNums(possibleNums, grid.i, grid.j, c);
            board[grid.i][grid.j] = c;
            if (backtrack(board, gridInfos, possibleNums, --remaining))
                return true;
            remaining++;
            board[grid.i][grid.j] = '.';
            revertRemovedNums(possibleNums, removedNums);
        }
        gridInfos.add(grid);
        return false;
    }

    private void revertRemovedNums(Set<Character>[][] possibleNums, List<GridInfo> removedNums) {
        for (GridInfo grid : removedNums) {
            possibleNums[grid.i][grid.j].add(grid.nums.iterator().next());
        }
    }

    private List<GridInfo> testRemovePossibleNums(Set<Character>[][] possibleNums, int i, int j, Character c) {
        List<GridInfo> removedNums = new ArrayList<>();
        for (int y = 0; y < 9; y++) {
            if (possibleNums[i][y].remove(c)) {
                removedNums.add(new GridInfo(i, y, Collections.singleton(c)));
            }
        }
        for (int x = 0; x < 9; x++) {
            if (possibleNums[x][j].remove(c)) {
                removedNums.add(new GridInfo(x, j, Collections.singleton(c)));
            }
        }
        for (int x = i / 3 * 3; x < i / 3 * 3 + 3; x++) {
            for (int y = j / 3 * 3; y < j / 3 * 3 + 3; y++) {
                if (possibleNums[x][y].remove(c)) {
                    removedNums.add(new GridInfo(x, y, Collections.singleton(c)));
                }
            }
        }
        return removedNums;
    }

    private void refreshPossibleNumsByFillANum(Set<Character>[][] possibleNums, int i, int j, Character c) {
        for (int y = 0; y < 9; y++) {
            possibleNums[i][y].remove(c);
        }
        for (int x = 0; x < 9; x++) {
            possibleNums[x][j].remove(c);
        }
        for (int x = i / 3 * 3; x < i / 3 * 3 + 3; x++)
            for (int y = j / 3 * 3; y < j / 3 * 3 + 3; y++)
                possibleNums[x][y].remove(c);
    }

    private static class GridInfo{
        private int i;
        private int j;
        Set<Character> nums;

        public GridInfo(int i, int j, Set<Character> nums) {
            this.i = i;
            this.j = j;
            this.nums = nums;
        }
    }


    /**
     * sample 2 ms submission
     * start
     */
    // Runtime: 2 ms, faster than 99.19% of Java online submissions for Sudoku Solver.
    //Memory Usage: 36.6 MB, less than 43.86% of Java online submissions for Sudoku Solver.

    //++ fb
    //time optimized
    public void solveSudoku2(char[][] board) {
        //corner case
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;

        int row = board.length, col = board[0].length;
        boolean[][] rowVisited = new boolean[row][col]; //rowVisited[0][1] : for row 0, did we use 2 or not;
        boolean[][] colVisited = new boolean[row][col]; //colVisited[0][1] : for col 0, did we use 2 or not;
        boolean[][] subboxVisited = new boolean[row][col]; //subboxVisited[0][1] : for subbox 0, did we use 2 or not;

        //pre-fill visited values
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowVisited[i][num-1] = true;
                    colVisited[j][num-1] = true;
                    subboxVisited[i/3*3+j/3][num-1] = true;
                }
            }
        }

        //从左到右，从上到下，一个一个的fill
        filling(board, 0, 0, rowVisited, colVisited, subboxVisited);
    }

    private boolean filling(char[][] board, int i, int j, boolean[][] rowVisited, boolean[][] colVisited, boolean[][] subboxVisited) {
        if (i >= 9) return true;

        int nj = (j+1) % 9;
        int ni = (nj == 0) ? i+1 : i;

        //如果当前不是空的,那么fill下一个位置
        if (board[i][j] != '.') return filling(board, ni, nj, rowVisited, colVisited, subboxVisited);
        //当前位置是空的,尝试所有可能的没有被visited过得value from 1-9
        for (int num = 1; num <= 9; num++) {
            if (!rowVisited[i][num-1] && !colVisited[j][num-1] && !subboxVisited[i/3*3+j/3][num-1]) {
                rowVisited[i][num-1] = colVisited[j][num-1] = subboxVisited[i/3*3+j/3][num-1] = true;
                board[i][j] = (char)(num+'0');
                //如果成功了返回true,不需要继续尝试下一个value
                if(filling(board, ni, nj, rowVisited, colVisited, subboxVisited)) return true;

                board[i][j] = '.';
                rowVisited[i][num-1] = colVisited[j][num-1] = subboxVisited[i/3*3+j/3][num-1] = false;
            }
        }
        return false;
    }
    /**
     * sample 2 ms submission
     * end
     */

}
