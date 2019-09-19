package leetcode;

public class Problem794 {
    public static void main(String[] args) {
        String[] input = {"XO ", "XO ", "XO "};
        String[] input2 = {"XXX", "OOX", "OOX"};
        String[] input3 = {"XXX", "XOO", "OO "};
        String[] input4 = {"XX ", "OOO", "XX "};
        String[] input5 = {"XOX","OX ","OXO"};
        System.out.println(new Problem794().validTicTacToe(input5));
    }

    // 108 / 108 test cases passed.
    //Status: Accepted
    //Runtime: 5 ms
    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X')
                    countX++;
                else if (board[i].charAt(j) == 'O')
                    countO++;
            }
        }
        if (countX < countO || countX - countO > 1)
            return false;

        int countXWin = 0, countOWin = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("XXX"))
                countXWin++;
            else if (board[i].equals("OOO"))
                countOWin++;

            char tmp = board[0].charAt(i);
            if (tmp == 'X' || tmp == 'O') {
                for (int j = 0; j < 3; j++) {
                    if (board[j].charAt(i) != tmp)
                        break;
                    if (j == 2)
                        if (tmp == 'X')
                            countXWin++;
                        else if (tmp == 'O')
                            countOWin++;
                }

                if (i == 0 && board[1].charAt(1) == tmp && board[2].charAt(2) == tmp)
                    if (tmp == 'X')
                        countXWin++;
                    else if (tmp == 'O')
                        countOWin++;
                if (i == 2 && board[1].charAt(1) == tmp && board[2].charAt(0) == tmp)
                    if (tmp == 'X')
                        countXWin++;
                    else if (tmp == 'O')
                        countOWin++;
            }
        }

        if (countXWin > 0 && countOWin == 0 && countX - countO == 1)
            return true;
        if (countXWin == 0 && countOWin == 1 && countX == countO)
            return true;
        return countXWin + countOWin == 0;
    }

    // sample 4 ms submission
    public boolean validTicTacToe2(String[] board) {
        int turns = 0;
        boolean xwin = false;
        boolean owin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++; rows[i]++; cols[j]++;
                    if (i == j) diag++;
                    if (i + j == 2) antidiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--; rows[i]--; cols[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                diag == 3 || antidiag == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                diag == -3 || antidiag == -3;

        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }
}
