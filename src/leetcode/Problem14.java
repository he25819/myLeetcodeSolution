package leetcode;

public class Problem14 {

    public static void main(String[] args) {
        System.out.println(new Problem14().longestCommonPrefix(new String[]{"aa", "a"}));
    }

    // Runtime: 1 ms, faster than 57.37% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 37.6 MB, less than 84.21% of Java online submissions for Longest Common Prefix.
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        char[] chars = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || chars[i] != strs[j].charAt(i))
                    return sb.toString();
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
