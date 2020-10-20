package leetcode;

import java.util.Stack;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-20 13:58
 **/
public class Problem116 {
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

    public static void main(String[] args) {
        new Problem116().connect(new Node(1, new Node(2), new Node(3), null));
    }


    // Runtime: 1 ms, faster than 55.64% of Java online submissions for Populating Next Right Pointers in Each Node.
    //Memory Usage: 38.9 MB, less than 15.35% of Java online submissions for Populating Next Right Pointers in Each
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
