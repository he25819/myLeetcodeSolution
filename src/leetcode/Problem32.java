package leetcode;

import java.util.Stack;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-13 13:28
 **/
public class Problem32 {
    /* my test case
    "(()"
            "(()()"
            "(()()()()"
            "(()()("
            ")()())"
            "))((()()()()()))(())"
            "(((((((((((((((((((((()))))))))))))))))))))(((((((((("
            "))))))((((((((((()())))))))((((((((()))))))(((((())))))"
            "(((((((())()()))"
            "(((((((((()()()(())()))))"
    */
    public static void main(String[] args) {
        System.out.println(new Problem32().longestValidParentheses("))((()()()()()))(())"));
    }
    // Runtime: 2 ms, faster than 74.47% of Java online submissions for Longest Valid Parentheses.
    //Memory Usage: 38.7 MB, less than 12.41% of Java online submissions for Longest Valid Parentheses.
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int preLength = 0;
        Stack<Integer> startIndexStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                startIndexStack.push(i);
            } else {
                if (startIndexStack.isEmpty()) {
                    preLength = 0;
                    continue;
                }
                int start = startIndexStack.pop();
                if (!startIndexStack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - startIndexStack.peek());
                } else {
                    int length = i - start + 1;
                    preLength += length;
                    maxLength = Math.max(maxLength, preLength);
                }
            }
        }
        return maxLength;
    }


    // Runtime: 2 ms, faster than 74.47% of Java online submissions for Longest Valid Parentheses.
    //Memory Usage: 38.9 MB, less than 12.41% of Java online submissions for Longest Valid Parentheses.
    public int longestValidParentheses2(String s) {
        int maxLength = 0;
        Stack<Integer> startIndexStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (startIndexStack.isEmpty())
                    startIndexStack.push(i - 1);
                startIndexStack.push(i);
            } else {
                if (startIndexStack.isEmpty()) {
                    continue;
                }
                startIndexStack.pop();
                if (!startIndexStack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - startIndexStack.peek());
                }
            }
        }
        return maxLength;
    }
}
