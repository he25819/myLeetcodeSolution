package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        System.out.println(new Problem22().generateParenthesis(9));
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
    //Memory Usage: 39.8 MB, less than 17.42% of Java online submissions for Generate Parentheses.
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add("");
            return list;
        }

        backtrack(list, new StringBuilder(), n, n);

        return list;
    }

    private void backtrack(List<String> list, StringBuilder sb, int i, int j) {
        if (j == 0) {
            list.add(sb.toString());
            return;
        }
        if (i == 0) {
            sb.append(')');
            backtrack(list, sb, i, --j);
            sb.deleteCharAt(sb.length() - 1);
        } else if (i == j) {
            sb.append('(');
            backtrack(list, sb, --i, j);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('(');
            backtrack(list, sb, --i, j);
            sb.deleteCharAt(sb.length() - 1);
            i++;

            sb.append(')');
            backtrack(list, sb, i, --j);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
