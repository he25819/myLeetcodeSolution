package leetcode;

import java.util.Stack;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-20 15:48
 **/
public class Problem117 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 代码与Problem116一模一样
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
    //Memory Usage: 38.5 MB, less than 7.13% of Java online submissions for Populating Next Right Pointers in Each Node II.
    private final Stack<Node> stack = new Stack<>();
    public Node connect(Node root) {
        if (root == null)
            return null;

        root.next = stack.isEmpty() ? null : stack.pop();
        connect(root.right);
        connect(root.left);
        stack.push(root);
        return root;
    }
}
