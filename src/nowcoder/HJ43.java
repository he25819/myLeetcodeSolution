package nowcoder;

import java.util.Scanner;

public class HJ43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] maze = new int[m][n];
        int[][] destination = new int[m][n];
        // 1 2 3 4 = 上 右 下 左
        int[][] direction = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = in.nextInt();
                destination[i][j] = Integer.MAX_VALUE;
            }
        }

        int i = m - 1, j = n - 1;
        dfs(maze, i, j, destination, 0, direction, 0);
        i = 0;
        j = 0;
        while ((i != m - 1) || (j != n - 1)) {
            System.out.printf("(%d,%d)\n", i, j);
            if (direction[i][j] == 1)
                i--;
            else if (direction[i][j] == 2)
                j++;
            else if (direction[i][j] == 3)
                i++;
            else if (direction[i][j] == 4)
                j--;
        }
        System.out.printf("(%d,%d)\n", i, j);
    }

    private static void dfs(int[][] maze, int i, int j, int[][] destination, int des, int[][] direction, int dir) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == 1)
            return;
        if (des >= destination[0][0])
            return;
        if (des < destination[i][j]) {
            destination[i][j] = des;
            direction[i][j] = dir;

            dfs(maze, i - 1, j, destination, des + 1, direction, 3);
            dfs(maze, i, j + 1, destination, des + 1, direction, 4);
            dfs(maze, i + 1, j, destination, des + 1, direction, 1);
            dfs(maze, i, j - 1, destination, des + 1, direction, 2);
        }
    }
}
