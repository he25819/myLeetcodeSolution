package leetcode;

public class Problem9 {
    public static void main(String[] args) {

    }

    // Runtime: 7 ms, faster than 74.10% of Java online submissions for Palindrome Number.
    //Memory Usage: 38.6 MB, less than 5.02% of Java online submissions for Palindrome Number.
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            if (chars[i] != chars[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
