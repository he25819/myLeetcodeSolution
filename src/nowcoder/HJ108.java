package nowcoder;

import java.util.Scanner;

public class HJ108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int facBoth = 1;
            int facA = 1;
            outer: while (true) {
                double sqrtA = Math.sqrt(a);
                for (int i = 2; i <= a; i++) {
                    if (i > sqrtA)
                        i = a;
                    if (a % i == 0) {
                        if (b % i == 0) {
                            facBoth *= i;
                            a /= i;
                            b /= i;
                        } else {
                            facA *= i;
                            a /= i;
                        }
                        continue outer;
                    }
                }
                break;
            }
            System.out.println(facBoth * facA * a * b);
        }
    }
}
