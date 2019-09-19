package leetcode;

import java.util.Arrays;

public class Problem66 {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(new Problem66().plusOne(nums)));
    }

    public int[] plusOne(int[] digits) {
        boolean over = true;
        int i = digits.length - 1;
        while (over && i >= 0) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i--] != 0) {
                over = false;
            }
        }
        if (over) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
