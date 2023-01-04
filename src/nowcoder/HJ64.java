package nowcoder;

import java.util.Scanner;

public class HJ64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            String s = in.nextLine();

            int top = 0;
            int bottom = Math.min(n - 1, 3);
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'D')
                    cur = (cur + 1) % n;
                else    // 'U'
                    cur = (cur - 1 + n) % n;

                if (cur > bottom) {
                    if (cur == n - 1) {
                        bottom = n - 1;
                        top = Math.max(0, bottom - 3);
                    } else {
                        top++;
                        bottom++;
                    }
                } else if (cur < top) {
                    if (cur == 0) {
                        top = 0;
                        bottom = Math.min(n - 1, 3);
                    } else {
                        top--;
                        bottom--;
                    }
                }
            }
            System.out.print(top + 1);
            for (int i = top + 2; i <= bottom + 1; i++)
                System.out.printf(" %d", i);
            System.out.println();
            System.out.println(cur + 1);
        }
    }
}
