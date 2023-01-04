package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ67 {
    // 24点
    // 提交结果：答案正确 运行时间：61ms 占用内存：11056KB 使用语言：Java 用例通过率：100.00%
    // 5 9 7 1  true
    // 1 5 5 5  true
    // 8 8 8 8  false
    // 8 8 8 9  false
    // 这题难度定低了些，题解大部分都是错误的。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 4; i++)
                list.add(in.nextInt());

            boolean can24 = false;
            outer: for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int b = list.remove(j);
                    int a = list.remove(i);

                    if (backtrace(list, a + b, 24D)
                            || (a != b &&backtrace(list, a - b, 24D))
                            || backtrace(list, a * b, 24D)
                            || backtrace(list, (double) a / b, 24D)
                            || backtrace(list, (double) b / a, 24D)) {
                        can24 = true;
                        list.add(i, a);
                        list.add(j, b);
                        break outer;
                    }
                    list.add(i, a);
                    list.add(j, b);
                }
            }
            if (!can24) {
                for (int i = 0; i < 4; i++) {
                    int a = list.remove(i);
                    if (backtrace(list, a, 24D)) {
                        can24 = true;
                        break;
                    }
                    list.add(i, a);
                }
            }
            System.out.println(can24);
        }
    }

    private static boolean backtrace(List<Integer> list, double c, double target) {
        if (list.size() == 1) {
            int a = list.get(0);
            return Math.abs(a + c - target) < 0.0001
                    || Math.abs(a - c - target) < 0.0001
                    || Math.abs(c - a - target) < 0.0001
                    || Math.abs(a * c - target) < 0.0001
                    || Math.abs(a / c - target) < 0.0001
                    || Math.abs(c / a - target) < 0.0001;
        } else if (list.size() == 2) {
            int a = list.remove(1);
            if (backtrace(list, a, target + c)
                    || backtrace(list, a, target - c)
                    || backtrace(list, a, c - target)
                    || backtrace(list, a, target * c)
                    || backtrace(list, a, target / c)
                    || backtrace(list, a, c / target)) {
                list.add(a);
                return true;
            } else {
                list.add(a);
                return false;
            }
        } else {    // must be 3
            for (int i = 0; i < 3; i++) {
                int a = list.remove(i);
                if (backtrace(list, a, target + c)
                        || backtrace(list, a, target - c)
                        || backtrace(list, a, c - target)
                        || backtrace(list, a, target * c)
                        || backtrace(list, a, target / c)
                        || backtrace(list, a, c / target)) {
                    list.add(i, a);
                    return true;
                } else {
                    list.add(i, a);
                }
            }
            return false;
        }
    }
}
