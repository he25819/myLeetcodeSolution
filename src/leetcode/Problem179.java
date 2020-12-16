package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-28 16:43
 **/
public class Problem179 {
    /* test cases
[10,2]
[3,30,34,5,9]
[1]
[10]
[0,1,2,0,53,1,5,3,4,15,6,161,45,435,346,246,524]
[1,0]
[432,43243]
[43243,432]
[0,0]
     */
    public static void main(String[] args) {
        System.out.println(new Problem179().largestNumber(new int[]{432, 43243}));
    }


    // Runtime: 8 ms, faster than 25.76% of Java online submissions for Largest Number.
    //Memory Usage: 38.3 MB, less than 75.09% of Java online submissions for Largest Number.
    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted((o2, o1) -> {
            String s1 = o1.toString();
            String s2 = o2.toString();
            if (s1.length() == s2.length())
                return o1 - o2;
            if (s1.charAt(0) != s2.charAt(0))
                return s1.charAt(0) - s2.charAt(0);
            boolean leftLonger;
            int deltaLen;
            if (s1.length() > s2.length()) {
                leftLonger = true;
                deltaLen = s1.length() - s2.length();
                s2 += s1.substring(0, deltaLen);
            } else {
                leftLonger = false;
                deltaLen = s2.length() - s1.length();
                s1 += s2.substring(0, deltaLen);
            }
            int delta = Integer.parseInt(s1) - Integer.parseInt(s2);
            if (delta != 0)
                return delta;
            return leftLonger ? o2 - Integer.parseInt(s1.substring(deltaLen)) : Integer.parseInt(s2.substring(deltaLen)) - o1;
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            if (i != 0 || sb.length() > 0)
                sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
