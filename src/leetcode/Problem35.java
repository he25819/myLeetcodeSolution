package leetcode;

public class Problem35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(new Problem35().searchInsert(nums, 5));
        System.out.println(new Problem35().searchInsert(nums, 2));
        System.out.println(new Problem35().searchInsert(nums, 7));
        System.out.println(new Problem35().searchInsert(nums, 0));
        System.out.println(new Problem35().searchInsert(nums, 4));
    }
    //    35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int lt = 0, rt = nums.length - 1;
        return searchInsert(nums, target, lt, rt);
    }

    private int searchInsert(int[] nums, int target, int lt, int rt) {
        if (lt > rt) {
            return lt;
        }
        int mid = (lt + rt) / 2;
        if (nums[mid] < target) {
            return searchInsert(nums, target, mid + 1, rt);
        } else if (nums[mid] > target) {
            return searchInsert(nums, target, lt, mid - 1);
        } else {
            return mid;
        }
    }
}