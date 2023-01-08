package nowcoder.nc;

import java.util.Scanner;

public class NC13134 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int[] before = new int[n];
            int[] after = new int[n];
            before[0] = 1;
            after[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i - 1])
                    before[i] = before[i - 1] + 1;
                else
                    before[i] = 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] < arr[i + 1])
                    after[i] = after[i + 1] + 1;
                else
                    after[i] = 1;
            }

            int maxLen = Math.min(2, n);
            for (int i = 1; i < n - 1; i++) {
                if (arr[i + 1] - arr[i - 1] >= 2)
                    maxLen = Math.max(maxLen, before[i - 1] + 1 + after[i + 1]);
            }
            System.out.println(maxLen);
        }
    }
}
