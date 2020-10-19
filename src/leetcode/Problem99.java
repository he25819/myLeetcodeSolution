package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-19 14:35
 **/
public class Problem99 {
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


    public static void main(String[] args) {
        new Problem99().recoverTree2(new TreeNode(2, null, new TreeNode(1)));
    }

    // 参考https://www.cnblogs.com/ariel-dreamland/p/9159781.html
    // 思路最简单
    // Runtime: 4 ms, faster than 20.10% of Java online submissions for Recover Binary Search Tree.
    //Memory Usage: 39.2 MB, less than 14.45% of Java online submissions for Recover Binary Search Tree.
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        helper(root, nodes, list);
        list.sort(Integer::compareTo);
        for (int i = 0; i < nodes.size(); i++)
            nodes.get(i).val = list.get(i);
    }

    private void helper(TreeNode root, List<TreeNode> nodes, List<Integer> list) {
        if (root == null)
            return;
        helper(root.left, nodes, list);
        nodes.add(root);
        list.add(root.val);
        helper(root.right, nodes, list);
    }

/*
    ↑
    |                                *
    |             *                 
    |                          *
    |                      *
    |                   *
    |                *
    |                              *
    |           *
    |        *
    |     *
    |  *
    ------------------------------------------------>
    挨个比较（inorder），如果当前val小于prev.val，则出现错乱，最多2处错乱（可能只有1处），swap即可。
    有了思路随便怎么写都很好写了。
*/
    // Runtime: 2 ms, faster than 82.99% of Java online submissions for Recover Binary Search Tree.
//Memory Usage: 39.2 MB, less than 14.45% of Java online submissions for Recover Binary Search Tree.
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree2(TreeNode root) {
        inorder(root);
        swap(first, second);
    }

    private void swap(TreeNode first, TreeNode second) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
                return;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
