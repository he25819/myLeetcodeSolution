package leetcode;

public class Problem26 {
    public static void main(String[] args) {
        System.out.println(new Problem26().removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 4}));;
    }
//    26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int lt = 1, rt;
        int currentMax = nums[0];
        for (rt = 1; rt < nums.length; rt++) {
            if (currentMax < nums[rt]) {
                currentMax = nums[rt];
                nums[lt++] = nums[rt];
            }
        }
        return lt;
    }
}
