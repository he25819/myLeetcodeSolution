package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem76 {

    public static void main(String[] args) {
        System.out.println(new Problem76().minWindow("ADOBECODEBANC", "ABC"));
    }

    // Runtime: 6 ms, faster than 75.76% of Java online submissions for Minimum Window Substring.
    //Memory Usage: 39.5 MB, less than 48.94% of Java online submissions for Minimum Window Substring.
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Map<Character, Integer> remainMap = new HashMap<>();
        for (char c : tChars) {
            remainMap.put(c, remainMap.containsKey(c) ? remainMap.get(c) + 1 : 1);
        }

        int minLength = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int count = t.length(), positiveCount = t.length();
        int start = 0, end = 0;
        while (r < sChars.length) {
            char c = sChars[r++];
            Integer remain = remainMap.get(c);
            if (remain == null) {
                continue;
            }
            remainMap.put(c, --remain);
            count--;
            if (remain < 0) {
                continue;
            }
            if (--positiveCount == 0) {
                while (l < r && positiveCount == 0) {
                    char lc = sChars[l++];
                    Integer lRemain = remainMap.get(lc);
                    if (lRemain == null) {
                        continue;
                    }
                    remainMap.put(lc, ++lRemain);
                    count++;
                    if (lRemain <= 0) {
                        continue;
                    }
                    positiveCount++;
                    if (minLength > r - l) {
                        minLength = r - l;
                        start = l - 1;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}
