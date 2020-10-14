package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem993 {
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

    //Runtime: 1 ms, faster than 69.93% of Java online submissions for Cousins in Binary Tree.
    //Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Cousins in Binary Tree.
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y)
            return false;

        List<TreeNode> cousins = new ArrayList<>();
        cousins.add(root.left);
        cousins.add(root.right);

        while (cousins.size() > 0) {
            int correct = 0;
            for (int i = 0; i < cousins.size() - 1; i += 2) {
                if (cousins.get(i) != null && ((cousins.get(i).val == x) || cousins.get(i).val == y)) {
                    correct++;
                    continue;
                }
                if (cousins.get(i + 1) != null && ((cousins.get(i + 1).val == x) || cousins.get(i + 1).val == y))
                    correct++;
            }
            if (correct == 2)
                return true;
            List<TreeNode> children = new ArrayList<>();
            for (int i = 0; i < cousins.size(); i++) {
                if (cousins.get(i) != null)
                    children.add(cousins.get(i).left);
                if (cousins.get(i) != null)
                    children.add(cousins.get(i).right);
            }
            cousins = children;
        }
        return false;
    }
}
