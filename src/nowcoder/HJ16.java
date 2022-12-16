package nowcoder;

import java.util.Scanner;

public class HJ16 {
    // 提交结果：答案正确 运行时间：63ms 占用内存：11796KB 使用语言：Java
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int money = in.nextInt() / 10;
            int lines = in.nextInt();

            Item[] items = new Item[lines + 1];
            for (int i = 1; i <= lines; i++) {
                items[i] = new Item(in.nextInt() / 10, in.nextInt(), in.nextInt());
            }
            for (int i = 1; i <= lines; i++) {
                if (items[i].q > 0) {
                    if (items[items[i].q].a0 != null)
                        items[items[i].q].a1 = items[i];
                    else
                        items[items[i].q].a0 = items[i];
                    items[i] = null;
                }
            }

            int[][] dp = new int[lines + 1][money + 1];
            // dp[i][m] = max(dp[i][j - 1], dp[i - 1][m], dp[i - 1][m - item.v] + item.v*item.p)
            for (int i = 1; i <= lines; i++) {
                for (int j = 1; j <= money; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    if (items[i] != null) {
                        if (j - items[i].v >= 0) {
                            // item
                             dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v] + items[i].v * items[i].p);
                            if (items[i].a0 != null && j - items[i].v - items[i].a0.v >= 0) {
                                // item + a0
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v - items[i].a0.v] + items[i].v * items[i].p + items[i].a0.v * items[i].a0.p);
                            }
                            if (items[i].a1 != null && j - items[i].v - items[i].a1.v >= 0) {
                                // item + a1
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v - items[i].a1.v] + items[i].v * items[i].p + items[i].a1.v * items[i].a1.p);
                                if (j - items[i].v - items[i].a0.v - items[i].a1.v >= 0)
                                    // item + a0 + a1
                                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v - items[i].a0.v - items[i].a1.v] + items[i].v * items[i].p + items[i].a0.v * items[i].a0.p + items[i].a1.v * items[i].a1.p);
                            }
                        }
                    }
                }
            }
            System.out.println(dp[lines][money] * 10);
        }
    }

    private static class Item {
        int v;
        int p;
        int q;

        Item a0;
        Item a1;

        Item(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }
    }
}
