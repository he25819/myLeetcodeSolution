package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 15:29
 **/
public class Problem94 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 中序遍历
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
    //Memory Usage: 37.4 MB, less than 6.96% of Java online submissions for Binary Tree Inorder Traversal.
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        traversal(rst, root);
        return rst;
    }

    private void traversal(List<Integer> rst, TreeNode node) {
        if (node == null)
            return;
        traversal(rst, node.left);
        rst.add(node.val);
        traversal(rst, node.right);
    }

}
