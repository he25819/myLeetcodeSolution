package leetcode;


public class Problem226 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
    //Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Invert Binary Tree.
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }
}
