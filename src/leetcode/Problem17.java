package leetcode;

import java.util.*;

public class Problem17 {

    public static void main(String[] args) {
        System.out.println(new Problem17().letterCombinations("23"));
    }

    private static final char[] TWO = new char[]{'a', 'b', 'c'};
    private static final char[] THREE = new char[]{'d', 'e', 'f'};
    private static final char[] FOUR = new char[]{'g', 'h', 'i'};
    private static final char[] FIVE = new char[]{'j', 'k', 'l'};
    private static final char[] SIX = new char[]{'m', 'n', 'o'};
    private static final char[] SEVEN = new char[]{'p', 'q', 'r', 's'};
    private static final char[] EIGHT = new char[]{'t', 'u', 'v'};
    private static final char[] NINE = new char[]{'w', 'x', 'y', 'z'};
    private static final Map<Integer, char[]> map = new HashMap<>();

    {
        map.put(2, TWO);
        map.put(3, THREE);
        map.put(4, FOUR);
        map.put(5, FIVE);
        map.put(6, SIX);
        map.put(7, SEVEN);
        map.put(8, EIGHT);
        map.put(9, NINE);
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
    //Memory Usage: 38.2 MB, less than 6.16% of Java online submissions for Letter Combinations of a Phone Number.
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        int[] nums = new int[digits.length()];
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        List<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), nums, 0);

        return list;
    }

    private void backtrack(List<String> list, StringBuilder sb, int[] nums, int i) {
        if (i >= nums.length) {
            list.add(sb.toString());
            return;
        }
        char[] chars = map.get(nums[i]);
        for (char aChar : chars) {
            sb.append(aChar);
            backtrack(list, sb, nums, i + 1);
            sb.deleteCharAt(i);
        }
    }
}
