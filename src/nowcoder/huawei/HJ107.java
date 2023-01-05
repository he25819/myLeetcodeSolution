package nowcoder.huawei;

import java.util.Scanner;

public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            double v = in.nextDouble();

            if (v > 1)
                System.out.printf("%.1f\n", sqrt(v, 1, v));
            else if (0 <= v && v <= 1)
                System.out.printf("%.1f\n", sqrt(v, 0, 1));
            else if (-1 <= v && v < 0)
                System.out.printf("%.1f\n", sqrt(v, -1, 0));
            else
                System.out.printf("%.1f\n", sqrt(v, v, -1));
        }
    }

    private static double sqrt(double v, double l, double r) {
        double m = (l + r) / 2;
        if (Math.abs(m * m * m - v) < 0.0001) {
            return m;
        }
        if (m * m * m > v) {
            return sqrt(v, l, m);
        } else {
            return sqrt(v, m, r);
        }
    }
}
