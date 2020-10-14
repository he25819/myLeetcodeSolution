package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 14:41
 **/
public class Problem93 {

    // Runtime: 1 ms, faster than 99.56% of Java online submissions for Restore IP Addresses.
    //Memory Usage: 38.9 MB, less than 12.56% of Java online submissions for Restore IP Addresses.
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        List<String> rst = new ArrayList<>();
        helper(rst, s, 0, s.length(), new ArrayList<>());
        return rst;
    }

    private void helper(List<String> rst, String s, int left, int right, ArrayList<String> list) {
        if (left == right) {
            if (list.size() == 4) {
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(0)).append('.')
                        .append(list.get(1)).append('.')
                        .append(list.get(2)).append('.')
                        .append(list.get(3));
                rst.add(sb.toString());
            }
            return;
        }
        if (list.size() > 4)
            return;
        for (int i = 1; i <= 3; i++) {
            if (left + i > right || (s.charAt(left) == '0' && i != 1))
                break;
            String subString = s.substring(left, left + i);
            if (Integer.parseInt(subString) > 255)
                break;
            list.add(subString);
            helper(rst, s, left + i, right, list);
            list.remove(list.size() - 1);
        }
    }
}
