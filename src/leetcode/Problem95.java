package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-16 18:23
 **/
public class Problem95 {
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

    // Runtime: 1 ms, faster than 96.03% of Java online submissions for Unique Binary Search Trees II.
    //Memory Usage: 39.7 MB, less than 13.06% of Java online submissions for Unique Binary Search Trees II.
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int m, int n) {
        if (m > n)
            return null;
        List<TreeNode> list = new ArrayList<>();

        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(null);
        for (int i = m; i <= n; i++) {
            List<TreeNode> leftNodes = generateTrees(m, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, n);
            for (TreeNode leftNode : leftNodes == null ? tmp : leftNodes) {
                for (TreeNode rightNode : rightNodes == null ? tmp : rightNodes) {
                    list.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return list;
    }
}
