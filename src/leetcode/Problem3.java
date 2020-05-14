package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(new Problem3().lengthOfLongestSubstring("gadfdagfdsgrdf"));
    }


    // Runtime: 6 ms, faster than 73.02% of Java online submissions for Longest Substring Without Repeating Characters.
    //Memory Usage: 40 MB, less than 10.15% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        int maxLength = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        while (r < chars.length) {
            Integer idx = idxMap.get(chars[r]);
            if (idx == null) {
                idxMap.put(chars[r], r++);
                maxLength = Math.max(maxLength, r - l);
            } else {
                for (int i = l; i < idx; i++) {
                    idxMap.remove(chars[i]);
                }
                idxMap.put(chars[idx], r++);
                l = idx + 1;
            }
        }
        return maxLength;
    }
}
