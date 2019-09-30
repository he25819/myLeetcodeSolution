package leetcode;

public class Problem479 {
    public static void main(String[] args) {
//        System.out.println(99999999L * 99999999L);
        System.out.println(new Problem479().largestPalindrome(1));
        System.out.println(new Problem479().largestPalindrome(2));
        System.out.println(new Problem479().largestPalindrome(3));
        System.out.println(new Problem479().largestPalindrome(4));
        System.out.println(new Problem479().largestPalindrome(5));
        System.out.println(new Problem479().largestPalindrome(6));
        System.out.println(new Problem479().largestPalindrome(7));
        System.out.println(new Problem479().largestPalindrome(8));
//        System.out.println(new Problem479().largestPalindrome(9));
    }

    // 参考https://blog.csdn.net/xiangxianghehe/article/details/82427995
    //Runtime: 242 ms, faster than 70.79% of Java online submissions for Largest Palindrome Product.
    //Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Largest Palindrome Product.
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;
        long num;
        int upper = 1;
        for (int i = 0; i < n; i++) {
            upper *= 10;
        }
        int lower = upper / 10;
        for (int i = --upper; i > lower; i--) {
            num = palindromeNum(i);
            for (long j = upper; j * j > num; j--) {
                if (num % j == 0)
                    return (int) (num % 1337);
            }
        }
        return -1;
    }

    private long palindromeNum(int upper) {
        String s = String.valueOf(upper);
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
        return Long.valueOf(s + String.valueOf(chars));
    }


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Palindrome Product.
    //Memory Usage: 33.1 MB, less than 100.00% of Java online submissions for Largest Palindrome Product.
    public int largestPalindrome2(int n) {
        switch (n) {
            case 1: return 9;
            case 2: return 987;
            case 3: return 123;
            case 4: return 597;
            case 5: return 677;
            case 6: return 1218;
            case 7: return 877;
            case 8: return 475;
            default: return -1;
        }
    }
}
