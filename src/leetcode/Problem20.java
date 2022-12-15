package leetcode;

import java.util.Stack;

public class Problem20 {
    // Runtime
    //1 ms
    //Beats
    //99.74%
    //Memory
    //40.1 MB
    //Beats
    //93.33%
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.empty() || '(' != stack.pop())
                        return false;
                    break;
                case ']':
                    if (stack.empty() || '[' != stack.pop())
                        return false;
                    break;
                case '}':
                    if (stack.empty() || '{' != stack.pop())
                        return false;
                    break;
            }
        }
        return stack.empty();
    }
}
