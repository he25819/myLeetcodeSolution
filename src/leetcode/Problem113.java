package leetcode;

import utils.Stopwatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem113 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        Stopwatch.start();
        System.out.println(new Problem113().pathSum(root, 22));
        Stopwatch.stop();
    }

    //Runtime: 2 ms, faster than 37.03% of Java online submissions for Path Sum II.
    //Memory Usage: 39 MB, less than 95.45% of Java online submissions for Path Sum II.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, sum, result);
        return result;
    }

    private List<LinkedList<Integer>> dfs(TreeNode root, int sum, List<List<Integer>> result) {
        if (root == null)
            return null;
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            LinkedList<Integer> aSolution = new LinkedList<>();
            aSolution.add(root.val);
            result.add(aSolution);
            List<LinkedList<Integer>> list = new ArrayList<>();
            list.add(aSolution);
            return list;
        } else {
            List<LinkedList<Integer>> leftList = dfs(root.left, sum, result);
            if (leftList != null)
                for (LinkedList<Integer> aSolution : leftList)
                    aSolution.addFirst(root.val);
            List<LinkedList<Integer>> rightList = dfs(root.right, sum, result);
            if (rightList != null)
                for (LinkedList<Integer> aSolution : rightList)
                    aSolution.addFirst(root.val);
            if (leftList != null && rightList != null) {
                leftList.addAll(rightList);
                return leftList;
            } else if (leftList == null) {
                return rightList;
            } else {
                return leftList;
            }
        }
    }
}
