package leetcode;

public class Problem91 {
    // test case
    //"12"
    //"1"
    //"0"
    //"01"
    //"001"
    //"00"
    //"0260"
    //"026"
    //"260"
    //"1020"
    //"2006"
    //"110"
    //"17"
    //"27"

    // Runtime: 1 ms, faster than 98.86% of Java online submissions for Decode Ways.
    //Memory Usage: 37.8 MB, less than 67.38% of Java online submissions for Decode Ways.
    public int numDecodings(String s) {
        int[] nums = new int[s.length()];
        char[] chars = s.toCharArray();
        if (chars[0] < '1' || chars[0] > '9')
            return 0;
        else
            nums[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] != '1' && chars[i - 1] != '2')
                    return 0;
                else
                    if (i == s.length() - 1)
                        nums[i] = i == 1 ? 1 : nums[i - 2];
                    else
                        nums[i] = nums[i - 1];
            } else if (chars[i] > '6') {
                if (chars[i - 1] == '1')
                    nums[i] = nums[i - 1] + (i == 1 ? 1 : nums[i - 2]);
                else
                    nums[i] = nums[i - 1];
            } else {
                if (chars[i - 1] == '1' || chars[i - 1] == '2')
                    nums[i] = nums[i - 1] + (i == 1 ? 1 : nums[i - 2]);
                else
                    nums[i] = nums[i - 1];
            }
        }
        return nums[s.length() - 1];
    }
}
