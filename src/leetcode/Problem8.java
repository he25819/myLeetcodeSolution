package leetcode;

public class Problem8 {
    public static void main(String[] args) {
        new Problem8().myAtoi(" +1 1");
    }

    /**
     my input:
     "42"
     "4193 with words"
     "words and 987"
     "   -42"
     "-91283472332"
     ""
     "  +1 2 "
     " + 1 "
     "\t1"
     "111111111111111111111111111111111111"
     "1+2"
     "++1"
     "+002"
     "+00000000000000000000000000000000000000000000000000000000000002147483647"
     "-000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483647"
     "-000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483648"
     "-000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483649"

     * @param str
     * @return
     */
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int st = 0;
        while ((st < chars.length) && (chars[st] == ' ')) {
            st++;
        }
        if (st > 0) {
            str = str.substring(st, chars.length);
            chars = str.toCharArray();
        }
        if (str.length() == 0) {
            return 0;
        }

        boolean isPositive;
        int len = chars.length;
        if (chars[0] == '+' || (chars[0] >= '0' && chars[0] <= '9')) {
            isPositive = true;
        } else if (chars[0] == '-') {
            isPositive = false;
        } else {
            return 0;
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                len = i;
                break;
            }
        }
        if (len < chars.length) {
            str = new String(chars, 0, len);
        }
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            if (str.length() == 1) {
                return 0;
            }
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
}
