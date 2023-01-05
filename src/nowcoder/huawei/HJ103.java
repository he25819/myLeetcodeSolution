package nowcoder.huawei;

import java.util.Scanner;

public class HJ103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = in.nextInt();
            }
            int[] maxLen = new int[n];
            maxLen[0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    maxLen[i] = Math.max(1, maxLen[i]);
                    if (heights[i] > heights[j]) {
                        maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++)
                max = Math.max(max, maxLen[i]);
            System.out.println(max);
        }
    }
}
