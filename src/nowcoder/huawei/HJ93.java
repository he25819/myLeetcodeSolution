package nowcoder.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ93 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int a : array) {
                if (a % 5 == 0)
                    sum += a;
                else if (a % 3 == 0)
                    sum -= a;
                else
                    list.add(a);
            }
            System.out.println(backtrace(list, sum));
        }
    }

    private static boolean backtrace(List<Integer> list, int sum) {
        if (list.size() == 0)
            return sum == 0;
        int a = list.remove(list.size() - 1);
        if (backtrace(list, sum + a) || backtrace(list, sum - a)) {
            return true;
        } else {
            list.add(a);
            return false;
        }
    }
}
