package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem840 {
    private static boolean[][] cantBeCenter;


    // 5ms
    // 中间方格一定为5，如果有不是1-9的值，周围9格全都不可能是中间方格。（tips:直接暴力解决不用cantBeCenter也可以）
    // 循环判断是否可能为中间方格，如果可能，探周围8个格子为1-9（否则cantBeCenter置true），再判断8条线是否和为15。
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        cantBeCenter = new boolean[row][col];

        for (int r = 1; r < row - 1; r++) {
            for (int c = 1; c < col - 1; c++) {
                if (cantBeCenter[r][c]) {
                    continue;
                }
                if (grid[r][c] != 5) {
                    cantBeCenter[r][c] = true;
                    if (isOverFlow(grid, r, c)) {
                        c++;
                    }
                } else {
                    if (isMagicSquares(grid, r, c)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isMagicSquares(int[][] grid, int r, int c) {
        List<Integer> list = new ArrayList<>();
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (isOverFlow(grid, i, j)) {
                    return false;
                }
                if (list.contains(grid[i][j])) {
                    return false;
                } else {
                    list.add(grid[i][j]);
                }
            }
        }
        return list.get(0) + list.get(1) + list.get(2) == 15 &&
                list.get(3) + list.get(4) + list.get(5) == 15 &&
                list.get(6) + list.get(7) + list.get(8) == 15 &&
                list.get(0) + list.get(3) + list.get(6) == 15 &&
                list.get(1) + list.get(4) + list.get(7) == 15 &&
                list.get(2) + list.get(5) + list.get(8) == 15 &&
                list.get(0) + list.get(4) + list.get(8) == 15 &&
                list.get(2) + list.get(4) + list.get(6) == 15;
    }

    private static boolean isOverFlow(int[][] grid, int r, int c) {
        if (grid[r][c] > 9 || grid[r][c] < 1) {
            for (int i = r - 1; i <= r + 1 && i >= 0 && i < grid.length; i++) {
                for (int j = c - 1; j <= c + 1 && j >= 0 && j < grid[0].length; j++) {
                    cantBeCenter[i][j] = true;
                }
            }
            return true;
        }
        return false;
    }
}
