package leetcode;

public class Problem917 {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Only Letters.
    //Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Reverse Only Letters.
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0)
            return "";
        char[] chars = S.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (!((chars[l] >= 'a' && chars[l] <= 'z') || (chars[l] >= 'A' && chars[l] <= 'Z'))) {
                l++;
                continue;
            }
            if (!((chars[r] >= 'a' && chars[r] <= 'z') || (chars[r] >= 'A' && chars[r] <= 'Z'))) {
                r--;
                continue;
            }
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
        return String.valueOf(chars);
    }
}
