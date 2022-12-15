package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ6 {
    // 提交结果：答案正确 运行时间：41ms 占用内存：10896KB 使用语言：Java
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            List<Integer> fac = new ArrayList<>();
            while (n % 2 == 0) {
                fac.add(2);
                n >>= 1;
            }
            int a = 3;
            while (a * a <= n) {
                if (n % a == 0) {
                    fac.add(a);
                    n /= a;
                } else
                    a += 2;
            }
            if (a > 1)
                fac.add(n);
            for (int i = 0; i < fac.size(); i++) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(fac.get(i));
            }
            System.out.println();
        }
    }
}
