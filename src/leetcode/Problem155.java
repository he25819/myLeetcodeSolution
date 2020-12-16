package leetcode;

import java.util.Stack;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-12-01 11:35
 **/
public class Problem155 {

    // Runtime: 5 ms, faster than 49.30% of Java online submissions for Min Stack.
    //Memory Usage: 40.7 MB, less than 66.67% of Java online submissions for Min Stack.
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            minStack.push(Math.min(minStack.empty() ? Integer.MAX_VALUE : minStack.peek(), x));
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
