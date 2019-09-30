package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem738 {
    public static void main(String[] args) {
        System.out.println(new Problem738().monotoneIncreasingDigits(127490));
    }

    //Runtime: 2 ms, faster than 16.77% of Java online submissions for Monotone Increasing Digits.
    //Memory Usage: 33.8 MB, less than 20.00% of Java online submissions for Monotone Increasing Digits.
    public int monotoneIncreasingDigits(int N) {
        if (N == 0)
            return 0;
        String s = String.valueOf(N);

        char[] chars = s.toCharArray();

        List<Character> num = new ArrayList<>();
        num.add(chars[0]);
        boolean isAllNine = false;
        while (num.size() != chars.length) {
            if (isAllNine) {
                num.add('9');
                continue;
            }
            char l = num.get(num.size() - 1);
            char r = chars[num.size()];
            while (l > r) {
                isAllNine = true;
                r = (char) (l - 1);
                num.remove(num.size() - 1);
                if (num.isEmpty())
                    break;
                l = num.get(num.size() - 1);
            }
            num.add(r);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num.size(); i++)
            sb.append(num.get(i));
        return Integer.valueOf(sb.toString());
    }
}
