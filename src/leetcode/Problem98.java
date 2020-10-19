package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-19 10:37
 **/
public class Problem98 {
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
    /* test cases
    [1,1,3]
            []
            [5,1,4,null,null,3,6]
            [10,5,15,null,null,6,20]
            [2147483647]
    */

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    //    Memory Usage: 38.5 MB, less than 8.71% of Java online submissions for Validate Binary Search Tree.
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null)
            return true;
        if (node.left != null && node.right != null)
            return node.val >= min
                    && node.val <= max
                    && isValidBST(node.left, min, node.val - 1)
                    && isValidBST(node.right, node.val + 1, max)
                    && node.val > node.left.val
                    && node.val < node.right.val;
        if (node.left != null)
            return node.val >= min
                    && node.val <= max
                    && isValidBST(node.left, min, node.val - 1)
                    && node.val > node.left.val;
        if (node.right != null)
            return node.val >= min
                    && node.val <= max
                    && isValidBST(node.right, node.val + 1, max)
                    && node.val < node.right.val;
        return node.val >= min
                && node.val <= max;
    }
}
