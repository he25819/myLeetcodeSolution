package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-30 16:56
 **/
public class Problem337 {

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

    // Runtime: 687 ms, faster than 13.66% of Java online submissions for House Robber III.
    //Memory Usage: 39.1 MB, less than 9.88% of Java online submissions for House Robber III.
    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        int max = root.val;
        if (root.left != null)
            max += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            max += rob(root.right.left) + rob(root.right.right);

        return Math.max(max, rob(root.left) + rob(root.right));
    }
}
