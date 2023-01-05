package nowcoder.huawei;

import java.util.Scanner;

// 同leetcode37
public class HJ44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] sudoku = new int[9][9];

        boolean[][] rowContains = new boolean[9][10];
        boolean[][] colContains = new boolean[9][10];
        boolean[][] boxContains = new boolean[9][10];

        int i = 0, j = 0;
        while (i < 9) {
            sudoku[i][j] = in.nextInt();
            rowContains[i][sudoku[i][j]] = true;
            colContains[j][sudoku[i][j]] = true;
            boxContains[i / 3 * 3 + j / 3][sudoku[i][j]] = true;
            j = (j + 1) % 9;
            i = j == 0 ? i + 1 : i;
        }

        backtrace(sudoku, 0, 0, rowContains, colContains, boxContains);

        for (i = 0; i < 9; i++) {
            System.out.print(sudoku[i][0]);
            for (j = 1; j < 9; j++)
                System.out.printf(" %d", sudoku[i][j]);
            System.out.println();
        }
    }

    private static boolean backtrace(int[][] sudoku, int i, int j, boolean[][] rowContains, boolean[][] colContains, boolean[][] boxContains) {
        if (i == 9)
            return true;
        int nextJ = (j + 1) % 9;
        int nextI = nextJ == 0 ? i + 1 : i;
        if (sudoku[i][j] != 0) {
            return backtrace(sudoku, nextI, nextJ, rowContains, colContains, boxContains);
        }

        for (int n = 1; n <= 9; n++) {
            if (!rowContains[i][n] && !colContains[j][n] && !boxContains[i / 3 * 3 + j / 3][n]) {
                sudoku[i][j] = n;
                rowContains[i][n] = true;
                colContains[j][n] = true;
                boxContains[i / 3 * 3 + j / 3][n] = true;
                if (backtrace(sudoku, nextI, nextJ, rowContains, colContains, boxContains)) {
                    return true;
                } else {
                    sudoku[i][j] = 0;
                    rowContains[i][n] = false;
                    colContains[j][n] = false;
                    boxContains[i / 3 * 3 + j / 3][n] = false;
                }
            }
        }
        return false;
    }
}
