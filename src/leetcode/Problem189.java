package leetcode;

public class Problem189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Problem189().rotate(nums, 3);
    }

    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        int sub;
        for (int i = k, j = 0; j < nums.length; i++, j++) {
            sub = i % nums.length;
            nums[sub] = copy[j];
        }
    }
}
