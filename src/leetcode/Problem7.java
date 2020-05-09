package leetcode;

public class Problem7 {

    public static void main(String[] args) {
        System.out.println(new Problem7().reverse(123));
    }

    // Runtime: 2 ms, faster than 28.90% of Java online submissions for Reverse Integer.
    //Memory Usage: 36.8 MB, less than 5.55% of Java online submissions for Reverse Integer.
    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int l = chars[0] == '-' ? 1 : 0, r = chars.length - 1;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }

        int res = 0;
        try {
            res = Integer.parseInt(String.valueOf(chars));
        } catch (NumberFormatException ignored) {
        }

        return res;
    }
}
