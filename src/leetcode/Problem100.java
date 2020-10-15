package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 17:20
 **/
public class Problem100 {
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

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
    //Memory Usage: 36.2 MB, less than 15.90% of Java online submissions for Same Tree.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
