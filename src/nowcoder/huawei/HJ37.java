package nowcoder.huawei;

import java.util.Scanner;

public class HJ37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] rst = new int[32];
        rst[1] = 1;
        rst[2] = 1;
        for (int i = 3; i <= n; i++) {
            rst[i] = rst[i - 1] + rst[i - 2];
        }
        System.out.println(rst[n]);
    }
}
