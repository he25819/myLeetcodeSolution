package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-28 13:59
 **/
public class Problem125 {

    // Runtime: 3 ms, faster than 61.60% of Java online submissions for Valid Palindrome.
    //Memory Usage: 39.4 MB, less than 40.71% of Java online submissions for Valid Palindrome.
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isAlphanumeric(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(j))) {
                j--;
                continue;
            }
            if (!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return ((c >= '0' && c <= '9')
                || ((c >= 'a') && (c <= 'z'))
                || ((c >= 'A') && (c <= 'Z')));
    }
}
