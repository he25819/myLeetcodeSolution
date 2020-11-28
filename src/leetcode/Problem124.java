package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-28 11:41
 **/
public class Problem124 {
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
[1,2,3]
[]
[1]
[-10,9,20,null,null,15,7]
 */

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
    //Memory Usage: 41.1 MB, less than 31.28% of Java online submissions for Binary Tree Maximum Path Sum.
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        maxSum = Math.max(maxSum, node.val);
        int left = helper(node.left);
        maxSum = Math.max(maxSum, left + node.val);
        int right = helper(node.right);
        maxSum = Math.max(maxSum, right + node.val);

        maxSum = Math.max(maxSum, left + right + node.val);
        return Math.max(0, Math.max(left, right)) + node.val;
    }
}
