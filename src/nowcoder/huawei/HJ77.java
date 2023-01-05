package nowcoder.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ77 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] trains = new int[n];
            for (int i = 0; i < n; i++) {
                trains[i] = in.nextInt();
            }

            int i = 0;
            List<Integer> outList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            List<String> rst = new ArrayList<>();
            backtrace(stack, outList, trains, i, rst);
            rst.sort(String::compareTo);

            for (String s : rst) {
                System.out.println(s);
            }
        }
    }

    private static void backtrace(Stack<Integer> stack, List<Integer> outList, int[] trains, int i, List<String> rst) {
        if (stack.size() + outList.size() == trains.length) {
            StringBuilder sb = new StringBuilder();
            for (Integer o : outList) {
                sb.append(' ').append(o);
            }
            Stack<Integer> clone = (Stack<Integer>) stack.clone();
            while (!clone.empty()) {
                sb.append(' ').append(clone.pop());
            }
            sb.deleteCharAt(0);
            rst.add(sb.toString());
            return;
        }
        if (!stack.empty()) {
            outList.add(stack.pop());
            backtrace(stack, outList, trains, i, rst);
            stack.push(outList.remove(outList.size() - 1));
        }
        stack.push(trains[i]);
        backtrace(stack, outList, trains, i + 1, rst);
        stack.pop();
    }
}
