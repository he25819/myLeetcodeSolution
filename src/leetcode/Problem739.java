package leetcode;

import java.util.Stack;

/**
 * @author hexw
 * @version 1.0
 * @create 2021-03-05 15:23
 **/
public class Problem739 {
    // Runtime: 16 ms, faster than 62.16% of Java online submissions for Daily Temperatures.
    //Memory Usage: 46.5 MB, less than 97.66% of Java online submissions for Daily Temperatures.
    public int[] dailyTemperatures(int[] T) {
        int[] rst = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            if (stack.empty()) {
                rst[i] = 0;
                stack.push(i);
            } else if (T[i] < T[stack.peek()]) {
                rst[i] = stack.peek() - i;
                stack.push(i);
            } else {
                stack.pop();
                i++;
            }
        }
        return rst;
    }
}
