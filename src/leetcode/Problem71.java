package leetcode;

import java.util.Stack;

public class Problem71 {
    public static void main(String[] args) {
        new Problem71().simplifyPath("/a/b/s///sdf/a/g/");
    }

    // Runtime: 5 ms, faster than 69.48% of Java online submissions for Simplify Path.
    //Memory Usage: 39.9 MB, less than 6.56% of Java online submissions for Simplify Path.
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if ("..".equals(s)) {
                if (!stack.empty())
                    stack.pop();
            } else if (".".equals(s) || s.length() == 0) {
                continue;
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            String s = stack.pop();
            sb.insert(0, s).insert(0, '/');
        }
        if (sb.length() == 0)
            return "/";
        return sb.toString();
    }
}
