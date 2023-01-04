package nowcoder;

import java.util.Scanner;

public class HJ55 {
    // 7 14 17 21 27 28 35 37 42 47 49
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();

            int count = 0;
            for (int i = 17; i <= n; i++) {
                if (i % 7 == 0)
                    continue;
                int x = i;
                while (x > 0) {
                    if (x % 10 == 7) {
                        count++;
                        break;
                    }
                    x /= 10;
                }
            }

            count += n / 7;
            System.out.println(count);
        }
    }
}
