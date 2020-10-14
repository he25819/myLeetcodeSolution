package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-13 17:59
 **/
public class Problem28 {
    // Runtime: 2 ms, faster than 49.39% of Java online submissions for Implement strStr().
    //Memory Usage: 37.2 MB, less than 21.31% of Java online submissions for Implement strStr().
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        a: for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    continue a;
                j++;
            }
            return i;
        }
        return -1;
    }
}
