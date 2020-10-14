package leetcode;


public class Problem112 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // [-2,null,-3]
    //-5
    //可能是负数！
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
    //Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Path Sum.
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return dfs(root.left, sum) || dfs(root.right, sum);
        }
    }
}
