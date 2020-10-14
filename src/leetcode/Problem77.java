package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 14:20
 **/
public class Problem77 {

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Combinations.
    //Memory Usage: 40.5 MB, less than 17.81% of Java online submissions for Combinations.
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        int left = 1;
        helper(rst, left, n, new ArrayList<>(), k);
        return rst;
    }

    private void helper(List<List<Integer>> rst, int left, int n, ArrayList<Integer> list, int k) {
        if (n - left + 1 + list.size() < k)
            return;
        list.add(left);
        if (list.size() == k) {
            rst.add(new ArrayList<>(list));
        } else {
            helper(rst, left + 1, n, list, k);
        }
        list.remove(list.size() - 1);
        helper(rst, left + 1, n, list, k);
    }
}
