package leetcode;

import java.util.Stack;

public class Problem695 {
    int[][] grid;
    boolean[][] flagGrid;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        this.grid = grid;
        this.flagGrid = new boolean[height][width];

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }
        return result;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || flagGrid[i][j]) {
            return 0;
        }
        flagGrid[i][j] = true;

        return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
    }


    // Approach #2: Depth-First Search (Iterative) [Accepted]
    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !seen[r][c]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r, c});
                    seen[r][c] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int r2 = node[0] + dr[k];
                            int c2 = node[1] + dc[k];
                            if (r2 >= 0 && r2 < grid.length && c2 >= 0 && c2 < grid[0].length && grid[r2][c2] == 1 && !seen[r2][c2]) {
                                stack.push(new int[]{r2, c2});
                                seen[r2][c2] = true;
                            }
                        }
                    }
                    result = Math.max(result, shape);
                }
            }
        }
        return result;
    }
}
