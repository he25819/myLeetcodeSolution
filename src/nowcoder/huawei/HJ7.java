package nowcoder.huawei;

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            double a = in.nextDouble();

            System.out.println(Math.round(a));
        }
    }
}
