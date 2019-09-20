package leetcode;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Problem404 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Problem404().sumOfLeftLeaves(root));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    //Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Sum of Left Leaves.
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode l = root.left, r = root.right;
        if (l != null && l.left == null && l.right == null)
            return l.val + sumOfLeftLeaves(r);
        return sumOfLeftLeaves(l) + sumOfLeftLeaves(r);
    }
}